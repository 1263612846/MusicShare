<@p.page navi=["音乐分享"] setReferUrl=true>
<#assign subTasks={
	"歌单":"album!album.action",
	"分类":"album!type.action",
	"搜索音乐":"${base}/photo/pho/music!viewSearch.action",
	"个人中心":"album!myCenter.action",
	"注册":"album!reg.action",
	"退出系统":"${base}/logout.action"
}>
<@p.intro subTasks>欢迎访问音乐资源共享网站，加入我们，精心打造您的歌单，分享给他人！</@p.intro>
<br><br>
今日推荐歌单 / <a href="http://localhost:8080/MusicShare/photo/album/album!album.action">更多</a>
<br><br>
&nbsp;<img src="${base}/images/1.jpg" width="100" height="65" />&nbsp;&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!view.action?albumid=4">动听的K-POP合辑</a>&nbsp;-&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!user.action?userid=1">admin</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${base}/images/3.jpg" width="100" height="65" />&nbsp;&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!view.action?albumid=6">静享天籁 - 优美的轻音乐精选</a>&nbsp;-&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!user.action?userid=5">Romo</a>
<br><br>&nbsp;<img src="${base}/images/6.jpg" width="100" height="65" />&nbsp;&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!view.action?albumid=9">小语种音乐大搜罗</a>&nbsp;-&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!user.action?userid=10">Black</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${base}/images/2.jpg" width="100" height="65" />&nbsp;&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!view.action?albumid=8">释放狂野 - 热搜摇滚音乐收录</a>&nbsp;-&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!user.action?userid=9">White</a>
<br><br><br>今日音乐分享家推荐：<br><br>
&nbsp;<img src="${base}/images/9.jpg" width="100" height="65" />&nbsp;&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!user.action?userid=1">admin</a>&nbsp;-&nbsp;管理员也爱音乐
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${base}/images/10.jpg" width="100" height="65" />&nbsp;&nbsp;<a href="http://localhost:8080/MusicShare/photo/album/album!user.action?userid=5">Romo</a>&nbsp;-&nbsp;轻音乐爱好者
</@p.page>