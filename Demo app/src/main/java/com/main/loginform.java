package com.main;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginform")
public class loginform extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		if(username.equals("demoapp")&&password.equals("1234")) {
			req.setAttribute("username", username);
			RequestDispatcher rd=req.getRequestDispatcher("welcome");
			rd.forward(req, res);
			
		}
		else {
			out.println("sorry! username or password error");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
				
		
	}

}
