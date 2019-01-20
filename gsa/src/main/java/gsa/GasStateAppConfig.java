package gsa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gasstate.GasStateCalculator;

@Configuration
public class GasStateAppConfig {

	@Bean
	public GasStateCalculator getGasStateCalculator()
	{
		return new GasStateCalculator();
	}
}
