<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script type="text/javascript">
//AIzaSyBNP523J07pH9_UdKParFsqH_0_8JjKnhs
var map;

function initialize() {
  var myLatlng = new google.maps.LatLng(-25.363882,131.044922);
  var mapOptions = {
    zoom: 8,
//    center: myLatlng,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  }
  map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
}

$(function() {
    initialize();
    var markerBounds = new google.maps.LatLngBounds();
    var point;
    
<#list list as point>
point = new google.maps.LatLng( ${point.location.gps_lat}, ${point.location.gps_lon} );
new google.maps.Marker({
    position: point, 
    map: map,
    title: '${point.location.name}'
});
markerBounds.extend(point);
</#list>  

    map.fitBounds(markerBounds);
    $('#main_form').submit(function() {
        var q = $('#q').val();
        if (q.match('^[0-9\.]+$')){
            self.location = '/api/ip/' + q + '/';
        }else{
            self.location = '/api/whereis/' + q + '/';
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
          <input id="q" class="search" value="" />
      </form>
  </p>

<div id="map_canvas" style="width: 100%; height: 500px"></div>

<#list list as point>
  <table style="width:100%; border-spacing:0;">
    <tr><th>Key</th><th>Value</th></tr>
    <tr><td>IP</td><td>${point._id}</td></tr>
    <tr><td>Range</td><td>${point.range.from} - ${point.range.to}</td></tr>
    <tr><td>ASN</td><td>${point.asn}</td></tr>
    <tr><td>Location</td><td>${point.location.name} ${point.location.country} ${point.location.region} ${point.location.postcode}</td></tr>
  </table>
</#list>  

   

</div>