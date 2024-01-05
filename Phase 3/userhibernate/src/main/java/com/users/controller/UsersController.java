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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value= "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam String fname, @RequestParam String lname, @RequestParam int age, @RequestParam long phone) {

        UsersEntity newUser = new UsersEntity();
        newUser.setFname(fname);
        newUser.setLname(lname);
        newUser.setAge(age);
        newUser.setPhone(phone);

        userDAO.save(newUser);

        return "redirect:/listUsers";
    }
	
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public String getUserById() {
        return "getUserById";
    }

    @RequestMapping(value = "/edituser", method = RequestMethod.POST)
    public String editUser(@RequestParam int userId, Model model) {
        UsersEntity user = userDAO.getUserById(userId);
        
        if (user != null) {
            model.addAttribute("user", user);
            return "edituser"; 
        } else {
            return "userNotFound"; 
        }
    }

	@PostMapping("/updateuser")
	public String Update(@RequestParam int id, @RequestParam String fname, @RequestParam String lname, @RequestParam int age, @RequestParam long phone) {
	    UsersEntity existingUser = userDAO.getUserById(id);
	    
	    if (existingUser != null) {
	        existingUser.setFname(fname);
	        existingUser.setLname(lname);
	        existingUser.setAge(age);
	        existingUser.setPhone(phone);
	        userDAO.update(existingUser);
	    }
	    
	    return "redirect:/listUsers";
	}


	
}