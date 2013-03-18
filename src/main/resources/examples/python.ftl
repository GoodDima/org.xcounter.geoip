<link rel="stylesheet" href="/highlight/styles/github.css">
<script src="/highlight/highlight.pack.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    hljs.initHighlightingOnLoad();
    $('pre code').each(function(i, e) {hljs.highlightBlock(e)});
});
</script>

<div id="sidebar_container">

  <#include "/widget/sites.ftl" parse=false>

</div>

<div id="content">

<h2>Simple variant using dot-decimal notation of ip address</h2>
<pre><code class="python">
//---- Variant 1

import urllib2
import simplejson
ip = "8.8.8.8"
req = urllib2.Request("http://geoip.xcounter.org/api/ip/" + ip + "/json")
opener = urllib2.build_opener()
f = opener.open(req)
print simplejson.load(f)

//---- Variant 1 End
</code></pre>

<h2>Simple variant using integer notation of ip address</h2>
<pre><code class="python">

//---- Variant 2

import urllib2
import simplejson
ip = '134744072'  #int value of 8.8.8.8
req = urllib2.Request("http://geoip.xcounter.org/api/ip/" + ip + "/json")
opener = urllib2.build_opener()
f = opener.open(req)
print simplejson.load(f)

//---- Variant 2 End

</code></pre>

<h2>Output for both variants</h2>
<pre><code class="json">

{
_id: 134744072,
asn: "AS15169 Google Inc.",
range: {
    from: 134744064,
    to: 134744319
},
location: {
    name: "Mountain View",
    country: "US",
    region: "CA",
    postcode: "94043",
    gps_lat: 37.4192008972168,
    gps_lon: -122.05740356445312
}
}

</code></pre>

</div>