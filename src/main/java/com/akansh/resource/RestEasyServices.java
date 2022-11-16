package com.akansh.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("")
public class RestEasyServices extends Application{
	
	private Set<Object> singletons=new HashSet<>();
	
	public RestEasyServices() {
		super();
		this.singletons.add(new HelloWorldResource());
		this.singletons.add(new MyResource());
		this.singletons.add(new ProfileResource());
		this.singletons.add(new ApiListingResource());
		this.singletons.add(new SwaggerSerializers());
		System.out.println("all the sigelton added");
		BeanConfig beanConfig = new BeanConfig();
	    beanConfig.setVersion("1.0.2");
	    beanConfig.setSchemes(new String[]{"http"});
	    beanConfig.setHost("localhost:8080");
	    beanConfig.setBasePath("/chatbox");
	    beanConfig.setResourcePackage("com.akansh.resource");
	    beanConfig.setScan(true);
	    System.out.println("Bean is configured :: "+beanConfig);
		CorsFilter  corsFilter=new CorsFilter();
		corsFilter.getAllowedOrigins().add("*");
		corsFilter.setAllowedMethods("OPTIONS,GET,POST,DELETE,PUT,PATCH");
		this.singletons.add(corsFilter);
		this.singletons.add(beanConfig);
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
