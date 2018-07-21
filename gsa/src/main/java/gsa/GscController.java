package gsa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GscController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from the Gas State Calculator!";
	}

	@RequestMapping("/greeting")
	public String greet() {
		return "This is the greeting thing!";
	}
}
