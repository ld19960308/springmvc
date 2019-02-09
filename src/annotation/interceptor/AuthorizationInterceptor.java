package annotation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import annotation.validation.Login;

public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URI={"/interceptor/intercept","/interceptor/loginForm"};
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AuthorizationInterceptor afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AuthorizationInterceptor postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AuthorizationInterceptor preHandle");
		boolean flag=false;
		String servletPath=request.getServletPath();
		for(String s: IGNORE_URI){
			if(servletPath.contains(s)){
				flag=true;
				break;
			}
		}
		if(!flag){
			Login login=(Login)request.getSession().getAttribute("user");
			if(login==null){
				System.out.println("AuthorizationInterceptor拦截请求:");
				request.setAttribute("message", "请先登录再访问网站");
				request.getRequestDispatcher("/interceptor/loginForm").forward(request, response);
			}
			else{
				System.out.println("AuthorizationInterceptor放行请求:");
				flag=true;
			}
		}
		return flag;
	}

}
