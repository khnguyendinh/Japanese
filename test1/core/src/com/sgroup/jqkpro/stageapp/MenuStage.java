package com.sgroup.jqkpro.stageapp;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.controller.ResourceManager;
import com.sgroup.jqkpro.screens.MainScreen;
import com.sgroup.jqkpro.screens.MainScreen.StateGame;
import com.sgroup.jqkpro.stagegame.base.GameStage;

public class MenuStage extends GameStage {

	private Image background, backGround_table_icon;
	TextureRegion bg_tableLesson, icon_infor, icon_Pro;
	/**
	 * add table icon game
	 */
	public MyGdxGame game;
	Table table;
	ScrollPane pane;
	IconLesson iconLesson[];
	public Group scroll_Lessons;
	public String[] nameLessons = { "Greetings", "General Conversation", "Number", "Directions & Places", "Transportation", "Eating Out" };
	public String[] nameToolGroup = { "Japanese" ,"Greetings", "General Conversation", "Number", "Directions & Places", "Transportation", "Eating Out" };
	String[] icon_Lesson = { "greeting_icon", "general_icon", "number_icon", "direction_icon", "transportation_icon", "eat_icon" };
	int[] icon_Lesson_second = { 0, 1, 2, 1, 0, 1 };
	boolean isLoad = false;

	public MenuStage(final MainScreen screen) {
		super(screen);
		if (ResourceManager.shared().atlasJapan != null) {
			background = new Image(ResourceManager.shared().atlasJapan.findRegion("back-Ground"));
			bg_tableLesson = new TextureRegion(ResourceManager.shared().atlasJapan.findRegion("bg_iconLesson"));
			icon_infor = new TextureRegion(ResourceManager.shared().atlasJapan.findRegion("icon_INFOR"));
			icon_Pro = new TextureRegion(ResourceManager.shared().atlasJapan.findRegion("icon_PRO"));
			// this.addActor(background);
		}
		toolGroup.setX(MyGdxGame._WIDGTH / 2 - toolGroup.getWidth() / 2);

		scroll_Lessons = new Group();
		table = new Table();
		pane = new ScrollPane(table, ResourceManager.shared().skinThanbai, "myscroll");
		pane.setSize(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT - toolGroup.getHeight());
		pane.setScrollingDisabled(true, false);
		scroll_Lessons.addActor(pane);
		scroll_Lessons.setPosition(0, 0);
		scroll_Lessons.setSize(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT - toolGroup.getHeight());
		iconLesson = new IconLesson[nameLessons.length];
		for (int i = 0; i < nameLessons.length; i++) {
			creaticongame(i, icon_Lesson_second[i]);
		}
		addActor(scroll_Lessons);
	}

	private void creaticongame(final int i, int k) {
		switch (k) {
		case 0:
			iconLesson[i] = new IconLesson(ResourceManager.shared().atlasJapan.findRegion("" + icon_Lesson[i]), bg_tableLesson, null, nameLessons[i]) {
				@Override
				public void click() {
					SelectLesson(i);
				}
			};
			break;
		case 1:
			iconLesson[i] = new IconLesson(ResourceManager.shared().atlasJapan.findRegion("" + icon_Lesson[i]), bg_tableLesson, icon_infor, nameLessons[i]) {
				@Override
				public void click() {
					SelectLesson(i);
				}
			};
			break;
		case 2:
			iconLesson[i] = new IconLesson(ResourceManager.shared().atlasJapan.findRegion("" + icon_Lesson[i]), bg_tableLesson, icon_Pro, nameLessons[i]) {
				@Override
				public void click() {
					SelectLesson(i);
				}
			};
			break;
		default:
			break;
		}

		table.add(iconLesson[i]);
		table.row();

	}

	private void SelectLesson(int i) {
		switch (i) {
		case 0:
			screen.setStage(StateGame.GREET);
			break;
		case 1:
			screen.setStage(StateGame.GENERAL);
			break;
		case 2:
			screen.setStage(StateGame.NUMBER);
			break;
		case 3:
			screen.setStage(StateGame.DIRECTIONS);
			break;
		case 4:
			screen.setStage(StateGame.TRANSPORTATION);
			break;
		case 5:
			screen.setStage(StateGame.EATING);
			break;
		default:
			break;
		}
	}

}

abstract class IconLesson extends Group {
	Image iconFirst, iconSecond, bg_item;
	Label ten;

	public IconLesson(TextureRegion region1, TextureRegion bg_itemm, TextureRegion icon_secondd, String name) {
		setSize(400, 80);
		iconFirst = new Image(region1);
		iconFirst.setOrigin(Align.center);
		if (bg_itemm != null) {
			bg_item = new Image(bg_itemm);
			addActor(bg_item);
			bg_item.setPosition(0, 0);
		}
		iconSecond = new Image();
		if (icon_secondd != null) {
			iconSecond = new Image(icon_secondd);
			iconFirst.setOrigin(Align.center);
			iconSecond.setSize(40, 40);
			iconSecond.setPosition(this.getWidth() - iconSecond.getWidth() - 10, this.getHeight() / 2 - iconSecond.getHeight() / 2);

		}
		iconFirst.setOrigin(Align.center);
		addActor(iconFirst);
		addActor(iconSecond);
		ten = new Label("" + name, ResourceManager.shared().lblStyleTahoma24);
		addActor(ten);
		addActor(iconFirst);
		ten.setWidth(iconFirst.getWidth() + 70);
		ten.setColor(Color.BLACK);
		ten.setAlignment(Align.left);
		iconFirst.setSize(60, 60);
		iconFirst.setPosition(15, this.getHeight() / 2 - iconFirst.getHeight() / 2);

		ten.setPosition(iconFirst.getX() + iconFirst.getWidth() + 10, this.getHeight() / 2 - ten.getHeight() / 2);
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				click();
			}

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				iconFirst.setScale(1.1f);
				return super.touchDown(event, x, y, pointer, button);
			}

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				iconFirst.setScale(1f);
			}
		});
	}

	public abstract void click();

}
