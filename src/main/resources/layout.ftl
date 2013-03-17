<!DOCTYPE HTML>
<html>

<head>
  <title>${title}</title>
  <meta name="description" content="${description}" />
  <meta name="keywords" content="${keywords}" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="/style/style.css" />
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
</head>

<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="/">GeoIP.<span class="logo_colour">Xcounter</span>.org</a></h1>
          <h2>All you want to know about ip geolocation.</h2>
        </div>
      </div>

      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
		<#list menu as item>
			<li<#if item.url == menu_selected> class="selected"</#if>><a href="${item.url}">${item.name}</a></li>    
		</#list>
  

        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
    
    ${content}
     
    </div>
    <div id="content_footer"></div>
    <div id="footer">
    <!--
      <p>
      	<a href="index.html">Home</a> | <a href="examples.html">Examples</a> | <a href="page.html">A Page</a> | <a href="another_page.html">Another Page</a> | <a href="contact.html">Contact Us</a>
	  </p>
	//-->
      <p>Copyright &copy; xcounter.org | <a href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a></p>
    </div>
  </div>
</body>
</html>
