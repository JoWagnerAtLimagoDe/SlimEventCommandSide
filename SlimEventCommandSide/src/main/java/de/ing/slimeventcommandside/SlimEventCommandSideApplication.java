package de.ing.slimeventcommandside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import de.ing.slimeventcommandside.events.messaging.ApplicationChannels;

@SpringBootApplication
@EnableBinding(ApplicationChannels.class)
public class SlimEventCommandSideApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlimEventCommandSideApplication.class, args);
	}

}
