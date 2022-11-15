package com.akansh.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class RestEasyServices extends Application{
	
	private Set<Object> singletons=new HashSet<>();
	
	public RestEasyServices() {
		super();
		this.singletons.add(new HelloWorldResource());
		this.singletons.add(new MyResource());
		this.singletons.add(new ProfileResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
