<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=AIzaSyBNP523J07pH9_UdKParFsqH_0_8JjKnhs&sensor=true"
            type="text/javascript"></script>
<script type="text/javascript">

var lat = ${location.gps_lat};
var lon = ${location.gps_lon};

function initialize() {
  if (GBrowserIsCompatible()) {
    var map = new GMap2(document.getElementById("map_canvas"));
    var point = new GLatLng(lat, lon);
    map.setCenter(point, 10);
    map.addOverlay(new GMarker(point));
    map.setUIToDefault();
  }
}

$(function() {
    initialize();
    $('#main_form').submit(function() {
        var q = $('#q').val();
        if (q.match('^[0-9\.]+$')){
            self.location = '/api/ip/' + q;
        }else{
            self.location = '/api/whereis/' + q;
        }
        return false;
    });
});

</script>
<div id="sidebar_container">
  <div class="sidebar">
    <div class="sidebar_top"></div>
    <div class="sidebar_item">
      <!-- insert your sidebar items here -->
      <h3>Latest News</h3>
      <h4>New Website Launched</h4>
      <h5>January 1st, 2010</h5>
      <p>2010 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
    </div>
    <div class="sidebar_base"></div>
  </div>

  <div class="sidebar">
    <div class="sidebar_top"></div>
    <div class="sidebar_item">
      <h3>Useful Links</h3>
      <ul>
        <li><a href="#">link 1</a></li>
        <li><a href="#">link 2</a></li>
        <li><a href="#">link 3</a></li>
        <li><a href="#">link 4</a></li>
      </ul>
    </div>
    <div class="sidebar_base"></div>
  </div>
<!--
  <div class="sidebar">
    <div class="sidebar_top"></div>
    <div class="sidebar_item">
      <h3>Search</h3>
      <form method="post" action="#" id="search_form">
        <p>
          <input class="search" type="text" name="search_field" value="Enter keywords....." />
          <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="/style/search.png" alt="Search" title="Search" />
        </p>
      </form>
    </div>
    <div class="sidebar_base"></div>
  </div>
//-->
</div>

<div id="content">
  <!-- insert the page content here -->
  <h1>Enter IP Address as X.X.X.X or integer variant of ip address</h1>
  <p>
      <form id="main_form" method="get" action="/">
          <input id="q" class="search" value="${_id}" />
      </form>
  </p>
  
  <table style="width:100%; border-spacing:0;">
    <tr><th>Key</th><th>Value</th></tr>
    <tr><td>IP</td><td>${_id}</td></tr>
    <tr><td>Range</td><td>${range.from} - ${range.to}</td></tr>
    <tr><td>ASN</td><td>${asn}</td></tr>
    <tr><td>Location</td><td>${location.name} ${location.country} ${location.region} ${location.postcode}</td></tr>
  </table>
  
  
   <div id="map_canvas" style="width: 100%; height: 500px"></div>
  
  <ul>
    <li>Internet Explorer 8</li>
    <li>Internet Explorer 7</li>
    <li>FireFox 3.5</li>
    <li>Google Chrome 6</li>
    <li>Safari 4</li>
  </ul>
</div>