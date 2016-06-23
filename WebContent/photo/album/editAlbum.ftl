<@p.page navi=["音乐分享","我的歌单","编辑歌单"]>
<#assign subTasks={
	"返回":"album!center.action"
}>
<@p.intro subTasks>请修改歌单信息以更新歌单。</@p.intro>
<form name="updateAlbumForm" action="album!updateAlbum.action?albumid=${albumid}" method="post" onsubmit="return checkfm(this)">
<table class="default" width="100%">
<tr>
	<td class="item"><span class="notNull">*</span>歌单名称</td>
	<td><input type="text" value="${thisalbum.albumname}" name="albumname" emptyInfo="请输入专辑名称。" size="30" maxLen="30" lengthInfo="专辑名称最大长度不能超过50字符。"></td>
</tr>
<tr>
	<td class="item">歌单描述</td>
	<td><textarea name="albuminfo" size="50" maxLen="500" lengthInfo="歌单描述最大长度不能超过500字符。" rows="5" cols="51">${thisalbum.albuminfo?default("")}</textarea></td>
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