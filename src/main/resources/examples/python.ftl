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
  "asn": "AS15169 Google Inc.",
  "_id": 134744072,
  "location": {
    "region": "CA",
    "name": "Mountain View",
    "gps_lon": -122.057403564453,
    "postcode": "94043",
    "gps_lat": 37.4192008972168,
    "country": "US"
  },
  "range": {
    "to": 134744319,
    "from": 134744064
  }
}

</code></pre>

</div>