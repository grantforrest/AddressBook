package com.familymanager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.familymanager.DAO.UserDAO;
import com.familymanager.model.User;

public class UserController extends Controller{


	/**
	 * 
	 */
	private static final long serialVersionUID = -43708656443249580L;

	protected UserDAO userDAO;
	private String INSERT_OR_EDIT = "/user.jsp";
	private String LIST_USER = "/listUser.jsp";
	public UserController(){
		super();
		this.userDAO = new UserDAO();
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	String forward="";  
    	  
        String action = request.getParameter("action");  
  
  
  
        if (action.equalsIgnoreCase("delete")){  
  
            int userId = Integer.parseInt(request.getParameter("userId"));  
            User user = userDAO.getByID(userId);
  
            userDAO.delete(user); 
  
            forward = LIST_USER;  
  
            request.setAttribute("users", userDAO.getAll());     
  
        } else if (action.equalsIgnoreCase("edit")){  
  
            forward = INSERT_OR_EDIT;  
  
            int userId = Integer.parseInt(request.getParameter("userId"));  
  
            User user = userDAO.getByID(userId);
            request.setAttribute("user", user);  
  
        } else if (action.equalsIgnoreCase("listUser")){  
  
            forward = LIST_USER;  
  
            request.setAttribute("users", userDAO.getAll()); 
  
        } else {  
  
            forward = INSERT_OR_EDIT;  
  
        }  
  
  
  
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
  
    	
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	  
        User user = new User();  
        user.setUsername(request.getParameter("userName"));  
  
        user.setPassword(request.getParameter("password"));  
  
  
           userDAO.insert(user);  
  
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);  
  
        request.setAttribute("users", userDAO.getAll());  
  
        view.forward(request, response);  
  
    }  
    
	
	
	
}
