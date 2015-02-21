package com.tribal.userconnection;

public class User {

	private String name;
	private int id;
	
	public User(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
