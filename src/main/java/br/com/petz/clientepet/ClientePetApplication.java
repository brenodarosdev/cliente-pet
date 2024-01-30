package br.com.petz.clientepet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class ClientePetApplication {
//	http://localhost:8080/cliente-pet/api/swagger
//	http://localhost:8080/cliente-pet/api/swagger-ui/index.html
	
	@GetMapping
	public String getHomeTeste() {
		return "Cliente Pet - API Home";
	}
  
	public static void main(String[] args) {
		SpringApplication.run(ClientePetApplication.class, args);
	}

}
