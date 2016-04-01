package br.com.sga.backend.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import br.com.sga.backend.api.StudentService;
import br.com.sga.backend.api.impl.StudentServiceImpl;
import br.com.sga.backend.business.StudentBusiness;
import br.com.sga.backend.dao.StudentDao;
import br.com.sga.backend.validator.StudentValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@Import({SgaDatabaseConfiguration.class})
@ComponentScan(value = "br.com.sga.backend.api.impl")
public class SgaConfiguration {

	@Bean
	public StudentService studentService(){
		return new StudentServiceImpl();
	}
	
	@Bean
	public StudentDao studentDao(){
		return new StudentDao();
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
