package de.ing.slimeventcommandside.events.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ApplicationChannels {
	

	@Output MessageChannel  personInsertedOut();
	@Output MessageChannel  personUpdatedOut();
	@Output MessageChannel  personDeletedOut();
	
		
}
