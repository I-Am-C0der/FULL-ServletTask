package com.student.register;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class Helper {
	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	public static boolean addStudent(String name, int age) {
		boolean invalidDetails = false;

		invalidDetails = checkCharacter(name);
		if (!invalidDetails) {
			Entity entity = new Entity("Student");
			entity.setProperty("Name", name);
			entity.setProperty("Age", age);
			datastore.put(entity);
		}

		return invalidDetails;

	}

	public static boolean signUp(String name, String username, String email, String password) {
		boolean invalidName = false;

		invalidName = checkCharacter(name);
		if (!invalidName) {
			Entity entity = new Entity("Users");
			entity.setProperty("Name", name);
			entity.setProperty("Username", username);
			entity.setProperty("Email", email);
			entity.setProperty("Password", password);
			datastore.put(entity);
		}

		return invalidName;

	}

	public static boolean checkCharacter(String name) {
		boolean invalidDetails = false;
		boolean checkAllLettersAreCharacter = name.chars().allMatch(Character::isLetter);
		if (!checkAllLettersAreCharacter) {
			invalidDetails = true;
		}
		return invalidDetails;
	}

}
