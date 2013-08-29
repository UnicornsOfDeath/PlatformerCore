package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends MovingEntity {
	Vector2 size;
	public Bullet(
			Vector2 size,
			Vector2 position,
			Vector2 momentum) {
		this.size = size;
		this.position = position;
		this.momentum = momentum;
	}
	public void onLand() {}
	@Override
	public void draw(SpriteBatch batch, float x, float y, float width,
			float height) {
		ShapeRenderer r = new ShapeRenderer();
		r.begin(ShapeType.Triangle);
		r.setColor(1, 0, 1, 1);
		r.triangle(
				position.x, position.y + size.y / 2,
				position.x + size.x / 2, position.y - size.y / 2,
				position.x - size.x / 2, position.y - size.y / 2);
		r.end();
	}
	@Override
	public float getLeftWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setLeftWidth(float leftWidth) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float getRightWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setRightWidth(float rightWidth) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float getTopHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setTopHeight(float topHeight) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float getBottomHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setBottomHeight(float bottomHeight) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float getMinWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setMinWidth(float minWidth) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float getMinHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setMinHeight(float minHeight) {
		// TODO Auto-generated method stub
		
	}
}
