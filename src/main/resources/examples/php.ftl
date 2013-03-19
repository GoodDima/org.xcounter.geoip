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
<pre><code class="php">
//---- Variant 1

$ip = '8.8.8.8';
$url = sprintf('http://geoip.xcounter.org/api/ip/%s/json', $ip);
$section = file_get_contents($url);
$section = json_decode($section);
var_dump($section);

//---- Variant 1 End
</code></pre>

<h2>Simple variant using integer notation of ip address</h2>
<pre><code class="php">
//---- Variant 2

$ip = 134744072; // int value of 8.8.8.8
$url = sprintf('http://geoip.xcounter.org/api/ip/%d/json', $ip);
$section = file_get_contents($url);
$section = json_decode($section);
var_dump($section);

//---- Variant 2 End
</code></pre>

<h2>Output for both variants</h2>
<pre><code class="bash">

object(stdClass)#1 (4) {
  ["_id"]=>
  int(134744072)
  ["asn"]=>
  string(19) "AS15169 Google Inc."
  ["range"]=>
  object(stdClass)#2 (2) {
    ["from"]=>
    int(134744064)
    ["to"]=>
    int(134744319)
  }
  ["location"]=>
  object(stdClass)#3 (6) {
    ["name"]=>
    string(13) "Mountain View"
    ["country"]=>
    string(2) "US"
    ["region"]=>
    string(2) "CA"
    ["postcode"]=>
    string(5) "94043"
    ["gps_lat"]=>
    float(37.419200897217)
    ["gps_lon"]=>
    float(-122.05740356445)
  }
}

</code></pre>

</div>