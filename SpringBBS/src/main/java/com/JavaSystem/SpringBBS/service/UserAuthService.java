package com.JavaSystem.SpringBBS.service;

import com.JavaSystem.SpringBBS.form.UserForm;

public interface UserAuthService {
	public boolean UserNamePassCheck(UserForm f);
	public boolean LoginSessionCheck();
	public boolean UserDataRegist(UserForm f);
	public void UserNamePassDelete();
	public boolean IsIdMatchWithUser(int id);
}
