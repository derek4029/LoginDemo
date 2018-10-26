package com.derek.logindemo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
	// 用户名编辑
	private EditText mAccount; 
	// 密码编辑
	private EditText mPwd; 
	// 注册按钮 
	private Button mRegisterButton; 
	// 登录按钮
	private Button mLoginButton; 
	private CheckBox mRememberCheck;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		// 通过id找到相应的控件
		mAccount = (EditText) findViewById(R.id.login_edit_username);
		mPwd = (EditText) findViewById(R.id.login_edit_pwd);
		mRegisterButton = (Button) findViewById(R.id.login_btn_register);
		mLoginButton = (Button) findViewById(R.id.login_btn_login);
		// 采用OnClickListener方法设置不同按钮按下之后的监听事件
		mRegisterButton.setOnClickListener(this); 
		mLoginButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		//登录界面的注册按钮
        case R.id.login_btn_register:                            
        	//切换Login Activity至Main Activity
            Intent intent_Login_to_Register = new Intent(Login.this,Register.class) ;    
            startActivity(intent_Login_to_Register);
            finish();
            break;
          //登录界面的登录按钮
        case R.id.login_btn_login:                              
            login();
            break;	
	}
}

	public void login() { // 登录按钮监听事件
		// 获取当前输入的用户名和密码信息
		String userName = mAccount.getText().toString().trim(); 
		String userPwd = mPwd.getText().toString().trim();
		if (userName.equals("admin") && userPwd.equals("admin")) {
			// 切换Login Activity至MainActivity
			Intent intent = new Intent(Login.this, MainActivity.class); 
			
			//传递userName给MainActivity
			intent.putExtra("username", userName);
			
			startActivity(intent);
			finish();
			// 登录成功提示
			Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
		} else {
			// 登录失败提示
			Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show(); 
		}
	}
}