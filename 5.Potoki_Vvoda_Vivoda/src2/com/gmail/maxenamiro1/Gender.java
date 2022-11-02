package com.gmail.maxenamiro1;

public enum Gender {
	Male("Male student "), Female("Female student ");

	private String getFilePermissions = "";

	private Gender(String getFilePermissions) {
		this.getFilePermissions = getFilePermissions;
	}

	public String getFilePermissions() {
		return getFilePermissions;
	}

	public void setFilePermissions(String getFilePermissions) {
		this.getFilePermissions = getFilePermissions;
	}
}
