<@p.page navi=["音乐分享","搜索音乐","搜索结果"] setReferUrl=true>
<#assign subTasks={
	"返回搜索":"music!viewSearch.action",
	"返回主页":"${base}/photo/album/album!index.action"
}>
<@p.intro subTasks>请输入要搜索的音乐信息。</@p.intro>
<table class="default" width="100%">
<tr class="title">
	<td>音乐名称</td><td>艺术家</td><td>音乐类别</td><td>操作</td>
</tr>
<#list results.list as r>
<tr <@p.trChangeColor/>>
	<td>${r.musicname}</td>
	<td>${r.artist}</td>
	<td>${r.typename}</td>
	<td>
		<a href="music!viewPlay.action?musicid=${r.musicid}" target="_black">播放</a> | 
		<a href="${base}/photo/album/album!albumlist.action?musicid=${r.musicid}">查看所属歌单</a>
	</td>
</tr>
</#list>
</table>
<div align="right"><@p.paging results/></div>
</@p.page>>