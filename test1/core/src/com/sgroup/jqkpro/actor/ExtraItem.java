package com.sgroup.jqkpro.actor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sgroup.jqkpro.controller.ResourceManager;
import com.sgroup.jqkpro.stagegame.base.LearnStage;

public class ExtraItem extends Group{
	Image iconVolume, bg_item;
	Label txt_JP,txt_PRON;
	Image VolumeIC;
	TextureRegionDrawable icon_VolumeTR;
	LearnStage learning;
	public int id = 0;
	public ExtraItem(LearnStage learn, String txt_JP,String txt_Pron, final int id) {
		setSize(400, 80);
		this.id = id;
		this.txt_JP = new Label(txt_JP, ResourceManager.shared().lblStyleTahoma16);
		this.txt_PRON = new Label(txt_Pron, ResourceManager.shared().lblStyleTahoma16);
		this.txt_JP.setPosition(20, 60);
		this.txt_PRON.setPosition(20, 40);
		this.learning = learn;
		iconVolume = new Image();
		icon_VolumeTR = new TextureRegionDrawable(ResourceManager.shared().atlasJapan.findRegion("icon_Volume"));

		bg_item = new Image(ResourceManager.shared().atlasJapan.findRegion("bg_iconExtra"));
		addActor(bg_item);
		bg_item.setPosition(0, 0);
		bg_item.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				learning.PlayVoice(id);
			}

		});
		icon_VolumeTR = new TextureRegionDrawable(ResourceManager.shared().atlasJapan.findRegion("bg_iconExtra"));
		iconVolume = new Image(icon_VolumeTR);
		iconVolume.setSize(60, 60);
		addActor(iconVolume);
		addActor(this.txt_JP);
		addActor(this.txt_PRON);

	}
}
