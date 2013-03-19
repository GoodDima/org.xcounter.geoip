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
  
  <#include "/widget/lasten.ftl" parse=true>

</div>

<div id="content">

<h2>Simple variant using dot-decimal notation of ip address</h2>
<pre><code class="ruby">
//---- Variant 1

require 'open-uri'
require 'json'

hash = JSON.parse(open("http://geoip.xcounter.org/api/ip/8.8.8.8/json").read)
puts JSON.pretty_generate(hash)

//---- Variant 1 End
</code></pre>

<h2>Output</h2>
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