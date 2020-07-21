package board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude={MultipartAutoConfiguration.class})
public class BoardApplication {

	//어플리케이션 돌아가게하는것 
	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
	

}
