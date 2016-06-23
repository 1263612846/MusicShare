<@p.page navi=["音乐分享","个人中心","修改密码"]>
<#assign subTasks={
	"返回个人中心":"@back"
}>
<@p.intro subTasks>输入当前密码和新密码以及新密码确认。</@p.intro>
<script language="JavaScript">
<!--
function checkfm(formSRC){
    if (validateForm(formSRC)==true) {
	if(document.addAlbumForm["newPass"].value==document.addAlbumForm["newPass1"].value){
		return true;
	}
	else{
		alert("新密码和新密码确认不符！");
		return false;
	}
	}
	else return false;
}
//-->
</script>
<form name="addAlbumForm" action="editPassword.action" method="post" onsubmit="return checkfm(this)">
<table class="default" width="100%">
<tr class="title">
	<td colspan="2">修改密码</td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>当前密码</td>
	<td><input type="password" name="oldPass" emptyInfo="请输入当前密码。" size="30" maxLen="30" lengthInfo="当前密码最大长度不能超过30字符。"></td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>新密码</td>
	<td><input type="password" name="newPass" emptyInfo="请输入新密码。" size="30" maxLen="30" lengthInfo="新密码最大长度不能超过30字符。"></td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>新密码确认</td>
	<td><input type="password" name="newPass1" emptyInfo="请输入新密码确认。" size="30" maxLen="30" lengthInfo="新密码确认最大长度不能超过30字符。"></td>
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