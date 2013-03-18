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

</div>

<div id="content">
  <!-- insert the page content here -->
  <h1>Enter IP Address as X.X.X.X or integer variant of ip address or domain</h1>

  <p>
      <form id="main_form" method="get" action="/">
          <input id="q" class="search" />
          <input type="submit" value="GeoLocate!" />
      </form>
  </p>

</div>