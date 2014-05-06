package edu.neumont.csc380.AuthServer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userInfo")
public class AuthPayload {
	String id;
	String token;
	String userName;
	String password;
	
	public AuthPayload () { }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
