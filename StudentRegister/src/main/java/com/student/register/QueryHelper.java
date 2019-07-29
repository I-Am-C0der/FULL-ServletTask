package com.student.register;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class QueryHelper {
	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	static Query query = new Query("Student");
	static PreparedQuery preparedQuery = datastore.prepare(query);
	static Query queryLogin = new Query("Users");
	static PreparedQuery preparedQueryLogin = datastore.prepare(queryLogin);

	public static boolean updateQueryOperation(long updateId, String updateAge, String updateName) {
		boolean invalidId = false;

		int check = 0;
		for (Entity entity : preparedQuery.asIterable()) {
			long getId = entity.getKey().getId();
			if (updateId == getId) {
				check = 1;
				if (!updateName.equals(""))
					entity.setProperty("Name", updateName);
				if (!updateAge.equals("")) {
					int updateAgeNumber = Integer.parseInt(updateAge);
					entity.setProperty("Age", updateAgeNumber);
				}
				datastore.put(entity);
				break;
			}
		}
		if (check == 0)
			invalidId = true;
		return invalidId;
	}

	public static void removeByIdQuery(long removeId) {
		for (Entity entity : preparedQuery.asIterable()) {
			long getId = entity.getKey().getId();
			if (removeId == getId) {
				datastore.delete(entity.getKey());
				break;
			}
		}

	}

	public static boolean removeAllQuery() {
		boolean removeAll = true;
		for (Entity entity : preparedQuery.asIterable()) {
			datastore.delete(entity.getKey());
		}
		return removeAll;
	}

	public static boolean checkUsername(String username) {
		boolean usernamePresent = false;
		for (Entity entity : preparedQueryLogin.asIterable()) {
			String getUsername = (String) entity.getProperty("Username");
			if (getUsername.equals(username)) {
				usernamePresent = true;
				break;
			}
		}
		return usernamePresent;
	}
}
