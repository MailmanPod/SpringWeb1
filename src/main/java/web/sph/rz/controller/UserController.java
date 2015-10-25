package web.sph.rz.controller;

import java.sql.Date;

import web.sph.rz.entity.UserEntity;
import web.sph.rz.service.ServiceUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private ServiceUserDAO<UserEntity> service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listingUsers(Model model) {
		model.addAttribute("allUsers", service.listAllUsers());
		return "index";
	}
	
	@RequestMapping(value="/registerRedirect", method=RequestMethod.GET)
	public String addRedirect(Model model) {
		UserEntity userForm = new UserEntity();

		model.addAttribute("userForm", userForm);
		
		return "addUser";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String addRegister(@ModelAttribute("userForm")UserEntity entity, Model model) {
		long startDate = System.currentTimeMillis();
		long endDate = 64060513200000L;
		entity.setStartDate(new Date(startDate));
		entity.setEndDate(new Date(endDate));
		service.addUser(entity);
		
		model.addAttribute("allUsers", service.listAllUsers());
		
		return "index";
	}
	
	@RequestMapping(value="/editRedirect/{username}", method=RequestMethod.GET)
	public String updateRedirect(@PathVariable String username, Model model) {
		
		UserEntity finder = service.retrieveUserByName(username);
		
		model.addAttribute("userToEdit", username);
		model.addAttribute("original", finder);
		
		return "updateUser";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateRegister(@ModelAttribute("original") UserEntity entity, Model model) {
		
		UserEntity finder = service.retrieveUser(entity.getId());
		
		if(entity.getPassword().equalsIgnoreCase("")) {
			entity.setPassword(finder.getPassword());
		}
		
		service.updateUser(entity);
		
		model.addAttribute("allUsers", service.listAllUsers());
		
		return "index";
	}
	
	@RequestMapping(value="/delete/{username}", method=RequestMethod.GET)
	public String deleteRegister(@PathVariable String username, Model model) {
		UserEntity finder = service.retrieveUserByName(username);
		
		service.deleteUser(finder.getId());
		
		model.addAttribute("allUsers", service.listAllUsers());
		
		return "index";
	}
}
