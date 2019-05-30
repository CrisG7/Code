package com.sise.ssh.gh.interceptor;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		ActionContext ctx=invocation.getInvocationContext();
		Map session=ctx.getSession();
		if(session.get("username")!=null){
			System.out.println("�û��ѵ�¼");
			return invocation.invoke();
		}else{
			ctx.put("tip","����û�е�¼�����¼��");
			return Action.LOGIN;
		}
		
	}

}
