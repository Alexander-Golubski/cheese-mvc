package org.launchcode.cheesemvc;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CheeseMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheeseMvcApplication.class, args);
		ArrayList<Cheese> cheeses = new ArrayList<>();
	}

}

