package com.sgroup.jqkpro.stageapp.lesson;

import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.actor.LessonItem;
import com.sgroup.jqkpro.base.BaseInfo;
import com.sgroup.jqkpro.screens.MainScreen;
import com.sgroup.jqkpro.stagegame.base.GameStage;
import com.sgroup.jqkpro.stagegame.base.LearnStage;

public class NumberStage extends LearnStage {

	public NumberStage(final MainScreen screen) {
		super(screen);
		nameLessons = new String[]{ "1", "2", "3", "4", "5", "6" };
		lesson = new LessonItem[nameLessons.length];
		for (int i = 0; i < nameLessons.length; i++) {
			creaticongame(i, false);
		}
		addActor(scroll_Lessons);
	}
	@Override
	public void PlayVoice(int i) {
		super.PlayVoice(i);
		BaseInfo.gI().startAudioNumber(i);
	}

}
