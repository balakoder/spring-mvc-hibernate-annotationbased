package com.bala.spring.controller;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.Valid;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bala.spring.config.dao.UserDao;
import com.bala.spring.model.User;
import com.bala.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	private User user;
	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String Register(@ModelAttribute("user") User user, Model model) {
		// userValidator.validate(userForm, bindingResult);
		logger.info("before binding the new user.", "User");
		model.addAttribute("title", "Login");
		// logger.info("before saving the new user.", "User");
		// userService.save(user);
		// logger.info("after saving the new user.", "User");
		// securityService.autologin(user.getUsername(),
		// user.getPasswordConfirm());

		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		// userValidator.validate(userForm, bindingResult);
		logger.info("before binding the new user.", "User");

		logger.info("before saving the new user.", "User");
		userService.save(user);
		logger.info("after saving the new user.", "User");
		// securityService.autologin(user.getUsername(),
		// user.getPasswordConfirm());

		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logoutl) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "Login");
		model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model) {
		

		return "redirect:/success";

	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String Welcome(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "Welcome Bala !!! You created user!!!!");
		return "welcome";

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String Home(Model model) {

		List userlist = userService.getUserList();
		model.addAttribute("userlist", userlist);
		model.addAttribute("message", "Welcome Bala !!! You created user!!!!");
		model.addAttribute("title", "Home");
		return "welcome";

	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String Successt(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "Login");
		model.addAttribute("message", "You have loggged in successfully.");
		return "success";

	}
}
