package neo.photo.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import neo.common.service.BaseService;
import neo.core.common.PagingList;
import neo.core.util.QueryHelper;

@Service(value = "photoService")
public class PhotoService extends BaseService {

	public Long getNextId() {
		// TODO Auto-generated method stub
		String sql = "select ifnull(max(musicid)+1,1) from music";
		return jt.queryForLong(sql);
	}

	public void addMusic(Long id, String musicname, String artist, String albumid, String typeid) {
		// TODO Auto-generated method stub
		String sql = "insert into music values(?,?,?,?,?)";
		jt.update(sql, new Object[] { id, musicname, artist, albumid, typeid });
	}

	public void updateMusic(String musicname, String artist, String musicid, String typeid) {
		// TODO Auto-generated method stub
		String sql = "update music set musicname=?,artist=?,typeid=? where musicid=?";
		jt.update(sql, new Object[] { musicname, artist, typeid, musicid });
	}

	public void deleteMusic(String musicid) {
		// TODO Auto-generated method stub
		String sql = "delete from music where musicid=?";
		jt.update(sql, new Object[] { musicid });
	}

	public Map getThisMusic(String musicid) {
		// TODO Auto-generated method stub
		String sql = "select * from music where musicid=?";
		return jt.queryForMap(sql, new Object[] { musicid });
	}

	public PagingList manage(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select * from collect where userid=?";
		return this.getPagingList(sql, new Object[] { loginUserId });
	}

	public String musicname(Long long1) {
		// TODO Auto-generated method stub
		String sql = "select m.musicname from music as m join collect as c on m.musicid=c.musicid where userid=?";
		return jt.queryForObject(sql, new Object[] { long1 }, String.class);
	}

	public String artist(Long long1) {
		// TODO Auto-generated method stub
		String sql = "select m.artist from music as m join collect as c on m.musicid=c.musicid where userid=?";
		return jt.queryForObject(sql, new Object[] { long1 }, String.class);
	}

	public String musicid(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select musicid from collect where userid=?";
		return jt.queryForObject(sql, new Object[] { loginUserId }, String.class);
	}

	public PagingList collect(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select distinct m.*,t.typename from music as m join collect as c on m.musicid=c.musicid join type as t on m.typeid=t.typeid where userid=?";
		return this.getPagingList(sql, new Object[] { loginUserId });
	}

	public void collectthis(Long loginUserId, String musicid) {
		// TODO Auto-generated method stub
		String sql = "insert into collect values(null,?,?)";
		jt.update(sql, new Object[] { loginUserId, musicid });
	}

	public void remove(String musicid) {
		// TODO Auto-generated method stub
		String sql = "delete from collect where musicid=?";
		jt.update(sql, new Object[] { musicid });
	}

	public void commentthis(Long loginUserId, String comment, String musicid) {
		// TODO Auto-generated method stub
		String sql = "insert into comment values(null,?,?,?,now())";
		jt.update(sql, new Object[] { musicid, loginUserId, comment });
	}

	public List<Map<String, Object>> getcommentlist(String musicid) {
		// TODO Auto-generated method stub
		String sql = "select c.*,u.username from comment as c join users as u on c.userid=u.userid where musicid=?";
		return jt.queryForList(sql, new Object[] { musicid });
	}

	public void delcomment(String commentid) {
		// TODO Auto-generated method stub
		String sql = "delete from comment where commentid=?";
		jt.update(sql, new Object[] { commentid });
	}

	public PagingList searchMusic(String musicname, String artist) {
		// TODO Auto-generated method stub
		String sql = "select m.*,t.typename from music as m join type as t on m.typeid=t.typeid";
		QueryHelper qh = new QueryHelper(sql);
		qh.setParam(StringUtils.isNotBlank(musicname), "musicname like ?", "%" + musicname + "%");
		qh.setParam(StringUtils.isNotBlank(artist), "artist like ?", "%" + artist + "%");
		//System.out.println(qh.getQuerySql());
		return this.getPagingList(qh.getQuerySql(), qh.getParams());
	}

	public List getmusictype() {
		// TODO Auto-generated method stub
		String sql = "select * from type";
		return jt.queryForList(sql);
	}

}
