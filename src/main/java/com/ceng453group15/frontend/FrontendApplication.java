package com.ceng453group15.frontend;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontendApplication {

	public static void main(String[] args) {
		Application.launch(LoginPage.class, args);
	}
}
