package gsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.GasStateInput;
import io.GasStateOutput;

@RestController
public class GscController {
	
	@Autowired
	private GasStateCalculationService gasStateCalclulationService; 

	@RequestMapping("/")
	public String index() {
		return "Greetings from the Gas State Calculator!";
	}

	@RequestMapping("/greeting")
	public String greet() {
		return "This is the greeting thing!";
	}
	
	@RequestMapping("/calculate")
	public GasStateOutput calculateGasState(@RequestBody GasStateInput input)
	{
		return gasStateCalclulationService.calculateGasState(input);
	}
}
