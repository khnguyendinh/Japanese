package com.sgroup.jqkpro.stageapp.lesson;

import java.awt.Checkbox;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.sgroup.jqkpro.actor.LessonItem;
import com.sgroup.jqkpro.base.BaseInfo;
import com.sgroup.jqkpro.screens.MainScreen;
import com.sgroup.jqkpro.stagegame.base.LearnStage;

public class GreetingsStage extends LearnStage {
	int id ;
	public GreetingsStage(final MainScreen screen) {
		super(screen);
		id = 0;
		nameLessons = new String[]{ "Hello", "Good Morning", "Good  afternoon", "Good evening", "Goodnight", "How are you" };
		strJP = new String[]{ "Hello strJP", "Good Morning strJP", "Good  afternoon strJP", "Good evening strJP", "Goodnight strJP", "How are you strJP" };
		strJP = new String[]{ "Hello strPRON", "Good Morning strPRON", "Good  afternoon strPRON", "Good evening strPRON", "Goodnight strPRON", "How are you strPRON" };
		lesson = new LessonItem[nameLessons.length];
		for (int i = 0; i < nameLessons.length; i++) {
			creaticongame(i, false);
			creaticongame(i, false);
			creaticongame(i, false);
		}
		addActor(scroll_Lessons);
	}
	@Override
	public void creaticongame(final int i, boolean icon_favour) {
		// TODO Auto-generated method stub
		super.creaticongame(i, icon_favour);
	}
	@Override
	public void PlayVoice(int i) {
		super.PlayVoice(id);
		BaseInfo.gI().startAudioGreeting(i);
		
	}
}
