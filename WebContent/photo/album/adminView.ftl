<@p.page navi=["音乐分享","管理员功能","歌单管理","音乐管理"] setReferUrl=true>
<#assign subTasks={
	"返回歌单管理":"album!adminManageAlbum.action",
	"返回管理员功能":"album!viewAdmin.action"
}>
<@p.intro subTasks>这里是歌单详情页面！</@p.intro>
<br>
&nbsp;<b>创建者：<a href="album!user.action?userid=${userid}">${username}</a></b><br><br>
&nbsp;<b>歌单名称：${thisalbum.albumname}</b><br>
&nbsp;<b>歌单描述：${thisalbum.albuminfo}</b><br><br>
&nbsp;<b>音乐数量：${cnt}</b><br><br>
<table class="default" width="100%">
<tr class="title">
	<td>音乐名称</td><td>艺术家</td><td>音乐类别</td><td>操作</td>
</tr>
<#list music as a>
<tr <@p.trChangeColor/>>
	<td>${a.musicname}</td>
	<td>${a.artist}</td>
	<td>${a.typename}</td>
	<td>
		<a href="${base}/photo/pho/music!play.action?musicid=${a.musicid}" target="_black">播放</a> | 
		<a href="${base}/photo/pho/music!editMusic.action?musicid=${a.musicid}">修改信息</a> | 
		<a href="${base}/photo/pho/music!deleteMusic.action?musicid=${a.musicid}" onclick="return confirm('确定要删除吗？')">删除</a>
	</td>
</tr>
</#list>
</table>
</@p.page>