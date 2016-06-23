<@p.page navi=["音乐分享","用户主页"] setReferUrl=true>
<#assign subTasks={
	"返回":"@back",
	"返回歌单列表":"album!album.action",
	"返回主页":"album!index.action"
}>
<@p.intro subTasks>这里列出了所选用户所创建的歌单和收藏的音乐。</@p.intro>
<table class="default" width="100%">
<br>
&nbsp;<b>用户名：${username}</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="album!letter.action?userid=${userid}">私信</a>
<br><br><br>
&nbsp;<b>TA的歌单：</b><br><br>
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
&nbsp;<b>TA的收藏：</b><br><br>
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