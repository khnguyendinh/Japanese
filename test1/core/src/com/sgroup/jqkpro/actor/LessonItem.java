package com.sgroup.jqkpro.actor;

import java.awt.Checkbox;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.controller.ResourceManager;
import com.sgroup.jqkpro.stagegame.base.LearnStage;

public abstract class LessonItem extends Group {
	Image iconSecond, bg_item, icon_Favourite;
	Label ten;
	Image favouriteIC;
	TextureRegionDrawable icon_Favourite_On, icon_Favourite_Off;
	boolean favou = false;
	LearnStage learning;
	public int id = 0;
	public int idLesson = 0;

	public LessonItem(final LearnStage learn, final TextureRegion bg_itemm, TextureRegion icon_secondd, String name, boolean favourite, final int idItem,int idLesson) {
		setSize(400, 80);
		this.id = idItem;
		this.learning = learn;
		favou = favourite;
		favouriteIC = new Image();
		icon_Favourite_On = new TextureRegionDrawable(ResourceManager.shared().atlasJapan.findRegion("icon_favouriteOn"));
		icon_Favourite_Off = new TextureRegionDrawable(ResourceManager.shared().atlasJapan.findRegion("icon_favouriteOff"));
		icon_Favourite = new Image(icon_Favourite_On);

		bg_item = new Image(bg_itemm);
		addActor(bg_item);
		bg_item.setPosition(0, 0);
//		bg_item.addListener(new ClickListener() {
//
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				super.clicked(event, x, y);
////				learning.PlayVoice(idItem);
////				ExtraItem a = new ExtraItem(learn, bg_itemm, learn.strJP[idItem], learn.strPRON[idItem], idItem);
//				ExtraItem a = new ExtraItem(learn, bg_itemm, "strJP", "str PRON", idItem);
//				learning.addNewLessonItem(a, id);
//			}
//
//		});
		iconSecond = new Image();
		if (icon_secondd != null) {
			iconSecond = new Image(icon_secondd);
			iconSecond.setSize(40, 40);
			iconSecond.setPosition(this.getWidth() - iconSecond.getWidth() - 10, this.getHeight() / 2 - iconSecond.getHeight() / 2);

		}
		if (favou == false) {
			icon_Favourite = new Image(icon_Favourite_Off);
		}
		icon_Favourite.setSize(40, 40);
		favouriteIC.setSize(50, 72);
		favouriteIC.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				if (favou == false) {
					favou = true;
					icon_Favourite.setDrawable(icon_Favourite_Off);
				} else {
					favou = false;
					icon_Favourite.setDrawable(icon_Favourite_On);
				}
			}
		});
		addActor(icon_Favourite);
		addActor(favouriteIC);
		addActor(iconSecond);
		icon_Favourite.setPosition(MyGdxGame._WIDGTH - icon_Favourite.getWidth() - 5, favouriteIC.getHeight() / 2 - icon_Favourite.getHeight() / 2);
		favouriteIC.setPosition(MyGdxGame._WIDGTH - favouriteIC.getWidth() -2, this.getHeight() / 2 - favouriteIC.getHeight() / 2);
		ten = new Label("" + name, ResourceManager.shared().lblStyleTahoma24);
		addActor(ten);
		ten.setColor(Color.BLACK);
		ten.setAlignment(Align.left);

		ten.setPosition(10, this.getHeight() / 2 - ten.getHeight() / 2);
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				click();
			}

		});
	}

	public abstract void click();

}
