package com.akansh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.akansh.database.DatabaseClass;
import com.akansh.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		if (profiles.get(profileName) != null) {
			return profiles.get(profileName);
		}
		return null;
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getUsername(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0) {
			return null;
		}
		profiles.put(profile.getUsername(), profile);
		return profile;
	}

	public Profile removeMessage(String userName) {
		if (profiles.get(userName) != null) {
			return profiles.remove(userName);
		}
		return null;

	}

}
