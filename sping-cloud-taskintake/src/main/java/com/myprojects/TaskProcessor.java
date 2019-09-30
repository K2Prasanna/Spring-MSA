package com.myprojects;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class TaskProcessor {
	
	@Autowired
	public Source source;
	
	public void publishMessage(String message)
	{
		String url = "maven://com.myprojects:sping-cloud-task:jar:0.0.1-SNAPSHOT";
		
		List<String> args = Arrays.asList(message.split(","));
		
		TaskLaunchRequest tlr = new TaskLaunchRequest(url, args, null, null, null);
		
		GenericMessage<TaskLaunchRequest> outmessage = new GenericMessage<TaskLaunchRequest>(tlr);
		System.out.println("sending message out");
		source.output().send(outmessage);
	}
}
