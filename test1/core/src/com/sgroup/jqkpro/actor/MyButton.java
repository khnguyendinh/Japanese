package com.sgroup.jqkpro.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.MyGdxGame;
import com.sgroup.jqkpro.base.BaseInfo;
import com.sgroup.jqkpro.controller.ResourceManager;

public abstract class MyButton extends Group {

	MyButtonListener clickedListener;
	private Image image, img_disable;
	private Label label;
	private String name;// ten button
	private Color fontColor;

	public MyButton(TextureRegion region) {
		name = "";
		clickedListener = new MyButtonListener();
		{
			image = new Image(region);
			image.setOrigin(image.getWidth() / 2, image.getWidth() / 2);
		}
		{
			this.setSize(image.getWidth(), image.getHeight());
			this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
		}
		{
			this.addActor(image);
		}
		image.addListener(clickedListener);
	}

	public MyButton(TextureRegion region, String name) {
		this.name = name;
		clickedListener = new MyButtonListener();
		{
			image = new Image(region);
			image.setOrigin(image.getWidth() / 2, image.getWidth() / 2);
		}
		{
			this.setSize(image.getWidth(), image.getHeight());
			this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
		}
		{
			this.addActor(image);
		}
		image.addListener(clickedListener);
	}

	public void setText(final String text) {
		Gdx.app.postRunnable(new Runnable() {

			@Override
			public void run() {
				label.setText(text);
			}
		});
	}

	public String getText() {
		return label.getText().toString();
	}

	public MyButton(String text, TextureRegion region, BitmapFont font, Color fontColor) {
		name = "";
		clickedListener = new MyButtonListener();
		{
			image = new Image(region);
			image.setOrigin(image.getWidth() / 2, image.getWidth() / 2);
		}
		{
			this.setSize(image.getWidth(), image.getHeight());
			this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
		}

		{
			LabelStyle style = new LabelStyle(font, fontColor);
			this.fontColor = fontColor;
			label = new Label(text, style);
			label.setSize(this.getWidth(), this.getHeight());
			label.setAlignment(Align.center);
			label.setWrap(true);
			label.setTouchable(Touchable.disabled);
			label.setY(label.getY() + 1);

		}

		{
			this.addActor(image);
			if (label != null) {
				this.addActor(label);
			}
		}
		this.addListener(clickedListener);
	}

	public MyButton(String text, TextureRegion region, BitmapFont font, Color fontColor, int h) {
		name = "";
		clickedListener = new MyButtonListener();
		{
			image = new Image(region);
			image.setOrigin(image.getWidth() / 2, image.getWidth() / 2);
		}
		{
			this.setSize(image.getWidth(), image.getHeight());
			this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
		}

		{
			LabelStyle style = new LabelStyle(font, fontColor);
			this.fontColor = fontColor;
			label = new Label(text, style);
			label.setSize(image.getWidth(), image.getHeight() + h);
			label.setAlignment(Align.center);
			label.setWrap(true);
			label.setTouchable(Touchable.disabled);
			label.setY(label.getY());

		}

		{
			this.addActor(image);
			if (label != null) {
				this.addActor(label);
			}
		}
		this.addListener(clickedListener);
	}

	public MyButton(String text, TextureRegion region, int typefont) {
		name = "";
		clickedListener = new MyButtonListener();
		{
			image = new Image(region);
			image.setOrigin(image.getWidth() / 2, image.getWidth() / 2);
		}
		{
			this.setSize(image.getWidth(), image.getHeight());
			this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
		}

		{
			// LabelStyle style = new LabelStyle(font, fontColor);
			// label = new Label(text, style);

			switch (typefont) {
			case 14:
				label = new Label(text, ResourceManager.shared().lblStyleTahoma18);
				break;
			case 16:
				label = new Label(text, ResourceManager.shared().lblStyleTahoma20);
				break;
			case 18:
				label = new Label(text, ResourceManager.shared().lblStyleTahoma22);
				break;
			case 24:
				label = new Label(text, ResourceManager.shared().lblStyleTahoma24);
				break;
			default:
				label = new Label(text, ResourceManager.shared().lblStyleTahoma24);
				break;
			}

			label.setSize(this.getWidth(), this.getHeight());
			label.setAlignment(Align.center);
			label.setWrap(true);
			label.setTouchable(Touchable.disabled);
			label.setY(label.getY() + 5);

		}

		{
			this.addActor(image);
			if (label != null) {
				this.addActor(label);
			}
		}
		this.addListener(clickedListener);
	}

	public MyButton(String text, TextureRegion region) {
		clickedListener = new MyButtonListener();
		image = new Image(region);
		image.setOrigin(image.getWidth() / 2, image.getWidth() / 2);
		this.setSize(image.getWidth(), image.getHeight());
		this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);

