package board.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {

		@Autowired
		private ApplicationContext applicationContext;
		
		@Bean
		@ConfigurationProperties(prefix="spring.datasource.hikari")
		public HikariConfig hikariConfig() {
			return new HikariConfig();
			
		}
		
		@Bean
		public DataSource dataSource() throws Exception{
			return new HikariDataSource(hikariConfig());
		}
		
		@Bean
		public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*.xml"));
			
			return sqlSessionFactoryBean.getObject();
		}
		@Bean
		
		public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
			return new SqlSessionTemplate(sqlSessionFactory);
		}
		// 꼭  terminal에서 mysql server start 하고  GRANT ALL PRIVILEGES ON board.* TO 'board'@'localhost' IDENTIFIED BY '1234'; 권한을데이타베이스 정해놓고 다줘야된다

}