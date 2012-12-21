/**
 * 
 */
var BatchLogsUtil = function() {

    this.loadBatchLogs = function() {

	$
	.getJSON(
		'/configmanager/rest/logs',
		function(data) {
		    $('#batch-logs-div').html('');
		    var html = '<table style="width: 100%">';
		    html += '<thead><tr>' 
			+ '<th>#</th>' 
			+ '<th>id</th>' 
			+ '<th>Created On</th>' 
			+ '<th>Log Description</th>' 
			+ '</tr></thead>';
		    html += '<tbody>';
		    $.each(data, function(index, item) {
			html +=
			    '<tr height="50"></td><td>'
			    + (index + 1)
			    + '</td><td  width="5%">'
			    + JSON.stringify(eval(item.id))
			    + '</td><td  width="10%">'
			    + new Date().toUTCString(item.date)
			    + '</td><td  width="20%">'
			    + item.log
			    + '</td><td>'
			    + '</td></tr>';
		    });
		    html += '</tbody></table>';
		    $('#batch-logs-div').append(html); 
		}
	);
    };
};
