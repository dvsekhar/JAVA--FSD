package com.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.users.dao.UsersDAO;
import com.users.entity.UsersEntity;

@Controller
public class UsersController {
	
	@Autowired
	private UsersDAO userDAO;

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<UsersEntity> usersList = userDAO.getAllUsers();

		model.addAttribute("userlist", usersList);

		return "list-users"; 

	}
	
	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable int id, Model model) {
		
        UsersEntity user = userDAO.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user"; 
    }

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	 public String updateUser(@ModelAttribute("user") UsersEntity user) {
		
		userDAO.update(user);
	    return "list-users"; 
	 }
	
}