<@p.page navi=["音乐分享","个人中心"] setReferUrl=true>
<#assign subTasks={
	"管理我的歌单":"album!center.action",
	"管理我的收藏":"${base}/photo/pho/music!viewCollect.action",
	"查看我的私信":"album!viewLetter.action",
	"修改密码":"${base}/password.action",
	"返回主页":"album!index.action"
}>
<@p.intro subTasks>这里是您的主页！</@p.intro>
<table class="default" width="100%">
<div style="display:${determine}"><br>
&nbsp;<b><a href="album!viewAdmin.action">管理员管理功能</a></b>
<br></div>
<br>
&nbsp;<b>我的用户名：${username}</b>
<br><br><br>
&nbsp;<b>我的歌单：</b><br><br>
<tr class="title">
	<td>歌单名称</td><td>创建日期</td><td>操作</td>
</tr>
<#list aou as a>
<tr <@p.trChangeColor/>>
	<td>${a.albumname}</td>
	<td>${a.date?date}</td>
	<td>
		<a href="album!view.action?albumid=${a.albumid}">查看歌单</a>
	</td>
</tr>
</#list>
</table>
<br><br>
<table class="default" width="100%">
&nbsp;<b>我的收藏：</b><br><br>
<tr class="title">
	<td>音乐名称</td><td>艺术家</td><td>操作</td>
</tr>
<#list cou as c>
<tr <@p.trChangeColor/>>
	<td>${c.musicname}</td>
	<td>${c.artist}</td>
	<td>
		<a href="${base}/photo/pho/music!viewPlay.action?musicid=${c.musicid}" target="_black">播放</a>
	</td>
</tr>
</#list>
</table>
</@p.page>