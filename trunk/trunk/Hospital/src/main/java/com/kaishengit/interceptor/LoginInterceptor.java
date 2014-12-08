package com.kaishengit.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;
	
	//从配置文件中获取
	private String namespace;
	private String actionNames;
	private List<String> actionList = new ArrayList<String>();
	private String sessionName;

	//对namespace为admin的且actionName为home或者login的都不拦截
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionProxy proxy = invocation.getProxy();
		//获取请求的
		String actionName = proxy.getActionName();
		String space = proxy.getNamespace();
		
	
		if(namespace.equals(space) && actionList.contains(actionName)) {
			return proxy.execute();
		}else {
			//从session中获取当前登录的对象
			ActionContext actionContext = invocation.getInvocationContext();
			Map<String, Object> session = actionContext.getSession();
			
			Object currAdmin = session.get(sessionName);
			
			if(currAdmin != null) {
				return proxy.execute();
			}else {
				return Action.LOGIN;
			}
			
		}
		
		
	}
	


	//get set
	public String getNamespace() {
		return namespace;
	}


	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}


	public String getActionNames() {
		return actionNames;
	}


	public void setActionNames(String actionNames) {
		//如果actionNames只有一个值
		if(actionNames.indexOf(",") == -1) {
			actionList.add(actionNames);
		}else {
			String[] names = actionNames.split(",");
			for(String name : names) {
				actionList.add(name);
			}
		}	
	}


	public String getSessionName() {
		return sessionName;
	}


	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	
	
	
}
