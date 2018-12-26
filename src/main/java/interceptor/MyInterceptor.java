package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import model.User;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在springmvc中配置了<mvc:exclude-mapping/>
		//boolean b1 = request.getRequestURI().endsWith("/tologin.do");
		//boolean b2 = request.getRequestURI().endsWith("/login.do");
		User sessionUser = (User) request.getSession().getAttribute("sessionUser");
		if ( sessionUser != null) {
			return true;
		}
		response.sendRedirect("tologin.do");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
