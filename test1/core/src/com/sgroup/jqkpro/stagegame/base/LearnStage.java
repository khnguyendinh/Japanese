package com.sgroup.jqkpro.stagegame.base;

import java.awt.Checkbox;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.actor.ExtraItem;
import com.sgroup.jqkpro.actor.LessonItem;
import com.sgroup.jqkpro.base.BaseInfo;
import com.sgroup.jqkpro.controller.ResourceManager;
import com.sgroup.jqkpro.screens.MainScreen;

public abstract class LearnStage extends GameStage {

	Table table;
	ScrollPane pane;
	protected LessonItem lesson[];
	public Group scroll_Lessons;
	public String[] nameLessons ;
	TextureRegion bg_tableLesson,bg_Extra;
	private static LearnStage instance;
	public int currentLesson =0;
	public String[] strJP;
	public String[] strPRON;
	public LearnStage(MainScreen screen) {
		super(screen);
		bg_tableLesson = new TextureRegion(ResourceManager.shared().atlasJapan.findRegion("bg_iconLesson"));
		
		scroll_Lessons = new Group();
		table = new Table();

		pane = new ScrollPane(table, ResourceManager.shared().skinThanbai, "myscroll");
		pane.setSize(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT - toolGroup.getHeight());
		pane.setScrollingDisabled(true, false);
		scroll_Lessons.addActor(pane);
		scroll_Lessons.setPosition(0, 0);
		scroll_Lessons.setSize(MyGdxGame._WIDGTH, MyGdxGame._HEIGHT - toolGroup.getHeight());
		
		
	}
	public void creaticongame(final int i,boolean icon_favour) {
		final ExtraItem a = new ExtraItem(this, "strJP", "str PRON", i);
		lesson[i] = new LessonItem(this, bg_tableLesson, null, nameLessons[i],icon_favour,i,currentLesson) {
			@Override
			public void click() {
				PlayVoice(i);
				table.row();
				table.addActorAt(i, a);
				table.row();
			}
		};
		
		table.add(lesson[i]);
		table.row();
	}
	public void addNewLessonItem(ExtraItem newExtra,int i) {
		table.addActorAt(i, newExtra);

	}
	public void PlayVoice(int i) {
		
	}


}

