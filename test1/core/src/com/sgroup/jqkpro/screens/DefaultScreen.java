package com.sgroup.jqkpro.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

public abstract class DefaultScreen implements Screen {

	public MyGdxGame game;
	public Viewport viewport, viewport2;
	public OrthographicCamera camera;
	public Image image;

	public DefaultScreen(MyGdxGame game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, MyGdxGame._WIDGTH, MyGdxGame._HEIGHT);
		camera.position.set(MyGdxGame._WIDGTH / 2, MyGdxGame._HEIGHT / 2, 0);
		camera.update();
		// viewport = new ExtendViewport(MainGame._WIDGTH,
		// MainGame._HEIGHT,1280,540);
		// viewport = new StretchViewport(MainGame._WIDGTH, MainGame._HEIGHT);
		// viewport = new FillViewport(MainGame._WIDGTH,
		// MainGame._HEIGHT,camera);
		viewport = new StretchViewport(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT);
		viewport2 = new FitViewport(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT);
		// if(((float)Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight())==1.5f){
		// viewport= new FitViewport(MainGame._WIDGTH, MainGame._HEIGHT);
		// }else{
		// viewport = new FillViewport(MainGame._WIDGTH,
		// MainGame._HEIGHT,camera);
		// }
	}

	@Override
	public void resize(int width, int height) {
		camera.update();
		viewport.setWorldSize(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT);
		viewport.update(width, height, true);
		viewport2.setWorldSize(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT);
		viewport2.update(width, height, false);
	}

	@Override
	public void render(float delta) {
		try {
			Gdx.graphics.getGL30().glClearColor(0.034f, 0.034f, 0.034f, 1);
			Gdx.graphics.getGL30().glClear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT);
		} catch (Exception e) {
			try {
				Gdx.gl.glClearColor(0.034f, 0.034f, 0.034f, 1);
				Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			} catch (Exception e2) {
			}
		}
		update(delta);
		draw(delta);
	}

	protected void update(float delta) {
	}

	protected abstract void draw(float delta);
}
