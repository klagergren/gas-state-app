package gsa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GscController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/greeting")
	public String greet() {
		return "This is the greeting thing!";
	}
}
