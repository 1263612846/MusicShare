<@p.page navi=["音乐分享","管理员功能","音乐类别管理","添加音乐类别"]>
<#assign subTasks={
	"返回":"@back"
}>
<@p.intro subTasks>输入类别名称以创建音乐类别。</@p.intro>
<form name="addType" action="album!addType.action" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
<tr class="title">
	<td colspan="2">创建类别</td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>类别名称</td>
	<td><input type="text" name="typename" emptyInfo="请输入音乐类别名称。" size="50" maxLen="50" lengthInfo="音乐类别名称最大长度不能超过50字符。"></td>
</tr>
<tr>
	<td></td>
	<td>
	<input type="submit" name="submit" value="确定" class="btn">
	<input type="reset" name="reset" value="重置" class="btn">
	</td>
</tr>
</table>
</form>
</@p.page>