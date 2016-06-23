<@p.page navi=["音乐分享","我的歌单"] setReferUrl=true>
<#assign subTasks={
	"创建新歌单":"album!viewAdd.action",
	"返回歌单列表":"album!album.action",
	"返回个人中心":"album!myCenter.action"
}>
<@p.intro subTasks>这里列出了所有您创建的歌单，您可以上传音乐到歌单，修改歌单信息，删除歌单！</@p.intro>
<table class="default" width="100%">
<tr class="title">
	<td>歌单名称</td><td>音乐数量</td><td>创建日期</td><td>操作</td>
</tr>
<#list center.list as a>
<tr <@p.trChangeColor/>>
	<td>${a.albumname}</td>
	<td>${a.cnt}</td>
	<td>${a.date?date}</td>
	<td>
		<a href="album!manageAlbum.action?albumid=${a.albumid}">查看歌单</a> | 
		<a href="album!editAlbum.action?albumid=${a.albumid}">编辑歌单</a> | 
		<a href="album!deleteAlbum.action?albumid=${a.albumid}" onclick="return confirm('删除歌单后，歌单中包含的音乐也会被一并删除且无法恢复，确定要删除该吗？')">删除歌单</a>
	</td>
</tr>
</#list>
</table>
<div align="right"><@p.paging center/></div>
</@p.page>