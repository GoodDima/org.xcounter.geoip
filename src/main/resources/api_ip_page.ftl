<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script type="text/javascript">
//AIzaSyBNP523J07pH9_UdKParFsqH_0_8JjKnhs
var map;
var lat = ${location.gps_lat};
var lon = ${location.gps_lon};

function initialize() {
  var myLatlng = new google.maps.LatLng(lat,lon);
  var mapOptions = {
    zoom: 8,
    center: myLatlng,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  }
  map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
  
  new google.maps.Marker({
      position: myLatlng, 
      map: map,
      title: '${location.name}'
  });
}

$(function() {
    initialize();
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

<#include "/widget/sites.ftl" parse=false>

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