		label = new Label(text, ResourceManager.shared().lblStyleTahoma22);
		label.setSize(this.getWidth(), this.getHeight());
		label.setAlignment(Align.center);
		// label.setWrap(true);
		label.setTouchable(Touchable.disabled);
		label.setY(label.getY() + 1);
		this.addActor(image);
		if (label != null) {
			this.addActor(label);
		}
		this.addListener(clickedListener);
	}

	public MyButton(String text, TextureRegion region, Color color) {
		clickedListener = new MyButtonListener();
		clickedListener.setTapCountInterval(0.5f);
		image = new Image(region);
		image.setOrigin(image.getWidth() / 2, image.getWidth() / 2);
		this.setSize(image.getWidth(), image.getHeight());
		this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);

		label = new Label(text, ResourceManager.shared().lblStyleTahoma16);
		label.setSize(this.getWidth(), this.getHeight());
		label.setAlignment(Align.center);
		label.setWrap(true);
		label.setTouchable(Touchable.disabled);
		label.setColor(color);
		this.fontColor = color;
		label.setY(label.getY() + 2);
		this.addActor(image);
		if (label != null) {
			this.addActor(label);
		}
		this.addListener(clickedListener);
	}

	class MyButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			super.clicked(event, x, y);
//				BaseInfo.gI().startClickButtonAudio();
//				BaseInfo.gI().Vibrate();
				precessClicked();
				addActionClicked();
		}

		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			if (!isDisable ) {
				MyButton.this.addAction(Actions.alpha(0.5f));
			}
			return super.touchDown(event, x, y, pointer, button);
		}

		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
			if (!isDisable ) {
				MyButton.this.addAction(Actions.alpha(1));
			}

			super.touchUp(event, x, y, pointer, button);
		}
		
	}

	public abstract void precessClicked();

	public void addActionClicked() {
		ScaleToAction action = Actions.scaleTo(1f, 1f, 0.2f);
		action.setInterpolation(Interpolation.pow3Out);
		this.addAction(Actions.sequence(Actions.scaleTo(1.1f, 1.1f, 0.2f), action));
	}

	private boolean isDisable = false;

	public void setImgDisable(TextureRegionDrawable drawable) {
		if (img_disable != null) {
			img_disable.setDrawable(drawable);
		} else {
			img_disable = new Image(drawable);
			this.addActor(img_disable);
			img_disable.toBack();
		}
		img_disable.setVisible(false);

	}

	public void setDisabled(boolean disable) {
		isDisable = disable;
		if (disable) {
			if (label != null)
				label.setColor(Color.valueOf("2c0404"));
			if (img_disable != null) {
				image.setVisible(false);
				img_disable.setVisible(true);
			} else {
				image.setVisible(true);
			}

		} else {
			if (label != null) {
				if (fontColor != null) {
					label.setColor(fontColor);
				} else {
					label.setColor(Color.WHITE);
				}
			}
			if (img_disable != null) {
				image.setVisible(true);
				img_disable.setVisible(false);
			} else {
				image.setVisible(true);
			}
		}
	}

	public void setDisabled(boolean disable, boolean setColor) {
		isDisable = disable;
		if (disable) {
			if (label != null && setColor) {
				label.setColor(Color.WHITE);
				// label.setColor(Color.valueOf("961919"));
				// label.setColor(Color.valueOf("f5f2f2"));
			}
			if (img_disable != null) {
				image.setVisible(false);
				img_disable.setVisible(true);
			} else {
				image.setVisible(true);
			}

		} else {
			if (label != null) {
				if (fontColor != null) {
					label.setColor(fontColor);
				} else {
					label.setColor(Color.WHITE);
				}
			}
			if (img_disable != null) {
				image.setVisible(true);
				img_disable.setVisible(false);
			} else {
				image.setVisible(true);
			}
		}

	}

	@Override
	public void setWidth(float width) {
		super.setWidth(width);
		image.setWidth(width);
		if (label != null) {
			label.setWidth(width);
		}
	}

	@Override
	public void setHeight(float height) {
		super.setHeight(height);
		image.setHeight(height);
		if (label != null) {
			label.setHeight(height);
		}
	}

	@Override
	public void setSize(float width, float height) {
		super.setSize(width, height);
		image.setWidth(width);
		image.setHeight(height);
		if (img_disable != null) {
			img_disable.setWidth(width);
			img_disable.setHeight(height);
		}
		if (label != null) {
			label.setWidth(width);
			label.setHeight(height);
		}
	}

	public void setImageSize(float width, float height) {
		image.setWidth(width);
		image.setHeight(height);
	}

	public String getName() {
		return name;
	}

	public void setColorText(Color color) {
		fontColor = color;
		if (label != null)
			label.setColor(color);
	}

	public void setAlign(int alignment) {
		if (label != null)
			label.setAlignment(alignment);
	}

	public void rotateImage(float x) {
		if (image != null) {
			image.setRotation(x);
		}
	}

	public void setDrableImage(TextureRegionDrawable drable) {
		image.setDrawable(drable);
	}
}
