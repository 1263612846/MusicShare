<@p.page navi=["音乐分享","搜索音乐"]>
<#assign subTasks={
	"返回主页":"${base}/photo/album/album!index.action"
}>
<@p.intro subTasks>请输入要搜索的音乐信息。</@p.intro>
<form name="searchphotoForm" action="music!search.action" method="post" onsubmit="return validateForm(this)">
<table width="100%" class="default">
<tr class="title">
	<td colspan="2">搜索条件</td>
</tr>
<tr>
	<td class="item">音乐名称</td>
	<td><input type="text" name="musicname" size="30" maxLen="30" ></td>
</tr>
<tr>
	<td class="item">艺术家名称</td>
	<td><input type="text" name="artist" size="30" maxLen="30" ></td>
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