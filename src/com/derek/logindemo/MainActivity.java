package com.derek.logindemo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	private Button mReturnButton;
	private TextView mUserName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mReturnButton = (Button)findViewById(R.id.main_btn_returnback);
		mReturnButton.setOnClickListener(this);
		
		mUserName = (TextView)findViewById(R.id.main_text_username);
		
		Intent intent = getIntent();  
		String userName = intent.getStringExtra("username");
		mUserName.setText(userName);
	}
    public void back_to_login() {
        Intent intent = new Intent(MainActivity.this,Login.class) ;
        startActivity(intent);
        finish();

    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.main_btn_returnback: 
			back_to_login();
			break;
		}
	}
}
