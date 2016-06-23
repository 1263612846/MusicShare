<@p.page navi=["音乐分享","管理员功能","歌单管理"] setReferUrl=true>
<#assign subTasks={
	"返回管理员功能":"album!viewAdmin.action"
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
		<a href="album!adminView.action?albumid=${a.albumid}">查看歌单</a> | 
		<a href="album!adminEditAlbum.action?albumid=${a.albumid}">编辑歌单</a> | 
		<a href="album!deleteAlbum.action?albumid=${a.albumid}" onclick="return confirm('删除歌单后，歌单中包含的音乐也会被一并删除且无法恢复，确定要删除该吗？')">删除歌单</a>
	</td>
</tr>
</#list>
</table>
<div align="right"><@p.paging album/></div>
</@p.page>