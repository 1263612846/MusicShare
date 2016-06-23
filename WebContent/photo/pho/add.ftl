<@p.page navi=["音乐分享","我的歌单","歌单信息","添加音乐"]>
<#assign subTasks={
	"返回":"@back"
}>
<@p.intro subTasks>输入音乐详细信息添加音乐。</@p.intro>
<form name="addAlbumForm" action="music_add.action" method="post" onsubmit="return validateForm(this)" enctype="multipart/form-data">
<input type="hidden" name="albumid" value="${albumid}">
<table class="default" width="100%">
<tr class="title">
	<td colspan="2">添加音乐</td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>音乐名称</td>
	<td><input type="text" name="musicname" emptyInfo="请输入音乐名称。" size="50" maxLen="50" lengthInfo="音乐名称最大长度不能超过50字符。"></td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>艺术家名称</td>
	<td><input type="text" name="artist" emptyInfo="请输入艺术家名称。" size="50" maxLen="50" lengthInfo="艺术家名称最大长度不能超过50字符。"></td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>音乐类别</td>
	<td><select name="typeid"><#list gettype as g><option value="${g.typeid}">${g.typename}</option></#list></select></td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>上传音乐</td>
	<td ><input type="file" name="musicfile" size="50" emptyInfo="请选择要上传的资源文件！"></td>
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