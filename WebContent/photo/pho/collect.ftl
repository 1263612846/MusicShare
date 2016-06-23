<@p.page navi=["音乐分享","个人中心","我的收藏"] setReferUrl=true>
<#assign subTasks={
	"返回个人中心":"${base}/photo/album/album!myCenter.action"
}>
<@p.intro subTasks>这里列出了您收藏的所有音乐。</@p.intro>
<table class="default" width="100%">
<tr class="title">
	<td>音乐名称</td><td>艺术家</td><td>音乐类别</td><td>操作</td>
</tr>
<#list collect.list as c>
<tr <@p.trChangeColor/>>
	<td>${c.musicname}</td>
	<td>${c.artist}</td>
	<td>${c.typename}</td>
	<td>
		<a href="music!viewPlay.action?musicid=${c.musicid}" target="_black">播放</a> | 
		<a href="${base}/photo/album/album!albumlist.action?musicid=${c.musicid}">查看所属歌单</a> | 
		<a href="music!remove.action?musicid=${c.musicid}" onclick="return confirm('确定要移除此收藏吗？')">移除</a>
	</td>
</tr>
</#list>
</table>
<div align="right"><@p.paging collect/></div>
</@p.page>