<@p.page navi=["音乐分享","发送私信"]>
<#assign subTasks={
	"返回":"@back"
}>
<@p.intro subTasks>请输入私信内容。</@p.intro>
<form name="letter" action="album!passletter.action?userid=${userid}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
<br>
&nbsp;<b>发送给：${username}</b>
<br><br>
<textarea name="message"  size="50" maxLen="500" lengthInfo="私信内容最大长度不能超过500字符。" rows="5" cols="51"></textarea>
&nbsp;&nbsp;<input type="submit" name="submit" value="发送私信" class="btn"><br><br>
</table>
</form>
</@p.page>