<@p.page navi=["音乐分享","音乐播放"] setReferUrl=true>
<@p.intro subTasks>这里是音乐播放界面。</@p.intro>
<br><br>
&nbsp;&nbsp;音乐名称：<b>${thismusic.musicname}</b><br><br>
&nbsp;&nbsp;歌手名称：<b>${thismusic.artist}</b><br><br><br><br>
<EMBED src="${base}/UserFiles/${fileName}" loop="flase" autostart="true"></EMBED>
<br><br><br><br>
<form name="addComment" action="music!comment.action?musicid=${musicid}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
&nbsp;<textarea name="comment"  size="50" maxLen="100" lengthInfo="评论最大长度不能超过100字符。" rows="5" cols="51"></textarea>
&nbsp;&nbsp;<input type="submit" name="submit" value="发表评论" class="btn"><br><br>
<#list commentlist as l>
<tr <@p.trChangeColor/>>
	<td>${l.username}：<br><b>${l.comment}</b><br><br>${l.commenttime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="music!deletecomment.action?commentid=${l.commentid}" onclick="return confirm('确定要删除此条评论吗？')">删除</a></td>
</tr>
</#list>
</table>
</form>
</@p.page>