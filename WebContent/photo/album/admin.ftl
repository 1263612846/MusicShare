<@p.page navi=["音乐分享","管理员功能"] setReferUrl=true>
<#assign subTasks={
	"歌单与音乐管理":"album!adminManageAlbum.action",
	"音乐类别管理":"album!manageType.action",
	"用户管理":"album!manageUser.action",
	"返回个人中心":"album!myCenter.action"
}>
<@p.intro subTasks>这里是管理员管理功能！</@p.intro>
</@p.page>