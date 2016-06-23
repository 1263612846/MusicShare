<@p.page navi=["音乐分享","歌单列表"] setReferUrl=true>
<#assign subTasks={
	"我要创建歌单":"album!viewAdd.action",
	"管理我的歌单":"album!center.action",
	"返回主页":"album!index.action"
}>
<@p.intro subTasks>这里列出了所有用户创建的歌单。</@p.intro>
<table class="default" width="100%">
<tr class="title">
	<td>歌单名称</td><td>音乐数量</td><td>创建者</td><td>创建日期</td><td>操作</td>
</tr>
<#list album.list as a>
<tr <@p.trChangeColor/>>
	<td>${a.albumname}</td>
	<td>${a.cnt}</td>
	<td>${a.username}</td>
	<td>${a.date?date}</td>
	<td>
		<a href="album!view.action?albumid=${a.albumid}">查看歌单</a>
	</td>
</tr>
</#list>
</table>
<div align="right"><@p.paging album/></div>
</@p.page>