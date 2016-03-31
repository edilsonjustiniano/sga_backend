package br.com.sga.backend.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import br.com.sga.backend.configuration.SgaConfiguration;

public class WebAppInitializer implements ApplicationContextInitializer<AnnotationConfigWebApplicationContext> {

	public void initialize(AnnotationConfigWebApplicationContext context) {
		context.setDisplayName("sga_backend");
		context.register(SgaConfiguration.class);
	}

}
