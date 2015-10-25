package web.sph.rz.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ResourceConfigurator {

	@Resource
	private Environment enviroment;

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getProperty("db.driverClassName"));
		dataSource.setUrl(enviroment.getProperty("db.url"));
		dataSource.setUsername(enviroment.getProperty("db.user"));
		dataSource.setPassword(enviroment.getProperty("db.password"));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setPackagesToScan(enviroment
				.getProperty("entitymanager.packages.to.scan"));
		factoryBean.setHibernateProperties(hibernateProperties());
		return factoryBean;
	}

	private Properties hibernateProperties() {
		Properties prop = new Properties();

		prop.put("hibernate.dialect",
				enviroment.getProperty("hibernate.dialect"));
		prop.put("hibernate.format_sql",
				enviroment.getProperty("hibernate.format_sql"));
		prop.put("hibernate.show_sql",
				enviroment.getProperty("hibernate.show_sql"));
		prop.put("hibernate.connection.pool_size",
				enviroment.getProperty("hibernate.connection.pool_size"));

		return prop;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(getSessionFactory().getObject());
		return htm;
	}
}
