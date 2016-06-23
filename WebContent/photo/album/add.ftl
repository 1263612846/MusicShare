<@p.page navi=["音乐分享","歌单列表","创建歌单"]>
<#assign subTasks={
	"返回":"@back"
}>
<@p.intro subTasks>输入您的歌单信息，创建歌单。</@p.intro>
<form name="addAlbumForm" action="album!add.action" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
<tr class="title">
	<td colspan="2">创建歌单</td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>歌单名称</td>
	<td><input type="text" name="albumname" emptyInfo="请输入歌单名称。" size="50" maxLen="50" lengthInfo="歌单名称最大长度不能超过50字符。"></td>
</tr>
<tr>
	<td class="item">歌单描述</td>
	<td><textarea name="albuminfo"  size="50" maxLen="500" lengthInfo="歌单描述最大长度不能超过500字符。" rows="5" cols="51"></textarea></td>
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