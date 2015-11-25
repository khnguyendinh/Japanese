package com.sgroup.jqkpro.controller;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.sgroup.jqkpro.base.BaseInfo;

public class ResourceManager {

	private static ResourceManager _shared;
	public Skin skinThanbai;
	public TextureAtlas atlasJapan;
	public TextureRegion[] thang_letters;
	public TextureRegion[][] actionRegions;
	public TextureRegion[][] checkRegions;
	public TextureRegion[][] chipRegions;
	
	
	public BitmapFont fonttahoma16;
	public BitmapFont fonttahoma18;
	public BitmapFont fonttahoma20;
	public BitmapFont fonttahoma22;
	public BitmapFont fonttahoma24;
	
	public LabelStyle lblStyleTahoma16;
	public LabelStyle lblStyleTahoma18;
	public LabelStyle lblStyleTahoma20;
	public LabelStyle lblStyleTahoma22;
	public LabelStyle lblStyleTahoma24;
	
	public static ResourceManager shared() {
		if (_shared == null) {
			_shared = new ResourceManager();
		}
		return _shared;
	}

	public ResourceManager() {

	}

	public void load(AssetManager manager) {
		manager.load("main/japan.atlas", TextureAtlas.class);
		BitmapFontParameter parameter = new BitmapFontParameter();
		manager.load("font/fonttahoma/tahoma16.fnt", BitmapFont.class, parameter);
		manager.load("font/fonttahoma/tahoma20.fnt", BitmapFont.class, parameter);
		manager.load("font/fonttahoma/tahoma22.fnt", BitmapFont.class, parameter);
		manager.load("font/fonttahoma/tahoma24.fnt", BitmapFont.class, parameter);
		manager.load("main/japan.json", Skin.class);
		
		manager.load("main/sounds/Greeting/Hello.mp3", Sound.class);
		manager.load("main/sounds/Greeting/Good_Morning.mp3", Sound.class);
		manager.load("main/sounds/Greeting/Good_afternoon.MP3", Sound.class);
		manager.load("main/sounds/Greeting/Good_evening.mp3", Sound.class);
		manager.load("main/sounds/Greeting/Goodnight.mp3", Sound.class);
		manager.load("main/sounds/Greeting/How_are_you.mp3", Sound.class);
		
		manager.load("main/sounds/Test/Taunt001.wav", Sound.class);
		manager.load("main/sounds/Test/Taunt002.wav", Sound.class);
		manager.load("main/sounds/Test/Taunt003.wav", Sound.class);
		manager.load("main/sounds/Test/Taunt004.wav", Sound.class);
		manager.load("main/sounds/Test/Taunt005.wav", Sound.class);
		manager.load("main/sounds/Test/Taunt006.wav", Sound.class);
	}

	public void getResource(AssetManager manager) {
		skinThanbai = manager.get("main/japan.json");
		atlasJapan = manager.get("main/japan.atlas");
		thang_letters = new TextureRegion[6];
		for (int i = 0; i < 6; i++) {
			thang_letters[i] = atlasJapan.findRegion("thang"+i);
		}
		
		fonttahoma16 = manager.get("font/fonttahoma/tahoma16.fnt");
		fonttahoma16.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);


		fonttahoma20 = manager.get("font/fonttahoma/tahoma20.fnt");
		fonttahoma20.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

		fonttahoma22 = manager.get("font/fonttahoma/tahoma22.fnt");
		fonttahoma22.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

		fonttahoma24 = manager.get("font/fonttahoma/tahoma24.fnt");
		fonttahoma24.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		lblStyleTahoma16 = new LabelStyle(fonttahoma16, Color.WHITE);
		lblStyleTahoma18 = new LabelStyle(fonttahoma18, Color.WHITE);
		lblStyleTahoma20 = new LabelStyle(fonttahoma20, Color.WHITE);
		lblStyleTahoma22 = new LabelStyle(fonttahoma22, Color.WHITE);
		lblStyleTahoma24 = new LabelStyle(fonttahoma24, Color.WHITE);
		
		BaseInfo.gI().media_Hello = manager.get("main/sounds/Greeting/Hello.mp3");
		BaseInfo.gI().media_Good_Morning = manager.get("main/sounds/Greeting/Good_Morning.mp3");
		BaseInfo.gI().media_Good_afternoon = manager.get("main/sounds/Greeting/Good_afternoon.MP3");
		BaseInfo.gI().media_Good_evening = manager.get("main/sounds/Greeting/Good_evening.mp3");
		BaseInfo.gI().media_Goodnight = manager.get("main/sounds/Greeting/Goodnight.mp3");
		BaseInfo.gI().media_How_are_you = manager.get("main/sounds/Greeting/How_are_you.mp3");
		
		BaseInfo.gI().media_1 = manager.get("main/sounds/Test/Taunt001.wav");
		BaseInfo.gI().media_2 = manager.get("main/sounds/Test/Taunt002.wav");
		BaseInfo.gI().media_3 = manager.get("main/sounds/Test/Taunt003.wav");
		BaseInfo.gI().media_4 = manager.get("main/sounds/Test/Taunt004.wav");
		BaseInfo.gI().media_5 = manager.get("main/sounds/Test/Taunt005.wav");
		BaseInfo.gI().media_6 = manager.get("main/sounds/Test/Taunt006.wav");
	}
}
