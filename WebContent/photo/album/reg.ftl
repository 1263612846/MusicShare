<@p.page navi=["音乐分享","用户注册"]>
<#assign subTasks={
	"返回主页":"album!index.action"
}>
<@p.intro subTasks>欢迎加入我们！</@p.intro>
<form name="reg" action="album!regUser.action" method="post" onsubmit="return checkfm(this)">
<table class="default" width="100%">
<tr class="title">
	<td colspan="2">注册用户</td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>用户名</td>
	<td><input name="username" emptyInfo="用户名不能为空。" size="30" maxLen="30" lengthInfo="用户名长度不能超过30字符。"></td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>密码</td>
	<td><input type="password" name="pass" emptyInfo="请输入新密码。" size="30" maxLen="30" lengthInfo="密码最大长度不能超过30字符。"></td>
</tr>
<tr>
	<td class="item"><span class="notNull">*</span>密码确认</td>
	<td><input type="password" name="pass1" emptyInfo="请输入新密码确认。" size="30" maxLen="30" lengthInfo="密码确认最大长度不能超过30字符。"></td>
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