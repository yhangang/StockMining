package org.a805.struts2.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.a805.service.SystemService;
import org.a805.service.UserService;
import org.a805.tools.DateFormatTransfer;
import org.apache.struts2.ServletActionContext;

import com.hibernate.entity.TLoginLog;
import com.hibernate.entity.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String pwd;
	private String recertCode;
	private UserService userService;
	private SystemService systemService;
	private String oldPwd;
	private String newPwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRecertCode() {
		return recertCode;
	}

	public void setRecertCode(String recertCode) {
		this.recertCode = recertCode;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	/**
	 * 登录功能
	 * 
	 * @return
	 */
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String certCode = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("certCode");
		
		if(recertCode == null){
			recertCode = "";
		}
		
		

		// 用户已登录
		if (session.getAttribute("loginName") != null) {
			return "success";
		}

		// 验证码错误
		if (!this.recertCode.equals(certCode)) {
			return "error";
		}

		// 验证账户密码	
		TUser tUser = userService.checkUser(username);
		if (tUser == null) {
			//用户名不存在
			return "error";
		}
		else if(tUser.getPwd().equals(pwd)){
			//验证通过,开始写登录日志
			TLoginLog loginLog = new TLoginLog();
			String loginHost = request.getRemoteHost();// 获得登录客户端的主机名称
			String loginIp = request.getRemoteAddr();// 获得登录客户端的IP
			Date date = new Date();
			
			loginLog.setUsername(tUser.getUsername());
			loginLog.setRealname(tUser.getRealname());
			loginLog.setLoginHost(loginHost);
			loginLog.setLoginIp(loginIp);
			loginLog.setLoginTime(new Date());
					
			
			systemService.save(loginLog);
		
			
			session.setAttribute("loginName", tUser.getRealname());
			session.setAttribute("loginer", tUser);
			return "success";
		}
		else{
			//密码错误
			return "error";
		}


	}


	/**
	 * 注册
	 * 
	 * @return
	 */
	public String register() {
		

		return "success";
	}
	/**
	 * 重新登录
	 */
	public String reLogin(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		
		return "success";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String resetPwd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		TUser tuser = (TUser)session.getAttribute("loginer");
		String flag = userService.changePwd(tuser, oldPwd, newPwd);
		if(flag.equals("error")){
			request.setAttribute("msg", "原密码错误！");
			return "error";
		}
		request.setAttribute("msg", "密码修改成功！");
		return "success";
	}

}
