package com.bookmanagementsystem.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class BookDetailsConfig {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet, "/ws/*");
	}
	
	@Bean
	public XsdSchema xsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("book-details.xsd"));
	}
	
	@Bean(name="books") // /ws/books.wsdl
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		
		definition.setSchema(xsdSchema);
		definition.setLocationUri("/ws");
		definition.setTargetNamespace("bookmanagementsystem/books");
		definition.setPortTypeName("BookPort");
		
		return definition;
	}
	
}
