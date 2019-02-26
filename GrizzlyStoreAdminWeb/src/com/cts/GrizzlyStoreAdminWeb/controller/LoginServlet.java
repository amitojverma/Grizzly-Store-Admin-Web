package com.cts.GrizzlyStoreAdminWeb.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.GrizzlyStoreAdminWeb.service.LoginService;
import com.cts.GrizzlyStoreAdminWeb.service.LoginServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService loginService = LoginServiceImpl.getInstance();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		System.out.print(userId+" "+password);
		RequestDispatcher requestDispatcher = null; // Object Reference/
		if(loginService.authenticate(userId, password)){
			int userStatus = loginService.getUserStatus(userId);
			String authorization = loginService.authorization(userId);
			if("A".equals(authorization)){
				if(userStatus == 0){
					// Creating session
					HttpSession session = request.getSession();
					session.setAttribute("userId", userId);
					requestDispatcher = request.getRequestDispatcher("admin.jsp");
					requestDispatcher.forward(request, response);
				}
				else if(userStatus == 1){
					requestDispatcher = request.getRequestDispatcher("alogin.jsp");
					requestDispatcher.forward(request, response);
				}
				else if(userStatus == 2){
					requestDispatcher = request.getRequestDispatcher("deactivate.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			else if("V".equals(authorization)){
				if(userStatus == 0){
					HttpSession session = request.getSession();
					session.setAttribute("userId", userId);
					requestDispatcher = request.getRequestDispatcher("vendorHome.jsp");
					requestDispatcher.forward(request, response);
				}
				else if(userStatus == 1){
					requestDispatcher = request.getRequestDispatcher("alogin.jsp");
					requestDispatcher.forward(request, response);
				}
				else if(userStatus == 2){
					requestDispatcher = request.getRequestDispatcher("deactivate.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			else if("U".equals(authorization)){
				if(userStatus == 0){
					HttpSession session = request.getSession();
					session.setAttribute("userId", userId);
					requestDispatcher = request.getRequestDispatcher("userHome.jsp");
					requestDispatcher.forward(request, response);
				}
				else if(userStatus == 1){
					requestDispatcher = request.getRequestDispatcher("alogin.jsp");
					requestDispatcher.forward(request, response);
				}
				else if(userStatus == 2){
					requestDispatcher = request.getRequestDispatcher("deactivate.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			
		}
		else{
			// Redirect to Home page
			requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
