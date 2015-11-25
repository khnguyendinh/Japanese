package com.sgroup.jqkpro.stagegame.base;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.controller.ResourceManager;
import com.sgroup.jqkpro.group.ToolGroup;
import com.sgroup.jqkpro.screens.MainScreen;

public class GameStage extends Stage {
	public MainScreen screen;
	public ToolGroup toolGroup;
	private Image background;
	public GameStage(MainScreen screen) {
		super(screen.viewport);
		this.screen = screen;
		if (ResourceManager.shared().atlasJapan != null) {
			background = new Image(ResourceManager.shared().atlasJapan.findRegion("back-Ground"));
			this.addActor(background);
		}
		toolGroup= new ToolGroup(screen);
		this.addActor(toolGroup);
		toolGroup.setPosition(0, MyGdxGame._HEIGHT-toolGroup.getHeight());
	}
	public GameStage(MainScreen screen , Viewport viewport) {
		super(viewport);

		this.screen = screen;
	}
	public void openStage() {
		this.addAction(Actions.alpha(0));
		this.addAction(Actions.alpha(1, 0.5f));
	}
	public void setLessonName(int id) {
		toolGroup.setLessonNAME(id);
	}
	

}
