package projetQuizz.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("projetQuizz.services")
@PropertySource("classpath:data-source.properties")
@EnableJpaRepositories(basePackages = "projetQuizz.repositories")
public class JpaConfig {
	
	@Autowired
	private Environment env;
	
	// DataSource=>base de donnée
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(env.getProperty("datasource.url"));
		dataSource.setUsername(env.getProperty("datasource.username"));
		dataSource.setPassword(env.getProperty("datasource.password"));
		dataSource.setMaxTotal(5);
		return dataSource;
	}
	
	// EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		// emplacement des entity
		emf.setPackagesToScan("projetQuizz.entities");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("hibernate.format_sql", "true");
		emf.setJpaProperties(properties);
		return emf;
	}
	
	// gestion des transactions
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
}
