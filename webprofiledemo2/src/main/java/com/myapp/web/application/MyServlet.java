package com.myapp.web.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns="/home")
//public class MyServlet extends HttpServlet{
//	// HttpServlet is an abstract class.
//	
//	
//	private static final long serialVersionUID = 1L;
//	
//	@Override 
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////	    PrintWriter out = resp.getWriter();
////	    
////	    // Adding the HTML content.
////	    out.write("<html>");
////	    out.write("<body>");
////	    out.write("<h1>Welcome to World of Services</h1>");
////	    out.write("</body>");
////	    out.write("</html>");
//		
//		// Our message object is linked to the message reference.
//		req.setAttribute("message","Welcome to World OF Servlets");
//		req.getRequestDispatcher("index.jsp").forward(req,resp);
//	}
//
//}

@WebServlet(urlPatterns = "/home")
public class MyServlet extends HttpServlet {
   
   
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        
//        out.write("<html>");
//        out.write("<body>");
//        out.write("<h1>Welcome To World Of Servlets</h1>");
//        out.write("</body>");
//        out.write("</html>");
       
        getServletContext().setAttribute("message", "Welcome To World OF Servlets");
       
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
   }

}
