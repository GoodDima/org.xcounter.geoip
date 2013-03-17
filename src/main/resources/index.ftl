<script type="text/javascript">

$(function() {
    initialize();
    $('#main_form').submit(function() {
        var q = $('#q').val();
        if (q.match('^[0-9\.]+$')){
            self.location = '/api/ip/' + q;
        }else{
            self.location = '/api/whereis/' + q;
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
          <input id="q" class="search" />
      </form>
  </p>

  <ul>
    <li>Internet Explorer 8</li>
    <li>Internet Explorer 7</li>
    <li>FireFox 3.5</li>
    <li>Google Chrome 6</li>
    <li>Safari 4</li>
  </ul>
</div>