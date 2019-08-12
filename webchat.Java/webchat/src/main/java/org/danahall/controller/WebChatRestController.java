package org.danahall.controller;

import org.danahall.dto.requests.CreateRequestMessage;
import org.danahall.dto.requests.DeleteRequestMessage;
import org.danahall.dto.requests.UpdateRequestMessage;
import org.danahall.dto.responses.CreateResponseMessage;
import org.danahall.dto.responses.DeleteResponseMessage;
import org.danahall.dto.responses.ReadResponseMessage;
import org.danahall.dto.responses.UpdateResponseMessage;
import org.danahall.service.WebChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

///////////////////////////////////////////////
// References:
// https://examples.javacodegeeks.com/enterprise-java/spring/mvc/spring-mvc-crud-using-mongodb-tutorial/
// https://www.mkyong.com/mongodb/spring-data-mongodb-hello-world-example/
// https://www.journaldev.com/4011/mongodb-java-servlet-web-application-example-tutorial
// https://howtodoinjava.com/mongodb/mongodb-find-documents/#multiple_fields
///////////////////////////////////////////////

@Component
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WebChatRestController {

	@Autowired
	private WebChatService service;

	//
	// Create a message
	//
	@PostMapping("/create")
	public CreateResponseMessage createMessage(@RequestBody CreateRequestMessage req) {

		CreateResponseMessage response = service.createMessage(req);

		return response;
	}

	//
	// Delete all messages
	//
	@PostMapping("/delete")
	public DeleteResponseMessage deleteMessages(@RequestBody DeleteRequestMessage req) {

		DeleteResponseMessage response = service.deleteMessages(req);

		return response;
	}

	//
	// Delete all messages
	//
	@DeleteMapping("/delete")
	public DeleteResponseMessage delMessages(@RequestBody DeleteRequestMessage req) {

		DeleteResponseMessage response = service.deleteMessages(req);

		return response;
	}

	//
	// Update a message
	//
	@PostMapping("update/{id}")
	public UpdateResponseMessage updateMessage(@PathVariable String id, @RequestBody UpdateRequestMessage req) {
		return service.updateMessage(id, req);
	}

	//
	// Update a message
	//
	@PutMapping("update/{id}")
	public UpdateResponseMessage updMessage(@PathVariable String id, @RequestBody UpdateRequestMessage req) {
		return service.updateMessage(id, req);
	}

	//
	// Retrieve all messages belonging to a user
	//
	@GetMapping("/read/all/{user}")
	public ReadResponseMessage fetchUserMessages(@PathVariable String user) {

		ReadResponseMessage response = service.fetchUserMessages(user);

		return response;
	}

	//
	// Retrieve all messages from a user
	//
	@GetMapping("/read/from/{user}")
	public ReadResponseMessage fetchMessagesFromUser(@PathVariable String user) {

		ReadResponseMessage response = service.fetchMessagesFromUser(user);

		return response;
	}

	//
	// Fetch all messages from a user to a user
	//
	@GetMapping("/read/from/{fromUser}/to/{toUser}")
	public ReadResponseMessage fetchMessagesFromUserToUser(@PathVariable String fromUser, @PathVariable String toUser) {

		ReadResponseMessage response = service.fetchMessagesFromUserToUser(fromUser, toUser);

		return response;
	}

	//
	// Fetch all the messages in the table
	//
	@GetMapping("/read")
	public ReadResponseMessage fetchAllMessages() {

		ReadResponseMessage response = service.fetchAllMessages();

		return response;
	}

//	//
//	// Demo to show how to do optional param
//	//
//	@GetMapping(value = { "/opt", "/opt/{param}" })
//	public String optionalDemo(@PathVariable(required = false) String param) {
//
//		return "optional param all messages " + (param != null ? param : "");
//	}
//
//	//
//	// Demo2 to show how to do optional param
//	//
//	// localhost:8080/webchat/textmsg/opt2?param1=hello&param2=goodbye
//	//
//	@GetMapping(value = { "/opt2" })
//	public String optionalDemo2(@RequestParam(required = false, value = "p1") String param1,
//			@RequestParam(required = false, value = "p2") String param2) {
//
//		return "optional param demo: p1: " + param1 + ", p2: " + param2;
//	}

}
