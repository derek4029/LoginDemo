package com.derek.logindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity implements OnClickListener {
	// 用户名编辑
	private EditText mAccount; 
	// 密码编辑
	private EditText mPwd; 
	// 密码编辑
	private EditText mPwdCheck; 
	// 确定按钮
	private Button mSureButton;
	// 取消按钮
	private Button mCancelButton; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		mAccount = (EditText) findViewById(R.id.register_edit_name);
		mPwd = (EditText) findViewById(R.id.register_edit_pwd);
		mPwdCheck = (EditText) findViewById(R.id.register_edit_pwd_confirm);

		mSureButton = (Button) findViewById(R.id.register_btn_ok);
		mCancelButton = (Button) findViewById(R.id.register_btn_cancel);
		mSureButton.setOnClickListener(this); 
		mCancelButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		// 确认按钮的监听事件
		case R.id.register_btn_ok: 
			register_check();
			break;
			// 取消按钮的监听事件,由注册界面返回登录界面
		case R.id.register_btn_cancel: 
			// 切换MainActivity至Login Activity
			Intent intent_Register_to_Login = new Intent(Register.this, Login.class); 
			startActivity(intent_Register_to_Login);
			finish();
			break;
		}
	}

	public void register_check() {
		String userName = mAccount.getText().toString().trim();
		String userPwd = mPwd.getText().toString().trim();
		String userPwdCheck = mPwdCheck.getText().toString().trim();
		// 两次密码输入不一样
		if (userPwd.equals(userPwdCheck) == false) { 
			Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
			return;
		} else {
			Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
			// 切换Register Activity至Login Activity
			Intent intent_Register_to_Login = new Intent(Register.this, Login.class); 
			startActivity(intent_Register_to_Login);
			finish();
		}
	}
}
