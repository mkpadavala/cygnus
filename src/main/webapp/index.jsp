

<!doctype html>
 
<html lang="en">
<head>

    <title>jQuery UI Accordion - Default functionality</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
   
    <script>
	    $(function() {
	        $( "#accordion" ).accordion();
	    });
    </script>

	<script>
	    $(function() {
	        var availableTags = [
	            "ActionScript",
	            "AppleScript",
	            "Asp",
	            "BASIC",
	            "C",
	            "C++",
	            "Clojure",
	            "COBOL",
	            "ColdFusion",
	            "Erlang",
	            "Fortran",
	            "Groovy",
	            "Haskell",
	            "Java",
	            "JavaScript",
	            "Lisp",
	            "Perl",
	            "PHP",
	            "Python",
	            "Ruby",
	            "Scala",
	            "Scheme"
	        ];
	        $( "#tags" ).autocomplete({
	            source: availableTags
	        });
	    });
    </script>
    
     <script>
    $(function() {
        $( "input[type=submit], a, button" )
            .button()
            .click(function( event ) {
                event.preventDefault();
            });
    });
    </script>
    
    
</head>
<body>

 
<div id="accordion">
    <h3>Section 1</h3>
    <div>
        <p>
        Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
        ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
        amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
        odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
        </p>
    </div>
    <h3>Section 2</h3>
    <div>
        <p>
        Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
        purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
        velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
        suscipit faucibus urna.
        </p>
    </div>
    <h3>Section 3</h3>
    <div>
        <p>
        Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
        Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
        ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
        lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
        </p>
        <ul>
            <li>List item one</li>
            <li>List item two</li>
            <li>List item three</li>
        </ul>
    </div>
</div>
 
 
 <div class="ui-widget">
    <label for="tags">Tags: </label>
    <input id="tags" />
</div>

<div>
<button>A button element</button>
 
<input type="submit" value="A submit button" />
 
<a href="#">An anchor</a>

</div>
 
</body>
</html>
	

	