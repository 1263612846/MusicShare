<@p.page>
<form action="login.action" name="loginForm" onsubmit="return validateForm(this)" method="post">

<table width="677" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2"><img src="${base}/images/login/1.jpg" width="677" height="328"></td>
  </tr>
</table>

<table width="677" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30" align="center" background="${base}/images/login/2.jpg"><table width="90%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="item" align="right" width="15%"><font black="White"><b>用户名：</b></font></td>
        <td align="left">
        <input type="text" name="username" style="width:150px" emptyInfo="请输入用户名。" value="${userName?if_exists}">
        </td>
        <td class="item" align="right"><font color="black"><b>密　码：</b></font></td>
		<td align="left">
		<input type="password" name="password" style="width:150px" emptyInfo="请输入密码。">
		</td>
        <td></td>
		<td ailgn="center"><input type="submit" value="登录" class="btn"></td>
		<td ailgn="center"><a href="index.html">返回</a></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="677" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><img src="${base}/images/login/3.jpg" width="677" height="44"></td>
  </tr>
</table>

</form>
</@p.page>