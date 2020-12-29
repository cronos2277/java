package Springann.datasource;
import java.sql.SQLException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Config {
private static final String driver = "org.postgresql.Driver";
private static final String url= "jdbc:postgresql://localhost:5432/postgres";
private static final String user = "postgres";
private static final String pass = "123456";
private DriverManagerDataSource dmds = null;

	@Bean
	public DriverManagerDataSource dataSource() throws SQLException {
		dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(Config.driver);
		dmds.setUrl(Config.url);
		dmds.setUsername(Config.user);
		dmds.setPassword(Config.pass);
		System.out.println("DriverManagerDataSource carregado com sucesso");		
		return dmds;
	}
	
	
}
