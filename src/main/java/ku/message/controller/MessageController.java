package ku.message.controller;

import ku.message.dto.MessageDto;
import ku.message.model.Message;
import ku.message.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class MessageController {

	private MessageRepository repository;

	public MessageController(MessageRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/message")
	public String getMessagePage(Model model)
	{
		model.addAttribute("messages", repository.findAll());
		return "message";
	}

	@GetMapping("/post")
	public String getPostPage()
	{
		return "post";
	}

	@PostMapping("/message")
	public String postMessage(@ModelAttribute MessageDto message, Model model, Principal principal)
	{
		String username = principal.getName();
		messageService.create(message, username);
		model.addAttribute("messages", messageService.getMessages());

		return "redirect:message";
	}


}
