package org.danahall.configuration;

import org.danahall.dao.MessageDAO;
import org.danahall.service.WebChatService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

////////////////////////////////////////////////////////////////
// Resource for Dependency Injection:
// https://www.baeldung.com/constructor-injection-in-spring
////////////////////////////////////////////////////////////////

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.danahall")
public class WebChatConfiguration {
	@Bean
	public MessageDAO messageDao() {
		return new MessageDAO();
	}

	@Bean
	public WebChatService service() {
		return new WebChatService();
	}
}