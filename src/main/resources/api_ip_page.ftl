<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script src="/js/send.js"></script>
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
    $('#main_form').submit(function(){
        return sendMainForm()
    });
});
</script>

<div id="sidebar_container">

<#include "/widget/sites.ftl" parse=false>

</div>

<div id="content">
  <!-- insert the page content here -->
  <h1>Enter IP Address as X.X.X.X or integer variant of ip address or domain</h1>
  <p>
      <form id="main_form" method="get" action="/">
          <input id="q" class="search" value="${_id}" />
          <input type="submit" name="Find" />
      </form>
  </p>

   <div id="map_canvas" style="width: 100%; height: 500px"></div>

  <table style="width:100%; border-spacing:0;">
    <tr><th>Key</th><th>Value</th></tr>
    <tr><td>IP</td><td>${_id}</td></tr>
    <tr><td>Range</td><td>${range.from} - ${range.to}</td></tr>
    <tr><td>ASN</td><td>${asn}</td></tr>
    <tr><td>Location</td><td>${location.name} ${location.country} ${location.region} ${location.postcode}</td></tr>
  </table>

</div>