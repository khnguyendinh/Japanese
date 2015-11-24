package com.sgroup.jqkpro.screens;

import javax.smartcardio.Card;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.stageapp.MenuStage;
import com.sgroup.jqkpro.stageapp.lesson.DirectionStage;
import com.sgroup.jqkpro.stageapp.lesson.EatingStage;
import com.sgroup.jqkpro.stageapp.lesson.GeneralStage;
import com.sgroup.jqkpro.stageapp.lesson.GreetingsStage;
import com.sgroup.jqkpro.stageapp.lesson.NumberStage;
import com.sgroup.jqkpro.stageapp.lesson.TransportationStage;
import com.sgroup.jqkpro.stagegame.base.GameStage;

public class MainScreen extends DefaultScreen implements InputProcessor {
	public Stage stageDialog;
	public GameStage currenStage;
	public StateGame backState;
	public StateGame stateGame;

	public MenuStage menu;
	public GreetingsStage greetingStage;
	public GeneralStage generalStage;
	public NumberStage numberStage;
	public DirectionStage directionStage;
	public TransportationStage transportStage;
	public EatingStage eatingStage;

	public enum StateGame {
		LOGIN, MENU, GREET, GENERAL, NUMBER, DIRECTIONS, TRANSPORTATION, EATING
	}

	public MainScreen(MyGdxGame game) {
		super(game);
		menu = new MenuStage(this);
		greetingStage = new GreetingsStage(this);
		generalStage = new GeneralStage(this);
		numberStage = new NumberStage(this);
		directionStage = new DirectionStage(this);
		transportStage = new TransportationStage(this);
		eatingStage = new EatingStage(this);
		
		setStage(StateGame.MENU);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
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
	public void dispose() {

	}

	@Override
	protected void update(float delta) {
		super.update(delta);

	}

	private void setStage(GameStage stage) {
		currenStage = stage;
		currenStage.openStage();
		removeInput();
	}

	public void setStage(StateGame state) {
		backState = stateGame;
		stateGame = state;
		switch (state) {
		case LOGIN:
			break;
		case MENU:
			setStage(menu);
			currenStage.setLessonName(0);
			break;
		case GREET:
			setStage(greetingStage);
			currenStage.setLessonName(1);
			break;
		case GENERAL:
			setStage(generalStage);
			currenStage.setLessonName(2);
			break;
		case NUMBER:
			setStage(numberStage);
			currenStage.setLessonName(3);
			break;
		case DIRECTIONS:
			setStage(directionStage);
			currenStage.setLessonName(4);
			break;
		case TRANSPORTATION:
			setStage(transportStage);
			currenStage.setLessonName(5);
			break;
		case EATING:
			setStage(eatingStage);
			currenStage.setLessonName(6);
			break;
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	protected void draw(float delta) {
		currenStage.getViewport().apply();
		currenStage.act();
		currenStage.draw();
	}

	public void addInput(InputProcessor vl) {
		InputMultiplexer input = new InputMultiplexer(this, currenStage, vl);
		Gdx.input.setInputProcessor(input);
		Gdx.input.setCatchBackKey(true);
	}

	public void removeInput() {
		InputMultiplexer input = new InputMultiplexer(this, currenStage);
		Gdx.input.setInputProcessor(input);
		Gdx.input.setCatchBackKey(true);
	}
}
