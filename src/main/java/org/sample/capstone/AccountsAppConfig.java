package org.sample.capstone;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountsAppConfig {
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
