<@p.page navi=["音乐分享","个人中心","我的私信"] setReferUrl=true>
<#assign subTasks={
	"返回个人中心":"album!myCenter.action"
}>
<@p.intro subTasks>这里是您的私信列表。</@p.intro>
<table class="default" width="100%">
<br>
&nbsp;<b>收到的私信：</b><br><br>
<tr class="title">
	<td>发信人</td><td>发送时间</td><td>消息内容</td><td>操作</td>
</tr>
<#list rl as r>
<tr>
	<td>${r.username}</td>
	<td>${r.lettertime}</td>
	<td>${r.message}</td>
	<td>
		<a href="album!letter.action?userid=${r.f}">回复私信</a>
	</td>
</tr>
</#list>
</table>
<br><br>
<table class="default" width="100%">
&nbsp;<b>发送的私信：</b><br><br>
<tr class="title">
	<td>收信人</td><td>发送时间</td><td>消息内容</td><td>操作</td>
</tr>
<#list pl as p>
<tr>
	<td>${p.username}</td>
	<td>${p.lettertime}</td>
	<td>${p.message}</td>
	<td>
		<a href="album!letter.action?userid=${p.t}">再发一封</a> | 
		<a href="album!deleteletter.action?letterid=${p.letterid}" onclick="return confirm('私信删除后，该私信将不会出现在收信人的私信列表中（即使TA尚未阅读），确定要删除吗？')">删除此条信息</a>
	</td>
</tr>
</#list>
</table>
</@p.page>