package cn.smbms.servlet.user;/*
package cn.cn.smbms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cn.smbms.pojo.User;
import cn.cn.smbms.service.user.UserService;
import cn.cn.smbms.service.user.UserServiceImpl;
import cn.cn.smbms.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServlet extends HttpServlet {

	@Autowired
	private UserService userService;
*/
/** Constructor of the object.*//*

	public LoginServlet() {
		super();
	}

*/
/**
	 * Destruction of the servlet. <br>*//*



	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

*/
/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred*//*



	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

*/
/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred*//*



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login ============ " );
		//获取用户名和密码
		String userCode = request.getParameter("userCode");
		String userPassword = request.getParameter("userPassword");
		//调用service方法，进行用户匹配
		User user = userService.login(userCode,userPassword);
		if(null != user){//登录成功
			//放入session
			request.getSession().setAttribute(Constants.USER_SESSION, user);
			//页面跳转（frame.jsp）
			response.sendRedirect("jsp/frame.jsp");
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

*/
/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs*//*



	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
*/
