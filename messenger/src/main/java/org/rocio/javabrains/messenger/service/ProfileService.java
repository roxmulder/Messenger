package org.rocio.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rocio.javabrains.messenger.database.DatabaseClass;
import org.rocio.javabrains.messenger.model.Profile;

public class ProfileService {

	private static Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("rocio", new Profile(1L, "rocio", "Rocio", "McKay"));
		profiles.put("john", new Profile(2L, "john", "John", "Sheppard"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}

}
