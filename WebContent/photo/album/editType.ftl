<@p.page navi=["音乐分享","管理员功能","音乐类别管理","修改音乐类别名称"]>
<#assign subTasks={
	"返回":"@back"
}>
<@p.intro subTasks>请修改类别名称以更新类别。</@p.intro>
<form name="addType" action="album!updateType.action?typeid=${thistype.typeid}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
<tr class="title">
	<td colspan="2">修改音乐类别名称</td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>类别名称</td>
	<td><input type="text" name="typename" value="${thistype.typename}" emptyInfo="请输入音乐类别名称。" size="50" maxLen="50" lengthInfo="音乐类别名称最大长度不能超过50字符。"></td>
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