<script src="/js/send.js"></script>
<script type="text/javascript">

$(function() {
    $('#main_form').submit(
    		//send()
    		);
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
          <input id="q" class="search" />
      </form>
  </p>

</div>