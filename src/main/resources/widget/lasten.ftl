  <div class="sidebar">
    <div class="sidebar_top"></div>
    <div class="sidebar_item">
      <h3>Last found ips</h3>
      <ul>
<#list lasten as ip>
        <li><a href="/api/ip/${ip}/">${ip}</a></li>
</#list>
      </ul>
    </div>
    <div class="sidebar_base"></div>
  </div>