window.onload = function() {

    $(function() {
	$('#tabs').tabs();
    });

    loadAllConfigs();
    //loadBatchLogs();
    batchLogsUtil = new BatchLogsUtil();
    batchLogsUtil.loadBatchLogs();
    externalConfigUtil = new ExternalConfigUtil();
    externalConfigUtil.loadQAConfig();
    externalConfigUtil.loadProdConfig();
};

function loadAllConfigsOnClick() {

    loadAllConfigs();
    showMessage("Refresh successful!");
}

function loadBatchLogs() {

    $
    .getJSON(
	    '/configmanager/rest/logs',
	    function(data) {
		$('#batch-logs-div').html('');
		$.each(data, function(index, item) {
		    $('#batch-logs-div').append('<br>' + JSON.stringify(eval(item)) + '</br>');
		});
	    }
	    );
}

function addConfigRow(index, item) {

    var uploadToFP = "", cloneButton = "", modifyButton = "", promoteStateButton = "", activateButton = "";

    uploadToFP = '<input type="button" id="uploadToFP" value="Activate on FP">&nbsp;&nbsp;';

    if (item.status === "ACTIVE") {
	cloneButton = '<input class="ui-button ui-widget ui-state-default ui-corner-all" type="button" id="clone" value="Clone">&nbsp;&nbsp;';
    }
    else if (item.status === "INACTIVE" || item.status === "PROMOTION_FAILED" || item.status === "ACTIVATION_FAILED") {
	modifyButton = '<input type="button" id="modify" value="Modify">&nbsp;&nbsp;';
    }

    if (item.status === "ACTIVE" || item.status === "INACTIVE") {

	if (item.state === "DRAFT" && 
		count.promoteStagingCount === 0) {
	    promoteStateButton = '<input class="workflow-link" type="button" id="promoteToStaging" value="Promote To Staging">&nbsp;&nbsp;';
	    count.promoteStagingCount = 1;
	}
	else if (item.state === "STAGING" && item.status === "INACTIVE" && 
		count.activateStagingCount === 0) {
	    activateButton = '<input class="workflow-link" type="button" id="activate" value="Activate On Staging">&nbsp;&nbsp;';
	    count.activateStagingCount = 1;
	}
	else if (item.state === "STAGING" && item.status === "ACTIVE"){
	    promoteStateButton = '<input class="workflow-link" type="button" id="promoteToProduction" value="Promote To Production">&nbsp;&nbsp;';
	}
	else if (item.state === "PRODUCTION" && item.status === "INACTIVE" && 
		count.activateProductionCount === 0) {
	    activateButton = '<input class="workflow-link" type="button" id="activate" value="Activate On Production">&nbsp;&nbsp;';
	    count.activateProductionCount = 1;
	}
    }

    $("#configbody")
    .append(
	    '<tr><td id=\'itemId\' style=\'display:none\'>'
	    + item._id.$oid
	    + '</td><td>'
	    + (index + 1)
	    + '</td><td>'
	    + item.md5
	    + '</td><td>'
	    + item.filename
	    + '</td><td>'
	    + item.author
	    + '</td><td  width="10%">'
	    + item.desc
	    + '</td><td>'
	    + item.version
	    + '</td><td>'
	    + item.parentVersion
	    + '</td><td id=\'state\'>'
	    + item.state
	    + '</td><td>'
	    + item.status
	    + '</td><td>'
	    + new Date(item.updateDate.$date).toUTCString()
	    + '</td><td width="360px">'
	    + '<a type="button" class="ui-button ui-widget ui-state-default ui-corner-all" href="/configmanager/rest/download?id='
	    + item._id.$oid
	    + '">Download</a>&nbsp;&nbsp;'
	    + uploadToFP
	    + cloneButton
	    + modifyButton
	    + '</td><td align="center" style="cell-padding:2px;">'
	    + promoteStateButton
	    + activateButton
	    + '</td></tr>');

    $('#configbody > tr:nth-child(' + (index + 1) + ') > td #uploadToFP')
    .button().click(function() {
	$("#uploadForm").data("id", item._id.$oid).dialog("open");
    });

    $('#configbody > tr:nth-child(' + (index + 1) + ') > td #modify').button()
    .click(function() {
	$("#modifyForm").data("item", item).dialog("open");
	return false;
    });

    $('#configbody > tr:nth-child(' + (index + 1) + ') > td #promoteToStaging').button()
    .click(function() {
	var data = {
		'id' : item._id.$oid,
		'state' : "STAGING",
		'warning' : "" 
	};

	var message = "Please confirm to Promote the Configuration to Staging";
	$("#workflowForm").data("data", data).dialog('option','title',message).dialog("open");
	return false;
    });

    $('#configbody > tr:nth-child(' + (index + 1) + ') > td #promoteToProduction').button()
    .click(function() {
	var warning = "";
	if (item.parentState !== "PRODUCTION")
	    warning = "Warning: Parent Config is not available on Production";
	var data = {
		'id' : item._id.$oid,
		'state' : "PRODUCTION",
		'warning' : warning
	};

	var message = "Please confirm to Promote the Configuration to Production";
	$("#workflowForm").data("data", data).dialog('option','title',message).dialog("open");
	return false;
    });

    $('#configbody > tr:nth-child(' + (index + 1) + ') > td #activate').button()
    .click(function() {
	var warning = "";
	if (item.state === "STAGING" && !(item.parentState == "STAGING" && item.parentStatus == "ACTIVE"))
	    warning = "Warning: Parent Config is not active on Staging";
	else if (!(item.parentState == "PRODUCTION" && item.parentStatus == "ACTIVE"))
	    warning = "Warning: Parent Config is not active on Production";
	var data = {
		'id' : item._id.$oid,
		'state' : item.state,
		'status' : "ACTIVE",
		'warning' : warning
	};

	var message = "Please confirm to Activate the Configuration";
	$("#workflowForm").data("data", data).dialog('option','title',message).dialog("open");
	return false;
    });
}

