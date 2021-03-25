package ku.message.controller;

import ku.message.dto.SignupDto;
import ku.message.model.User;
import ku.message.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/signup")
public class SignupController{
	@Autowired
	private UserService userService;

	@GetMapping
	public String signupView(SignupDto signupDto)
	{
		return "signup";
	}

	@PostMapping
	public String signupUser(@Valid SignupDto signupDto, BindingResult result, Model model)
	{
		if (result.hasErrors())
		{
			return "signup";
		}

		String signupError = null;

		if (!userService.isUsernameAvailable(signupDto.getUsername()))
			signupError = "The username already exists.";

		if (signupError == null)
		{
			userService.createUser(signupDto);
			model.addAttribute("signupSuccess", true);
		}

		else
		{
			model.addAttribute("signupError", signupError);
		}

		model.addAttribute("signupDto", new SignupDto());
		return "signup";
	}
}
