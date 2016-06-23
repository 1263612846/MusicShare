<@p.page navi=["音乐分享","管理员功能","音乐类别管理"] setReferUrl=true>
<#assign subTasks={
	"添加一个类别":"album!viewAddType.action",
	"返回管理员功能":"album!viewAdmin.action"
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
		<a href="album!viewType.action?typeid=${t.typeid}">查看</a> | 
		<a href="album!editType.action?typeid=${t.typeid}">修改类别名称</a> | 
		<a href="album!deleteType.action?typeid=${t.typeid}" onclick="return confirm('删除该类别后，类别中的音乐也会被一并删除且无法恢复，确定要删除该吗？')">删除该类别</a>
	</td>
</tr>
</#list>
</table>
</@p.page>