function loadAllConfigs() {

    count = {
	    "promoteStagingCount" : 0,   
	    "activateStagingCount" : 0,   
	    "activateProductionCount" : 0
    };
    $
    .getJSON(
	    '/configmanager/rest/all',
	    function(data) {
		$("#configbody").html('');
		$.each(data, function(index, item) {
		    addConfigRow(index, item);
		});
		$('#configbody #clone').click(clone);
		$('#configbody #uploadToFP').click(uploadToFP);
		$("#workflowForm")
		.dialog(
			{
			    autoOpen : false,
			    show : 'slide',
			    resizable : false,
			    position : 'center',
			    stack : true,
			    height : 'auto',
			    width : 'auto',
			    modal : true,
			    open : function() {

				$("#warning").html($(this).data("data").warning);
			    },
			    buttons : {
				"Trigger Now" : function(e) {
				    var data = $(this).data("data");
				    data.triggerNow = true;
				    if (data.status === "ACTIVE")
					activate(data);
				    else
					changeState(data);
				    $(this).dialog("close");
				},
				"Add to Batch Queue" : function(e) {
				    var data = $(this).data("data");
				    data.triggerNow = false;
				    if (data.status === "ACTIVE")
					activate(data);
				    else
					changeState(data);
				    $(this).dialog("close");
				},
				Cancel : function() {
				    $(this).dialog("close");
				}
			    }
			});
		$("#uploadForm")
		.dialog(
			{
			    autoOpen : false,
			    show : 'slide',
			    resizable : false,
			    position : 'center',
			    stack : true,
			    height : 'auto',
			    width : 'auto',
			    modal : true,
			    buttons : {
				"Submit" : function(e) {

				    var id = $(this).data("id");
				    var fp = $("#fp")
				    .val();

				    if ($("#fp").val() == "")
					return false;

				    $
				    .ajax({
					type : "POST",
					url : '/configmanager/rest/numeupload/fp?id='
					    + id
					    + '&host='
					    + fp,
					    contentType : "text/plain",
					    success : function(response) {
						loadAllConfigs();
						showMessage("Activate Message: " + JSON.stringify(eval(response)));
					    },
					    error : function(response) {
						loadAllConfigs();
						showMessage("Activate Error Message: " + JSON.stringify(eval(response)));
					    }
				    });

				    $(this).dialog("close");
				},
				Cancel : function() {
				    $(this).dialog("close");
				}
			    }
			});
		$("#modifyForm")
		.dialog(
			{
			    autoOpen : false,
			    show : 'slide',
			    resizable : false,
			    position : 'center',
			    stack : true,
			    height : 'auto',
			    width : 'auto',
			    modal : true,
			    open : function() {

				var id = $(this).data("item")._id.$oid;
				$("#_id").val(id);
				var desc = $(this).data("item").desc;
				$("#desc").val(desc);
			    },
			    buttons : {
				"Submit" : function(e) {

				    $('#iframe-post-form')
				    .load(
					    function(response) {
						loadAllConfigs();
						showMessage("Modified Config");
					    });

				    if ($("#desc").val() == "")
					return false;

				    $(this).submit();
				    $(this).dialog("close");
				    return false;
				},
				"Cancel" : function() {
				    $(this).dialog("close");
				}
			    }
			});
	    });
}

function clone() {

    var id = $(this).parent().parent().children('#itemId')[0].innerHTML;
    data = {
	    'id' : id
    };
    $.ajax({
	type : "POST",
	url : '/configmanager/rest/draft',
	contentType : "text/plain",
	data : JSON.stringify(eval(data)),
	success : function(response) {
	    loadAllConfigs();
	    showMessage("Created Draft Config: " + JSON.stringify(eval(response)));
	}
    });
}

function uploadToFP() {

    $("#uploadToFP").dialog('open');
}

function changeState(data) {

    $.ajax({
	type : "PUT",
	url : '/configmanager/rest/state/change',
	contentType : "text/plain",
	data : JSON.stringify(eval(data)),
	success : function(response) {
	    loadAllConfigs();
	    externalConfig.loadQAConfig();
	    externalConfig.loadProdConfig();
	    showMessage("Changed State of Config: " + JSON.stringify(eval(response)));
	},
	error : function(response) {
	    loadAllConfigs();
	    showMessage("Changed State Failed: " + JSON.stringify(eval(response)));
	}
    });
}

function activate(data) {

    $.ajax({
	type : "PUT",
	url : '/configmanager/rest/status/change',
	contentType : "text/plain",
	data : JSON.stringify(eval(data)),
	success : function(response) {
	    loadAllConfigs();
	    externalConfig.loadQAConfig();
	    externalConfig.loadProdConfig();
	    showMessage("Activated Config: " + JSON.stringify(eval(response)));
	},
	error : function(response) {
	    loadAllConfigs();
	    showMessage("Activation Failed: " + JSON.stringify(eval(response)));
	}	
    });
}

function showMessage(message) {
    $('#displayStatus').slideUp().html(message).css({
	color : '#006100',
	background : '#c6efce',
	border : '2px solid #006100'
    }).slideDown();
}
