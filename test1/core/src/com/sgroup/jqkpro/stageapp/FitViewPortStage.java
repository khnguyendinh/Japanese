package com.sgroup.jqkpro.stageapp;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sgroup.jqkpro.screens.MainScreen;
import com.sgroup.jqkpro.stagegame.base.GameStage;

public class FitViewPortStage extends GameStage {
	Table table;
	ScrollPane pane;
	String[] tengame = { "TIẾN LÊN", "BA CÂY", "LIÊNG", "MẬU BINH", "XÓC ĐĨA", "PHỎM", "POKER", "XÌ TỐ", "SÂM", "CHẮN" };
	String[] ten_anh = { "tienlen_icon", "bacay_icon", "lieng_icon", "maubinh_icon", "xocdia_icon", "phom_icon", "poker_icon", "xito_icon", "sam_icon", "chan_icon" };

	public FitViewPortStage(MainScreen screen, Viewport viewport) {
		super(screen, viewport);

	}

	private void creaticongame(final int i) {
	}
}
