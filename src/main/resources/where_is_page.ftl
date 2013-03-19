<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script src="/js/send.js"></script>
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
    $('#main_form').submit(function(){
        return sendMainForm()
    });
});
</script>
<div id="sidebar_container">

<#include "/widget/sites.ftl" parse=false>

<#include "/widget/lasten.ftl" parse=true>

</div>

<div id="content">
  <!-- insert the page content here -->
  <h1>Enter IP Address as X.X.X.X or integer variant of ip address or domain</h1>
  <p>
      <form id="main_form" method="get" action="/">
          <input id="q" class="search" value="${site}" />
          <input type="submit" value="GeoLocate!" />
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