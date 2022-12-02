package com.akansh.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.akansh.model.HelloWorld;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Path("/hello")
@Api("/hello")
@SwaggerDefinition(tags = { @Tag(name = "Hello API's", description = "Rest Endpoints for Hello Service") })
public class HelloWorldResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization Token", required = true, dataType = "string", paramType = "header") })
	public Response helloWorld() {
		HelloWorld helloWorld = new HelloWorld("Hello World");
		return Response.ok(helloWorld).build();
	}
}
