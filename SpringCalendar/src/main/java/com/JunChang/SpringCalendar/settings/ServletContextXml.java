package com.JunChang.SpringCalendar.settings;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.JunChang.SpringCalendar")
@EnableWebMvc // <mvc:annotation-driven />
@Import({ SecurityContextXml.class }) // <-- 추가 된 부분
public class ServletContextXml extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public SqlSessionFactoryBean setSqlSessionFactoryBean(DataSource dataSource, ApplicationContext applicationContext)
			throws IOException {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

		final String configLocation = "/WEB-INF/spring/mybatis/mybatis-conf.xml";
		final String resourceLocation = "/WEB-INF/spring/mybatis/mapper/*";

		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setConfigLocation(applicationContext.getResource(configLocation));
		sqlSessionFactory.setMapperLocations(applicationContext.getResources(resourceLocation));

		return sqlSessionFactory;
	}

	@Bean(name = "sqlSession")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sqlSessionTemplate;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db_springproject" 
		+ "?useSSL=false&characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("rladlsckd12");

		dataSource.setMaxActive(10);
		dataSource.setInitialSize(2);

		dataSource.setMinIdle(2);
		dataSource.setMaxIdle(5);

		dataSource.setTestWhileIdle(true);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTimeBetweenEvictionRunsMillis(7200000);
		dataSource.setMinEvictableIdleTimeMillis(28000000);

		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = 
				new DataSourceTransactionManager(dataSource);

		return dataSourceTransactionManager;
	}

	@Bean
	public InternalResourceViewResolver setInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public PasswordEncoder setPasswordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Override // <mvc:interceptors>
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(setWebContentInterceptor());
	}

	private WebContentInterceptor setWebContentInterceptor() {
		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(0);
		return interceptor;
	}
}
