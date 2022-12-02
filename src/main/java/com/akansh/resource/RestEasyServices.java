package com.akansh.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("")
public class RestEasyServices extends Application {

	private Set<Class<?>> classes = new HashSet<>();

	public RestEasyServices() {
		super();
		this.classes.add(HelloWorldResource.class);
		this.classes.add(MyResource.class);
		this.classes.add(ProfileResource.class);
		this.classes.add(ApiListingResource.class);
		this.classes.add(SwaggerSerializers.class);
		System.out.println("All Resources added");
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/chatbox");
		beanConfig.setResourcePackage("com.akansh.resource");
		beanConfig.setPrettyPrint(true);
		beanConfig.setScan(true);
		System.out.println("Bean is configured :: " + beanConfig);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
