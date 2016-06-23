package neo.photo.action;

import java.util.List;
import java.util.Map;

import neo.common.action.BaseAction;
import neo.core.common.PagingList;

public class AlbumAction extends BaseAction {
	PagingList album, center, albumlist, mbt;
	String albumid, albumname, albuminfo, username, musicid, userid, message, letterid, typeid, typename, determine,
			pass, pass1;
	Map thisalbum, thistype;
	int cnt;
	List aou, cou, rl, pl, type, music, users, admins;

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public List getAdmins() {
		return admins;
	}

	public void setAdmins(List admins) {
		this.admins = admins;
	}

	public List getUsers() {
		return users;
	}

	public void setUsers(List users) {
		this.users = users;
	}

	public String getDetermine() {
		return determine;
	}

	public void setDetermine(String determine) {
		this.determine = determine;
	}

	public Map getThistype() {
		return thistype;
	}

	public void setThistype(Map thistype) {
		this.thistype = thistype;
	}

	public List getMusic() {
		return music;
	}

	public void setMusic(List music) {
		this.music = music;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public PagingList getMbt() {
		return mbt;
	}

	public void setMbt(PagingList mbt) {
		this.mbt = mbt;
	}

	public List getType() {
		return type;
	}

	public void setType(List type) {
		this.type = type;
	}

	public String getLetterid() {
		return letterid;
	}

	public void setLetterid(String letterid) {
		this.letterid = letterid;
	}

	public List getRl() {
		return rl;
	}

	public void setRl(List rl) {
		this.rl = rl;
	}

	public List getPl() {
		return pl;
	}

	public void setPl(List pl) {
		this.pl = pl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List getAou() {
		return aou;
	}

	public void setAou(List aou) {
		this.aou = aou;
	}

	public List getCou() {
		return cou;
	}

	public void setCou(List cou) {
		this.cou = cou;
	}

	public PagingList getAlbumlist() {
		return albumlist;
	}

	public void setAlbumlist(PagingList albumlist) {
		this.albumlist = albumlist;
	}

	public String getMusicid() {
		return musicid;
	}

	public void setMusicid(String musicid) {
		this.musicid = musicid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Map getThisalbum() {
		return thisalbum;
	}

	public void setThisalbum(Map thisalbum) {
		this.thisalbum = thisalbum;
	}

	public String getAlbumid() {
		return albumid;
	}

	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}

	public PagingList getCenter() {
		return center;
	}

	public void setCenter(PagingList center) {
		this.center = center;
	}

	public PagingList getAlbum() {
		return album;
	}

	public void setAlbum(PagingList album) {
		this.album = album;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getAlbuminfo() {
		return albuminfo;
	}

	public void setAlbuminfo(String albuminfo) {
		this.albuminfo = albuminfo;
	}

	public String album() {
		album = this.getServMgr().getAlbumService().albumList();
		return "album";
	}

	public String viewAdd() {
		return "viewAdd";
	}

	public String add() {
		try {
			this.getServMgr().getAlbumService().addAlbum(albumname, albuminfo, this.getLoginUserId());
			this.addMessage("歌单创建成功！");
			this.addRedirURL("立刻管理我的歌单", "album!center.action");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("创建歌单失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String center() {
		center = this.getServMgr().getAlbumService().manage(this.getLoginUserId());
		return "center";
	}

	public String manageAlbum() {
		cnt = this.getServMgr().getAlbumService().cnt(albumid);
		thisalbum = this.getServMgr().getAlbumService().getThisAlbum(albumid);
		music = this.getServMgr().getAlbumService().manageAlbum(albumid);
		return "manageAlbum";
	}

	public String editAlbum() {
		thisalbum = this.getServMgr().getAlbumService().getThisAlbum(albumid);
		return "editAlbum";
	}

	public String updateAlbum() {
		try {
			this.getServMgr().getAlbumService().updateAlbum(albumname, albuminfo, albumid);
			this.addMessage("歌单信息已更新！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("修改歌单信息失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String deleteAlbum() {
		try {
			this.getServMgr().getAlbumService().deleteAlbum(albumid);
			this.addMessage("删除歌单成功！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("删除歌单失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String view() {
		userid = this.getServMgr().getAlbumService().userid(albumid);
		username = this.getServMgr().getAlbumService().username(albumid);
		cnt = this.getServMgr().getAlbumService().cnt(albumid);
		thisalbum = this.getServMgr().getAlbumService().getThisAlbum(albumid);
		music = this.getServMgr().getAlbumService().manageAlbum(albumid);
		return "view";
	}

	public String albumlist() {
		albumlist = this.getServMgr().getAlbumService().getalbumlist(musicid);
		return "albumlist";
	}

	public String user() {
		username = this.getServMgr().getAlbumService().getusername(userid);
		aou = this.getServMgr().getAlbumService().albumofuser(userid);
		cou = this.getServMgr().getAlbumService().collectofuser(userid);
		return "user";
	}

	public String letter() {
		username = this.getServMgr().getAlbumService().getusername(userid);
		return "letter";
	}

	public String passletter() {
		try {
			this.getServMgr().getAlbumService().pass(this.getLoginUserId(), userid, message);
			this.addMessage("私信发送成功！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("私信发送失败");
			this.addRedirURL("返回", "@back");
		}
		return EXECUTE_RESULT;
	}

	public String viewLetter() {
		rl = this.getServMgr().getAlbumService().rletter(this.getLoginUserId());
		pl = this.getServMgr().getAlbumService().pletter(this.getLoginUserId());
		return "viewLetter";
	}

	public String deleteletter() {
		try {
			this.getServMgr().getAlbumService().dl(letterid);
			this.addMessage("删除私信成功！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("删除私信失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String type() {
		type = this.getServMgr().getAlbumService().gettype();
		return "type";
	}

	public String viewType() {
		typename = this.getServMgr().getAlbumService().gettypename(typeid);
		mbt = this.getServMgr().getAlbumService().musicbytype(typeid);
		return "viewType";
	}

	public String manageType() {
		type = this.getServMgr().getAlbumService().gettype();
		return "manageType";
	}

	public String viewAddType() {
		return "viewAddType";
	}

	public String addType() {
		try {
			this.getServMgr().getAlbumService().addtype(typename);
			this.addMessage("添加类别成功！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("添加类别失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String editType() {
		thistype = this.getServMgr().getAlbumService().getThisType(typeid);
		return "editType";
	}

	public String updateType() {
		try {
			this.getServMgr().getAlbumService().updatetype(typeid, typename);
			this.addMessage("修改类别成功！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("修改类别失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String deleteType() {
		try {
			this.getServMgr().getAlbumService().deleteType(typeid);
			this.addMessage("删除类别成功！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("删除类别失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String viewAdmin() {
		return "admin";
	}

	public String index() {
		return "index";
	}

	public String myCenter() {
		username = this.getServMgr().getAlbumService().myusername(this.getLoginUserId());
		aou = this.getServMgr().getAlbumService().albumofme(this.getLoginUserId());
		cou = this.getServMgr().getAlbumService().collectofme(this.getLoginUserId());
		determine = this.getServMgr().getAlbumService().userdetermine(this.getLoginUserId());
		if (determine.equals("1")) {
			determine = "inline";
		} else {
			determine = "none";
		}
		return "myCenter";
	}

	public String manageUser() {
		users = this.getServMgr().getAlbumService().getusers();
		admins = this.getServMgr().getAlbumService().getadmins();
		return "manageUser";
	}

	public String setAdmin() {
		try {
			this.getServMgr().getAlbumService().setadmin(userid);
			this.addMessage("已将用户提升为管理员！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("提升管理员失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String deleteUser() {
		try {
			this.getServMgr().getAlbumService().deleteuser(userid);
			this.addMessage("已删除用户！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("删除用户失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String adminManageAlbum() {
		album = this.getServMgr().getAlbumService().albumList();
		return "adminManageAlbum";
	}

	public String adminView() {
		userid = this.getServMgr().getAlbumService().userid(albumid);
		username = this.getServMgr().getAlbumService().username(albumid);
		cnt = this.getServMgr().getAlbumService().cnt(albumid);
		thisalbum = this.getServMgr().getAlbumService().getThisAlbum(albumid);
		music = this.getServMgr().getAlbumService().manageAlbum(albumid);
		return "adminView";
	}

	public String adminEditAlbum() {
		thisalbum = this.getServMgr().getAlbumService().getThisAlbum(albumid);
		return "adminEditAlbum";
	}

	public String reg() {
		return "reg";
	}

	public String regUser() {
		try {
			if (pass.equals(pass1)) {
				this.getServMgr().getAlbumService().reg(username, pass);
				this.addMessage("注册成功");
				this.addRedirURL("返回主页", this.getFullReferUrl());
			} else {
				this.addMessage("密码与密码确认不一致");
				this.addRedirURL("返回", "@back");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("注册失败");
			this.addRedirURL("返回", "@back");
		}
		return EXECUTE_RESULT;
	}

}
