/**
 * 
 */
var ExternalConfigUtil = function() {

    this.loadQAConfig = function() {
	loadExternalConfig('/configmanager/rest/all/qa', 'qa-config-div');
    };

    this.loadProdConfig = function() {
	loadExternalConfig('/configmanager/rest/all/prod', 'prod-config-div');
    };

    var loadExternalConfig = function(url, div) {

	$
	.getJSON(
		url,
		function(data) {
		    $('#'+div).html('');
		    var html = '<table style="width: 100%">';
		    html += '<thead><tr>' 
			+ '<th>#</th>' 
			+ '<th>MD5</th>' 
			+ '<th>Created On</th>' 
			+ '<th>Description</th>' 
			+ '<th>Status</th>' 
			+ '<th>Last Updated On</th>' 
			+ '</tr></thead>';
		    html += '<tbody>';
		    $.each(data, function(index, item) {
			var color = item.inUse == true ? 'bgcolor="#4AA02C"':'';
			var status = item.inUse == true ? 'Active':'Inactive';
			html +=
			    '<tr height="50" '
			    + color
			    + '></td><td>'
			    + (index + 1)
			    + '</td><td>'
			    + item.md5Checksum
			    + '</td><td>'
			    + new Date().toUTCString(item.createdOn)
			    + '</td><td>'
			    + item.description
			    + '</td><td>'
			    + status
			    + '</td><td>'
			    + new Date().toUTCString(item.lastUpdatedOn)
			    + '</td><td>'
			    + '</td></tr>';
		    });
		    html += '</tbody></table>';
		    $('#'+div).append(html); 
		}
	);
    };
};
