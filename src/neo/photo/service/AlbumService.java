package neo.photo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import neo.common.service.BaseService;
import neo.core.common.PagingList;

@Service(value = "albumService")
public class AlbumService extends BaseService {

	public PagingList albumList() {
		// TODO Auto-generated method stub
		String sql = "select a.*,u.username,ifnull(m.num,0) as cnt from album as a join users as u on a.userid=u.userid join (select albumid,count(musicid) as num from music group by albumid) as m on a.albumid=m.albumid";
		return this.getPagingList(sql);
	}

	public int addAlbum(String albumname, String albuminfo, Long long1) {
		// TODO Auto-generated method stub
		String sql = "insert into album values(null,?,?,?,now())";
		return jt.update(sql, new Object[] { albumname, albuminfo, long1 });
	}

	public PagingList manage(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select a.*,ifnull(m.num,0) as cnt from album as a left join (select albumid,count(*) as num from music group by albumid) as m on a.albumid=m.albumid where userid=?";
		return this.getPagingList(sql, new Object[] { loginUserId });
	}

	public List manageAlbum(String albumid) {
		// TODO Auto-generated method stub
		String sql = "select m.*,t.typename from music as m join type as t on m.typeid=t.typeid where albumid=?";
		return jt.queryForList(sql, new Object[] { albumid });
	}

	public Map getThisAlbum(String albumid) {
		// TODO Auto-generated method stub
		String sql = "select * from album where albumid=?";
		return jt.queryForMap(sql, new Object[] { albumid });
	}

	public int cnt(String albumid) {
		// TODO Auto-generated method stub
		String sql = "select ifnull(m.num,0) as cnt from album as a left join (select *,count(*) as num from music group by albumid) as m on a.albumid=m.albumid where a.albumid=?";
		return jt.queryForInt(sql, new Object[] { albumid });
	}

	public void updateAlbum(String albumname, String albuminfo, String albumid) {
		// TODO Auto-generated method stub
		String sql = "update album set albumname=?,albuminfo=? where albumid=?";
		jt.update(sql, new Object[] { albumname, albuminfo, albumid });
	}

	public void deleteAlbum(String albumid) {
		// TODO Auto-generated method stub
		String sql1 = "delete from music where albumid=?";
		String sql2 = "delete from album where albumid=?";
		jt.update(sql1, new Object[] { albumid });
		jt.update(sql2, new Object[] { albumid });
	}

	public String username(String albumid) {
		// TODO Auto-generated method stub
		String sql = "select u.username from users as u join album as a on a.userid=u.userid where albumid=?";
		return jt.queryForObject(sql, new Object[] { albumid }, String.class);
	}

	public PagingList getalbumlist(String musicid) {
		// TODO Auto-generated method stub
		String sql = "select a.* from album as a join music as m on a.albumid=m.albumid where musicid=?";
		return this.getPagingList(sql, new Object[] { musicid });
	}

	public List albumofuser(String userid) {
		// TODO Auto-generated method stub
		String sql = "select * from album where userid=?";
		return jt.queryForList(sql, new Object[] { userid });
	}

	public List collectofuser(String userid) {
		// TODO Auto-generated method stub
		String sql = "select distinct m.* from music as m join collect as c on m.musicid=c.musicid where userid=?";
		return jt.queryForList(sql, new Object[] { userid });
	}

	public String userid(String albumid) {
		// TODO Auto-generated method stub
		String sql = "select userid from album where albumid=?";
		return jt.queryForObject(sql, new Object[] { albumid }, String.class);
	}

	public String getusername(String userid) {
		// TODO Auto-generated method stub
		String sql = "select username from users where userid=?";
		return jt.queryForObject(sql, new Object[] { userid }, String.class);
	}

	public int pass(Long loginUserId, String userid, String message) {
		// TODO Auto-generated method stub
		String sql = "insert into letter values(null,?,?,?,now())";
		return jt.update(sql, new Object[] { loginUserId, userid, message });
	}

	public List rletter(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select l.*,u.username from letter as l join users as u on l.f=u.userid where t=?";
		return jt.queryForList(sql, new Object[] { loginUserId });
	}

	public List pletter(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select l.*,u.username from letter as l join users as u on l.t=u.userid where f=?";
		return jt.queryForList(sql, new Object[] { loginUserId });
	}

	public int dl(String letterid) {
		// TODO Auto-generated method stub
		String sql = "delete from letter where letterid=?";
		return jt.update(sql, new Object[] { letterid });
	}

	public List gettype() {
		// TODO Auto-generated method stub
		String sql = "select t.*,ifnull(m.num,0) as cnt from type as t left join (select *,count(*) as num from music group by typeid) as m on t.typeid=m.typeid";
		return jt.queryForList(sql);
	}

	public PagingList musicbytype(String typeid) {
		// TODO Auto-generated method stub
		String sql = "select * from music where typeid=?";
		return this.getPagingList(sql, new Object[] { typeid });
	}

	public String gettypename(String typeid) {
		// TODO Auto-generated method stub
		String sql = "select typename from type where typeid=?";
		return jt.queryForObject(sql, new Object[] { typeid }, String.class);
	}

	public void deleteType(String typeid) {
		// TODO Auto-generated method stub
		String sql1 = "delete from type where typeid=?";
		String sql2 = "delete from music where typeid=?";
		jt.update(sql1, new Object[] { typeid });
		jt.update(sql2, new Object[] { typeid });
	}

	public int addtype(String typename) {
		// TODO Auto-generated method stub
		String sql = "insert into type values(null,?)";
		return jt.update(sql, new Object[] { typename });
	}

	public Map getThisType(String typeid) {
		// TODO Auto-generated method stub
		String sql = "select * from type where typeid=?";
		return jt.queryForMap(sql, new Object[] { typeid });
	}

	public void updatetype(String typeid, String typename) {
		// TODO Auto-generated method stub
		String sql = "update type set typename=? where typeid=?";
		jt.update(sql, new Object[] { typename, typeid });
	}

	public String userdetermine(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select admin from users where userid=?";
		return jt.queryForObject(sql, new Object[] { loginUserId }, String.class);
	}

	public String myusername(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select username from users where userid=?";
		return jt.queryForObject(sql, new Object[] { loginUserId }, String.class);
	}

	public List albumofme(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select * from album where userid=?";
		return jt.queryForList(sql, new Object[] { loginUserId });
	}

	public List collectofme(Long loginUserId) {
		// TODO Auto-generated method stub
		String sql = "select distinct m.* from music as m join collect as c on m.musicid=c.musicid where userid=?";
		return jt.queryForList(sql, new Object[] { loginUserId });
	}

	public List getusers() {
		// TODO Auto-generated method stub
		String sql = "select * from users where admin=0";
		return jt.queryForList(sql);
	}

	public List getadmins() {
		// TODO Auto-generated method stub
		String sql = "select * from users where admin=1";
		return jt.queryForList(sql);
	}

	public void setadmin(String userid) {
		// TODO Auto-generated method stub
		String sql = "update users set admin=1 where userid=?";
		jt.update(sql, new Object[] { userid });
	}

	public void deleteuser(String userid) {
		// TODO Auto-generated method stub
		String sql = "delete from users where userid=?";
		jt.update(sql, new Object[] { userid });
	}

	public void reg(String username, String pass) {
		// TODO Auto-generated method stub
		String sql = "insert into users values(null,?,?,0)";
		jt.update(sql, new Object[] { username, pass });
	}

}
