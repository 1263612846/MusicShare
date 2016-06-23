package neo.photo.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import neo.common.action.BaseAction;
import neo.core.common.PagingList;

public class PhotoAction extends BaseAction {
	String musicname, artist, albumid, filename, fileName, musicid, comment, commentid, typeid;
	File musicfile;
	Map thismusic;
	PagingList collect, results;
	List commentlist, gettype;

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public List getGettype() {
		return gettype;
	}

	public void setGettype(List gettype) {
		this.gettype = gettype;
	}

	public List getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List commentlist) {
		this.commentlist = commentlist;
	}

	public PagingList getResults() {
		return results;
	}

	public void setResults(PagingList results) {
		this.results = results;
	}

	public String getCommentid() {
		return commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PagingList getCollect() {
		return collect;
	}

	public void setCollect(PagingList collect) {
		this.collect = collect;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMusicid() {
		return musicid;
	}

	public void setMusicid(String musicid) {
		this.musicid = musicid;
	}

	public Map getThismusic() {
		return thismusic;
	}

	public void setThismusic(Map thismusic) {
		this.thismusic = thismusic;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public File getMusicfile() {
		return musicfile;
	}

	public void setMusicfile(File musicfile) {
		this.musicfile = musicfile;
	}

	public String getMusicname() {
		return musicname;
	}

	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbumid() {
		return albumid;
	}

	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}

	public String viewAdd() {
		gettype = this.getServMgr().getPhotoService().getmusictype();
		return "viewAdd";
	}

	public String add() {
		try {
			Long id = this.getServMgr().getPhotoService().getNextId();
			filename = this.getServletContext().getRealPath("/UserFiles/" + id + ".mp3");
			//System.out.println("filename:" + filename);
			if (musicfile != null) {
				musicfile.renameTo(new File(filename));
				this.getServMgr().getPhotoService().addMusic(id, musicname, artist, albumid, typeid);
				this.addMessage("上传音乐成功！");
				this.addRedirURL("返回", this.getFullReferUrl());
			} else {

				this.setResult(ERROR);
				this.addMessage("上传音乐失败");
				this.addRedirURL("返回", "@back");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EXECUTE_RESULT;
	}

	public String editMusic() {
		gettype = this.getServMgr().getPhotoService().getmusictype();
		thismusic = this.getServMgr().getPhotoService().getThisMusic(musicid);
		return "editMusic";
	}

	public String updateMusic() {
		try {
			this.getServMgr().getPhotoService().updateMusic(musicname, artist, musicid, typeid);
			this.addMessage("修改音乐信息成功！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("修改音乐信息失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String deleteMusic() {
		try {
			musicfile = new File(getServletContext().getRealPath("/UserFiles/" + musicid + ".mp3"));
			musicfile.delete();
			this.getServMgr().getPhotoService().deleteMusic(musicid);
			this.addMessage("删除音乐成功！");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("删除音乐失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String viewPlay() {
		commentlist = this.getServMgr().getPhotoService().getcommentlist(musicid);
		thismusic = this.getServMgr().getPhotoService().getThisMusic(musicid);
		fileName = musicid + ".mp3";
		return "viewPlay";
	}

	public String play() {
		commentlist = this.getServMgr().getPhotoService().getcommentlist(musicid);
		thismusic = this.getServMgr().getPhotoService().getThisMusic(musicid);
		fileName = musicid + ".mp3";
		return "play";
	}

	public String viewCollect() {
		collect = this.getServMgr().getPhotoService().collect(this.getLoginUserId());
		return "collect";
	}

	public String remove() {
		try {
			this.getServMgr().getPhotoService().remove(musicid);
			this.addMessage("已移除收藏");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("移除收藏失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String collect() {
		try {
			this.getServMgr().getPhotoService().collectthis(this.getLoginUserId(), musicid);
			this.addMessage("已添加到收藏");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("收藏失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String comment() {
		try {
			this.getServMgr().getPhotoService().commentthis(this.getLoginUserId(), comment, musicid);
			this.addMessage("发表评论成功");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("评论失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String deletecomment() {
		try {
			this.getServMgr().getPhotoService().delcomment(commentid);
			this.addMessage("已删除评论");
			this.addRedirURL("返回", this.getFullReferUrl());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("删除评论失败");
			this.addRedirURL("返回", this.getFullReferUrl());
		}
		return EXECUTE_RESULT;
	}

	public String viewSearch() {
		return "search";
	}

	public String search() {
		results = this.getServMgr().getPhotoService().searchMusic(musicname, artist);
		return "result";
	}

	public String adminEditMusic() {
		gettype = this.getServMgr().getPhotoService().getmusictype();
		thismusic = this.getServMgr().getPhotoService().getThisMusic(musicid);
		return "adminEditMusic";
	}

}
