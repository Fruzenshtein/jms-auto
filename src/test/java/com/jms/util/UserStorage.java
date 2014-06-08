package com.jms.util;

import java.util.ArrayList;
import java.util.List;

import com.jms.model.User;

public class UserStorage {
	
	private static UserStorage storage = null;
	private List<User> userList = new ArrayList<User>(3);
	
	private UserStorage() {
		populateUserList();
	}
	
	public static UserStorage getInstance() {
		if (storage == null)
            storage = new UserStorage();
		return storage;
	}
	
	private void populateUserList() {
		userList.add(new User("alexey.zvolinskiy@door3.com", "potatoes"));
		userList.add(new User("", ""));
		userList.add(new User("alexey.zvolinskiy@door3.com", ""));
		userList.add(new User("", "potatoes"));
		userList.add(new User("invalid", "invalid"));
	}
	
	public User getUser(int index) {
		return userList.get(index);
	}

}
