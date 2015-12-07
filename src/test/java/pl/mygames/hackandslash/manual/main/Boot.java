package pl.mygames.hackandslash.manual.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan
//@TestPropertySource(locations="classpath:test.properties")
public class Boot extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(Boot.class, args);
//		HeroMain.testAddHero();
//		RulesMain.popuateAttributes();
		FactoryMain.testFactoryHero();
	}
	
    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Boot.class);
    }
}