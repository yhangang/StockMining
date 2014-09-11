package org.a805.struts2.interceptor;

import java.util.Map;

import com.hibernate.entity.TUser;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticationInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		TUser user = (TUser) session.get("loginer");
		
		if(user!=null){
			return invocation.invoke();
		}else{
			return Action.LOGIN;
		}
		
	}

}                                                 
