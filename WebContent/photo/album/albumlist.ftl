<@p.page navi=["音乐分享","音乐所属歌单"] setReferUrl=true>
<#assign subTasks={
	"返回":"@back",
	"返回主页":"album!index.action"
}>
<@p.intro subTasks>这里列出了所有包含搜索音乐的歌单！</@p.intro>
<table class="default" width="100%">
<tr class="title">
	<td>歌单名称</td><td>创建日期</td><td>操作</td>
</tr>
<#list albumlist.list as a>
<tr <@p.trChangeColor/>>
	<td>${a.albumname}</td>
	<td>${a.date?date}</td>
	<td>
		<a href="album!view.action?albumid=${a.albumid}">查看歌单</a>
	</td>
</tr>
</#list>
</table>
<div align="right"><@p.paging albumlist/></div>
</@p.page>