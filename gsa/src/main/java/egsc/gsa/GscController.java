package egsc.gsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egsc.io.GasStateInput;
import egsc.io.GasStateOutput;

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
	public GasStateOutput calculateGasState(GasStateInput input)
	{
		return gasStateCalclulationService.calculateGasState(input);
	}
}
