package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sgroup.jqkpro.controller.ResourceManager;
import com.sgroup.jqkpro.controller.UI;
import com.sgroup.jqkpro.screens.LoadingScreen;
import com.sgroup.jqkpro.screens.MainScreen;

public class MyGdxGame extends Game {
	public static final int _WIDGTH = 400;
	public static final int _HEIGHT = 600;
	public static String regID;

	public AssetManager manager;
	public UI ui;
	public int gameID = -1;
	public MainScreen mainScreen;


	/**
	 * updateType = 1 bat buoc nang cap, 0, ko bat buoc nang cap
	 */
	public byte updateType = -1;
	public String linkUpdate;
	public String mess;

	public static boolean isPan = false;
	public static boolean isShowKeyboard=false;

	public MyGdxGame(UI ui) {
		this.ui = ui;
	}

	@Override
	public void create() {
		manager = new AssetManager();
		ResourceManager.shared().load(manager);
		this.setScreen(new LoadingScreen(this));
	}

	public void removeActor(final Actor actor) {
		if (actor != null) {
			Gdx.app.postRunnable(new Runnable() {

				@Override
				public void run() {
					actor.remove();
				}
			});

		}
	}
}
