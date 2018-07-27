package com.github.hasanmirzae.briefcasedesktop;

import com.github.hasanmirzae.briefcasedesktop.utils.OSHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BriefcaseDesktopApplication {

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ConfigurableApplicationContext ctx = SpringApplication.run(BriefcaseDesktopApplication.class, args);
				OSHelper.createAndShowGUI(ctx);
			}
		});

	}




	@Bean CommandLineRunner commandLineRunner(Environment env){
		return args -> {
			OSHelper.openBrowser("http://localhost:"+env.getProperty("local.server.port"));
		};
	}




}
