package io.jaconunes.walletcontrolapi;

import io.jaconunes.walletcontrolapi.servive.ConversorMoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WalletControlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletControlApiApplication.class, args);
	}

	@Autowired
	private ConversorMoedaService conversorMoedaService;
}
