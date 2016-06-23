<@p.page navi=["音乐分享","管理员功能","用户管理"] setReferUrl=true>
<#assign subTasks={
	"返回管理员功能":"album/album!viewAdmin.action"
}>
<@p.intro subTasks>这里列出了所有的用户。</@p.intro>
</table>
<table class="default" width="100%">
<br>&nbsp;<b>普通用户列表：</b><br><br>
<tr class="title">
	<td>用户名</td><td>操作</td>
</tr>
<#list users as u>
<tr <@p.trChangeColor/>>
	<td>${u.username}</td>
	<td>
		<a href="album!setAdmin.action?userid=${u.userid}" onclick="return confirm('该操作无法恢复，确定要提升为管理员吗？')">提升为管理员</a> | 
		<a href="album!deleteUser.action?userid=${u.userid}" onclick="return confirm('该操作无法恢复，确定要删除该用户吗？')">删除用户</a>
	</td>
</tr>
</#list>
</table>
<table class="default" width="100%">
<br><br>&nbsp;<b>管理员列表：</b><br><br>
<tr class="title">
	<td>用户名</td>
</tr>
<#list admins as a>
<tr <@p.trChangeColor/>>
	<td>${a.username}</td>
</tr>
</#list>
</@p.page>