package com.sgroup.jqkpro.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.base.BaseInfo;
import com.sgroup.jqkpro.controller.ResourceManager;

public class LoadingScreen extends DefaultScreen {
	private Stage stage;
	Image bkg, logo;
	TextureRegion load1, load2;

	public LoadingScreen(MyGdxGame game) {
		super(game);
		stage = new Stage(viewport);
		BaseInfo.gI().game = game;
		Texture text = new Texture(Gdx.files.internal("data/back-Ground.png"));
		text.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bkg = new Image(text);
		bkg.setSize(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT);
		Texture text_logo = new Texture(Gdx.files.internal("data/logo.png"));
		text_logo.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		logo = new Image(text_logo);
		logo.setOrigin(Align.center);
		logo.setScale(0.5f);
		logo.setPosition(MyGdxGame._WIDGTH/2 - logo.getWidth()/2,MyGdxGame._HEIGHT/2 - logo.getHeight()/2 + 30);

		Texture load1t = new Texture(Gdx.files.internal("data/thanh-keo-2.png"));
		load1t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		load1 = new TextureRegion(load1t);

		Texture load2t = new Texture(Gdx.files.internal("data/thanh-keo.png"));
		load2t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		load2 = new TextureRegion(load2t);

		_w1 = load1.getRegionWidth();
		_w2 = load2.getRegionWidth();
		x1 = logo.getX(Align.center) - _w1 / 2;
		y1 = logo.getY() - 20;
		
		x2= x1+_w1/2-_w2/2;
		y2 = y1+5;
		stage.addActor(bkg);
		stage.addActor(logo);

	}

	float x1, y1;
	float x2, y2;
	public String dl[];


	boolean isDrawable = false;

	@Override
	public void dispose() {

	}

	float _w1, _w2;
	float percent = 0;
	boolean isConnect = false;
	boolean isLoad = false;
	int dem = 0;

	@Override
	protected void update(float delta) {
		super.update(delta);
		stage.getViewport().apply();
		stage.act();
		load2.setRegionWidth((int)(game.manager.getProgress()*_w2));
		percent = Interpolation.linear.apply(percent, game.manager.getProgress(), 0.1f);
		
		if (percent > 0.93)
			percent = 0.99f;
		if (game.manager.update()) {
			
			if (!isLoad) {
				ResourceManager.shared().getResource(game.manager);
				isLoad = true;
			}
				game.mainScreen = new MainScreen(game);
				game.setScreen(game.mainScreen);
		}
	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	protected void draw(float delta) {
		stage.draw();
		stage.getBatch().begin();
		stage.getBatch().draw(load1, MyGdxGame._WIDGTH/2 - load1.getRegionWidth()/2,logo.getY(Align.bottom) - load1.getRegionHeight()/2 + 60);
		stage.getBatch().draw(load2, MyGdxGame._WIDGTH/2 - 216/2,logo.getY(Align.bottom) - load2.getRegionHeight()/2 + 60);
		stage.getBatch().end();
	}

}
