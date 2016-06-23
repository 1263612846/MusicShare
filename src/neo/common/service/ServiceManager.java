package neo.common.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import neo.photo.service.AlbumService;
import neo.photo.service.PhotoService;
import neo.photo.service.StatService;

@Service(value = "servMgr")
public class ServiceManager {
	protected final Log log = LogFactory.getLog(getClass());

	/* 项目所用到的 Service */
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "albumService")
	private AlbumService albumService;
	@Resource(name = "photoService")
	private PhotoService photoService;
	@Resource(name = "statService")
	private StatService statService;

	/* Service 的存取方法 */
	public PhotoService getPhotoService() {
		return photoService;
	}

	/*
	 * public void setTaskService(TaskService taskService) { this.taskService =
	 * taskService; }
	 */

	public AlbumService getAlbumService() {
		return albumService;
	}

	public StatService getStatService() {
		return statService;
	}

	public UserService getUserService() {
		return userService;
	}

	/*
	 * public void setUserService(UserService userService) { this.userService =
	 * userService; }
	 */

}
