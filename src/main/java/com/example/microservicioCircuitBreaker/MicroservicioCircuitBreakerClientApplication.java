package com.example.microservicioCircuitBreaker;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.microservicioCircuitBreaker.services.Service;

@SpringBootApplication
public class MicroservicioCircuitBreakerClientApplication implements CommandLineRunner {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MicroservicioCircuitBreakerClientApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		Service service = new Service();
		
		for (int i = 0; i < 10; i++) {
			
			
			if (i < 9) {
				service.open();
				service.halfOpen();
				Thread.sleep(1000);
			}
			
			if (i == 9) {
				service.close();
			}

			

		}
		
	}

}
