package com.cts.GrizzlyStoreAdminWeb.service;

public interface LoginService {
	public int getUserStatus(String id);
	public String getUserType(String id);
	public String authorization(String userName);
	public boolean authenticate(String userName,String password);

}
