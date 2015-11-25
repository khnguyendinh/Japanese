package com.sgroup.jqkpro.group;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.actor.MyButton;
import com.sgroup.jqkpro.controller.ResourceManager;
import com.sgroup.jqkpro.screens.MainScreen;
import com.sgroup.jqkpro.stageapp.MenuStage;

public class ToolGroup extends Group {
	Image bg1;
	private MyButton btnSearch, btnFavourite, btnSetting;
	MainScreen screen;
	public Label lbl_App,lbl_app_On;
	Image btn_back ;

	public ToolGroup(final MainScreen screen) {
		this.screen = screen;
		bg1 = new Image(ResourceManager.shared().atlasJapan.findRegion("bg_toolgroup"));
		btn_back = new Image(ResourceManager.shared().atlasJapan.findRegion("button_back"));
		setSize(MyGdxGame._WIDGTH, bg1.getHeight());
		lbl_App = new Label("", ResourceManager.shared().lblStyleTahoma16);
		lbl_app_On = new Label("", ResourceManager.shared().lblStyleTahoma16);
		lbl_App.setText("Japanese");
		lbl_App.setSize(200,50);
		btn_back.setSize(60, 60);
		btn_back.setTouchable(Touchable.disabled);
		lbl_app_On.setSize(150,60);
		lbl_App.setWrap(true);
		lbl_App.setColor(Color.WHITE);
		lbl_App.setAlignment(Align.left);
		lbl_App.setPosition(35, getHeight()/2 - lbl_App.getHeight()/2);
		if(screen.currenStage == screen.menu){
			lbl_App.setPosition(10, getHeight()/2 - lbl_App.getHeight()/2);
			btn_back.setVisible(false);
			lbl_app_On.setTouchable(Touchable.disabled);
		}else {
			lbl_App.setTouchable(Touchable.enabled);
			lbl_app_On.addListener(new ClickListener(){
				@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					System.out.println("sssss");
					screen.setStage(screen.backState);
				}
			});
		}
		
		lbl_app_On.setPosition(0, getHeight()/2 - lbl_App.getHeight()/2);
		btnSetting = new MyButton(ResourceManager.shared().atlasJapan.findRegion("cai-dat")) {

			@Override
			public void precessClicked() {
			}
		};
		btnSearch = new MyButton(ResourceManager.shared().atlasJapan.findRegion("Button_Search")) {

			@Override
			public void precessClicked() {
			}
		};
		btnFavourite = new MyButton(ResourceManager.shared().atlasJapan.findRegion("Button_Favourite")) {

			@Override
			public void precessClicked() {
			}
		};

		btnSetting.setPosition(getWidth() - btnSetting.getWidth() - 20, getHeight() / 2 - btnSetting.getHeight() / 2);
		btnFavourite.setPosition(btnSetting.getX() - btnFavourite.getWidth()  - 15, btnSetting.getY() - 5);
		btnSearch.setPosition(btnFavourite.getX() - btnSearch.getWidth()  - 15, btnSetting.getY() - 5);
		bg1.setPosition(0,0);
		btn_back.setPosition(-10, getHeight()/2 - btn_back.getHeight()/2);

		addActor(bg1);
		addActor(btnSetting);
		addActor(btnFavourite);
		addActor(btnSearch);
		addActor(lbl_App);
		addActor(btn_back);
		addActor(lbl_app_On);

	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}
	public void setLessonNAME(int id) {
		lbl_App.setText(screen.menu.nameToolGroup[id]);
	}
}
