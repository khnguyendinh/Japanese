package com.sgroup.jqkpro.stageapp.lesson;

import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.screens.MainScreen;
import com.sgroup.jqkpro.stagegame.base.GameStage;

public class GeneralStage extends GameStage {


	public GeneralStage(final MainScreen screen) {
		super(screen);
		toolGroup.setX(MyGdxGame._WIDGTH / 2 - toolGroup.getWidth() / 2);
//		this.addActor(toolGroup);
	}

}
