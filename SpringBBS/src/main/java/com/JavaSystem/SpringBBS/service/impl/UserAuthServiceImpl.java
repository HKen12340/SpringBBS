package com.JavaSystem.SpringBBS.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.JavaSystem.SpringBBS.entity.BBSThread;
import com.JavaSystem.SpringBBS.entity.BBSUser;
import com.JavaSystem.SpringBBS.form.UserForm;
import com.JavaSystem.SpringBBS.repository.BBSMapper;
import com.JavaSystem.SpringBBS.service.UserAuthService;
import com.JavaSystem.SpringBBS.session.UserSession;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserAuthServiceImpl implements UserAuthService {

	@Autowired
	private UserSession userSession;
	
	private final BBSMapper mapper;
	
	//入力データがDBに登録されているか
	public boolean UserNamePassCheck(UserForm form) {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();		
		
		//ユーザ名をもとにユーザ情報検索
		BBSUser user = mapper.SeachUser(form);		
		
		//ユーザが見つからない場合
		if(Objects.isNull(user)) return false;
		
		//入力されたパスワードとDBに登録されているパスワードを比較
		if(bcpe.matches(form.getPassword(), user.getPassword())) {
			userSession.setUsername(form.getUsername());
			userSession.setPassword(form.getPassword());
			userSession.setId(user.getId());
			return true;
		}
		
		return false;
	}
	
	//ユーザー名が重複しているか 重複あり：true 重複なし：false
	public boolean HasOverlappingUserName(String name){
		
		BBSUser SqlResult = mapper.HasOverlappingUsername(name);
		if(Objects.isNull(SqlResult)) return false;			
		
		return true;
	}
	
	//ログイン済みか
	public boolean LoginSessionCheck() {
		
		//セッションにユーザ情報が登録されているか
		if (Objects.isNull(userSession.getUsername()) ||
				Objects.isNull(userSession.getPassword())) {
			return false;
		}
		
		UserForm userForm = new UserForm();
		userForm.setUsername(userSession.getUsername());
		userForm.setPassword(userSession.getPassword());
		
		//セッション情報はDBに登録されているものと合致していないか
		if(!UserNamePassCheck(userForm)) {
			return false;
		}
		
		return true;
	}
	
	//選択したスレッドの作成者か判定する
	public boolean IsIdMatchWithUser(int id) {
		BBSThread thread = mapper.IsIdMatchWithUser(id);
		if(userSession.getId() != thread.getCreate_userid()) {
			return false;
		}
		
		return true;
	}
	
	//ユーザー登録
	public boolean UserDataRegist(UserForm form) {
		
		//パスワードハッシュ化
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String encodeedPassword = bcpe.encode(form.getPassword());
		form.setPassword(encodeedPassword);
		
		//ユーザ名・パスワードの重複を確認する
		if(!Objects.isNull(mapper.SeachUser(form))) {
			return false;
		}
		
		//ユーザ情報登録
		mapper.RegistUser(form);
		return true;
	}
	
	//セッション情報削除
	public void UserNamePassDelete() {
		userSession.deleteUsername();
		userSession.deletePassword();
	}
}
