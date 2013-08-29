package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public interface GameObject extends Drawable {
	public void update(float dt);
	public boolean isExpired();
}
