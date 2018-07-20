package com.github.hasanmirzae.briefcasedesktop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class BriefcaseDesktopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriefcaseDesktopApplication.class, args);
	}

	@Bean CommandLineRunner commandLineRunner(Environment env){
		return args -> {
			openBrowser("http://localhost:"+env.getProperty("local.server.port"));
		};
	}

	private void openBrowser(String url) throws IOException {

		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		} else {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
