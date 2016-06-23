<@p.page navi=["音乐分享","按类别查看","查看类别"] setReferUrl=true>
<#assign subTasks={
	"返回类别列表":"album!type.action"
}>
<@p.intro subTasks>这里列出了所选类别的所有音乐。</@p.intro>
<table class="default" width="100%">
<br>
&nbsp;<b>当前浏览的音乐类别：${typename}</b></td>
<br><br>
<tr class="title">
	<td>音乐名称</td><td>艺术家</td><td>操作</td>
</tr>
<#list mbt.list as m>
<tr <@p.trChangeColor/>>
	<td>${m.musicname}</td>
	<td>${m.artist}</td>
	<td>
		<a href="${base}/photo/pho/music!viewPlay.action?musicid=${m.musicid}" target="_black">播放</a> | 
		<a href="album!albumlist.action?musicid=${m.musicid}">查看所属歌单</a>
	</td>
</tr>
</#list>
</table>
<div align="right"><@p.paging mbt/></div>
</@p.page>