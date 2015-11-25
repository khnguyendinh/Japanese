package com.sgroup.jqkpro.controller;

import java.util.ArrayList;

public interface UI {

	public boolean onCheckNetwork();

	public void onSendSMS(String content, String service);

	public void onCallPhone(String number);

	public void onShowInAppPurchase();

	public void onPayment(String productID);

	public void onShowDatePicker(String d);

	public String onHideDatePicker();

	public boolean isShowKeyBoard();

	public void onLogin(String username, String password, byte tudangky,
			String regPhone);

	public void onLoginFacebook();

	public void onLogoutFacebook();

	public void onLoginGmail();

	public void onLogoutGmail();

	public void onLoginDuKhach();

	public int checkOS();

	public void onRegister(String username, String pass);

	public void onBackPress();

	public void getRegID();

	public void set_num_notification();

	public void setTracking(String tracking);

	public void moibanbechoi(ArrayList<String> invitables);

	public void onGetPhoneCSKH();
	
	public void onLoginSDK();
	public void onNapTienSDK();
	
	// public void getInfoFriendFB();
	// public ArrayList<FriendData> getFaceBookFriend(boolean showInvite);
	// public void inviteFriend(ArrayList<String> inviables);
	// public boolean isLoginFacebook();
}
