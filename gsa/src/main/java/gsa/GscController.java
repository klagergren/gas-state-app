package gsa;

import categories.GasProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.GasStateInput;
import io.GasStateOutput;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

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


	@PostMapping("/calculate")
	@CrossOrigin(origins = {"http://localhost:3000"})
	public GasStateOutput calculateGasState(@RequestBody GasStateInput input)
	{
		//@RequestBody tells spring that a JSON representation of GasStateInput will be in the request payload, and it should
		//be mapped into the GasStateInput object
		return gasStateCalclulationService.calculateGasState(input);
	}

	//Just some demo code for reference below...
	@RequestMapping("/gasproperties")
	public Set<GasProperty> getGasProperties() {
		return EnumSet.allOf(GasProperty.class);
	}

	@RequestMapping("/gasdata/{id}") //Spring automatically maps curly brace as a variable to String id argument.
	public String getGasData(@PathVariable String id)
	{
		//Do something to get data from a database with given id
		return null;
	}
}
