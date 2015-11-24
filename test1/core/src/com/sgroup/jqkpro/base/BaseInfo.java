package com.sgroup.jqkpro.base;

import java.text.DecimalFormat;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.MyGdxGame;

public class BaseInfo {

	public static float screenX = 0;
	public static int screenY = 0;
	public int gameID;
	private static BaseInfo instance;
	public boolean isAmThanh = true;

	public Sound media_Hello, media_Good_Morning, media_Good_afternoon, media_Good_evening, media_Goodnight, media_How_are_you;
	public Sound media_1, media_2, media_3, media_4, media_5, media_6;



	public MyGdxGame game;

	public static BaseInfo gI() {
		if (instance == null) {
			instance = new BaseInfo();

		}
		return instance;
	}

	public BaseInfo() {

	}



	public void startAudioGreeting(int idSound) {
		switch (idSound) {
		case 0:
			if (isAmThanh && media_Hello != null) {
				pauseAllClip();
				media_Hello.play();
			}
			break;
		case 1:
			if (isAmThanh && media_Good_Morning != null) {
				pauseAllClip();
				media_Good_Morning.play();
			}
			break;
		case 2:
			if (isAmThanh && media_Good_afternoon != null) {
				pauseAllClip();
				media_Good_afternoon.play();
			}
			break;
		case 3:
			if (isAmThanh && media_Good_evening != null) {
				pauseAllClip();
				media_Good_evening.play();
			}
			break;
		case 4:
			if (isAmThanh && media_Goodnight != null) {
				pauseAllClip();
				media_Goodnight.play();
			}
			break;
		case 5:
			if (isAmThanh && media_How_are_you != null) {
				pauseAllClip();
				media_How_are_you.play();
			}
			break;
		default:
			break;
		}
		
	}
	public void startAudioNumber(int idSound) {
		switch (idSound) {
		case 0:
			if (isAmThanh && media_1 != null) {
				pauseAllClip();
				media_1.play();
			}
			break;
		case 1:
			if (isAmThanh && media_2 != null) {
				pauseAllClip();
				media_2.play();
			}
			break;
		case 2:
			if (isAmThanh && media_3 != null) {
				pauseAllClip();
				media_3.play();
			}
			break;
		case 3:
			if (isAmThanh && media_4 != null) {
				pauseAllClip();
				media_4.play();
			}
			break;
		case 4:
			if (isAmThanh && media_5 != null) {
				pauseAllClip();
				media_5.play();
			}
			break;
		case 5:
			if (isAmThanh && media_6 != null) {
				pauseAllClip();
				media_6.play();
			}
			break;
		default:
			break;
		}
		
	}
	private void pauseAllClip() {
		media_Hello.pause();
		media_Good_Morning.pause();
		media_Good_afternoon.pause();
		media_Good_evening.pause();
		media_Goodnight.pause();
		media_How_are_you.pause();
		
		media_1.pause();
		media_2.pause();
		media_3.pause();
		media_4.pause();
		media_5.pause();
		media_6.pause();
		
	}

}
