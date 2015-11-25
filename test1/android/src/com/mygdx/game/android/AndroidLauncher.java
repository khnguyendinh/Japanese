package com.mygdx.game.android;

import java.util.ArrayList;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.controller.UI;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MyGdxGame(new UI() {
			
			@Override
			public void set_num_notification() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTracking(String tracking) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onShowInAppPurchase() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onShowDatePicker(String d) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onSendSMS(String content, String service) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onRegister(String username, String pass) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPayment(String productID) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onNapTienSDK() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLogoutGmail() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLogoutFacebook() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLoginSDK() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLoginGmail() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLoginFacebook() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLoginDuKhach() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLogin(String username, String password, byte tudangky, String regPhone) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String onHideDatePicker() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void onGetPhoneCSKH() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onCheckNetwork() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onCallPhone(String number) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onBackPress() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void moibanbechoi(ArrayList<String> invitables) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isShowKeyBoard() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void getRegID() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int checkOS() {
				// TODO Auto-generated method stub
				return 0;
			}
		}), config);
	}
}
