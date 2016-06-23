<@p.page navi=["音乐分享","我的歌单","歌单信息"] setReferUrl=true>
<#assign subTasks={
	"上传音乐到这个歌单":"${base}/photo/pho/music!viewAdd.action?albumid=${albumid}",
	"返回我的歌单":"album!center.action"
}>
<@p.intro subTasks>这里列出了歌单的信息以及包含的音乐，您可以在此上传音乐至该歌单！</@p.intro>
<br>
<b>歌单名称：${thisalbum.albumname}</b><br>
<b>歌单描述：${thisalbum.albuminfo}</b><br><br>
<b>音乐数量：${cnt}</b><br><br>
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