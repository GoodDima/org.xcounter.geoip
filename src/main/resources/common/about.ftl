<script src="/js/send.js"></script>
<script type="text/javascript">

$(function() {
    $('#main_form').submit(function(){
        return sendMainForm();
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
          <input id="q" class="search" />
          <input type="submit" name="Find" />
      </form>
  </p>

  <p>
    <a href="/">geoip.xcounter.org</a> - is an open source ip geo location web service.<br />
    The service is delivered "AS IS" without and warranties and conditions of usage.<br />
    All comments and suggestions should be sent to good.dima[at]gmail.com.<br />
    <br />
    <i>Regards, Dmitry Gudkov</i>
  </p>

</div>