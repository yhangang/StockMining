package org.a805.struts2.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.a805.service.UserService;
import org.a805.tools.PageView;
import org.apache.struts2.ServletActionContext;

import com.hibernate.entity.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class UserManagementAction extends ActionSupport{
	public static final int PAGESIZE = 10;
	public static final int FIRSTPAGE = 1;
	public static final String SUPERMANAGER = "000001";
	public static final String MANAGER = "000002";
	public static final String COMMONUSER = "000003";
	
	private TUser tuser;
	private UserService userService;
	private int id;
	private int currentPage = FIRSTPAGE;

	public TUser getTuser() {
		return tuser;
	}

	public void setTuser(TUser tuser) {
		this.tuser = tuser;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String query(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		PageView<TUser> pageview = new PageView<TUser>(currentPage,
				PAGESIZE);
		
		
		pageview.setResultlist(userService.queryByPage(tuser, pageview
				.getCurrentrecord(), pageview.getPagesize()));
		pageview.setTotalrecord(userService.getCount(tuser));
		request.setAttribute("queryResult", pageview);
		request.setAttribute("tuser", tuser);
		
		return "success";
	}
	
	public String delete(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		TUser user = (TUser)session.getAttribute("loginer");
		if(!SUPERMANAGER.equals(user.getRoleId())){
			return "lackofpower";
		}
		
		String flag = userService.delete(id);
		
		return flag;
	}
	
	public String update(){
		
		String flag = userService.update(tuser);
		
		return flag;
	}
	
	public String save(){
		HttpServletRequest request = ServletActionContext.getRequest();
		tuser.setRoleId(COMMONUSER);
		
		
		String flag = userService.save(tuser);
		if("error".equals(flag)){
			request.setAttribute("msg", "×¢²áÊ§°Ü");
		}
		else{
			request.setAttribute("msg", "×¢²á³É¹¦");
		}
		
		return flag;
	}
	
	public String findTUserById(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		TUser user = (TUser)session.getAttribute("loginer");
		if(!SUPERMANAGER.equals(user.getRoleId())){
			return "lackofpower";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		TUser tuser = userService.findTUserById(id);
		request.setAttribute("tuser", tuser);
		return "success";
	}
	
	public void ajaxValidate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		
		String username= request.getParameter("username");
		try {
			if(userService.isExist(username)){
				response.getWriter().write("false");
			}
			else{
				response.getWriter().write("true");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
