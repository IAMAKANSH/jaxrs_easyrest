package com.akansh.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.akansh.model.Profile;
import com.akansh.service.ProfileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Path("/profiles")
@Api("/profiles")
@SwaggerDefinition(tags = { @Tag(name = "Profile API's", description = "Rest Endpoints for Profile Service") })
public class ProfileResource {

	ProfileService profileService = new ProfileService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}

	@GET
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfileByUserName(@PathParam(value = "userName") String userName) {
		return profileService.getProfile(userName);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(Profile profile) {
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile deleteProfile(@PathParam(value = "userName") String userName) {
		return profileService.removeMessage(userName);
	}
}
