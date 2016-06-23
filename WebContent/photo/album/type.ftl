<@p.page navi=["音乐分享","按类别查看"] setReferUrl=true>
<#assign subTasks={
	"返回主页":"album!index.action"
}>
<@p.intro subTasks>这里列出了所有的音乐类别。</@p.intro>
<table class="default" width="100%">
<tr class="title">
	<td>音乐类别</td><td>类别中的音乐数量</td><td>操作</td>
</tr>
<#list type as t>
<tr <@p.trChangeColor/>>
	<td>${t.typename}</td>
	<td>${t.cnt}</td>
	<td>
		<a href="album!viewType.action?typeid=${t.typeid}">查看</a>
	</td>
</tr>
</#list>
</table>
</@p.page>