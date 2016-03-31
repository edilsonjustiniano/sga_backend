package br.com.sga.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.sga.backend.api.StudentService;
import br.com.sga.backend.api.impl.StudentServiceImpl;
import br.com.sga.backend.business.StudentBusiness;
import br.com.sga.backend.dao.HibernateUtil;
import br.com.sga.backend.dao.StudentDao;
import br.com.sga.backend.validator.StudentValidator;

@Configuration
@ComponentScan(value = "br.com.sga.backend.api.impl")
public class SgaConfiguration {

	@Bean
	public StudentService studentService(){
		return new StudentServiceImpl();
	}
	
	@Bean
	public StudentDao studentDao(){
		return new StudentDao(HibernateUtil.getEntitymanager());
	}
	
	@Bean
	public StudentValidator studentValidator(){
		return new StudentValidator();
	}
	
	@Bean
	public StudentBusiness studentBusiness(StudentDao studentDao){
		return new StudentBusiness(studentDao);
	}
}
