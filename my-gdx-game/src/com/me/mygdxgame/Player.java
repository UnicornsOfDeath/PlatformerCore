package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Player extends MovingEntity implements PlayerControl {
	public static final Float MOVE_FORCE = 200.0f;
	public static final Float JUMP_FORCE = 450.0f;

	Vector2 size;
	Gun gun = new Gun(Gun.DELAY);
	
	public Player(Vector2 size) {
		this.size = size;
	}
	
	public void moveLeft() {
		momentum.x = -Player.MOVE_FORCE;
	}
	public void moveRight() {
		momentum.x = Player.MOVE_FORCE;
	}
	public void stopMoving() {
		momentum.x = 0;
	}

	void onJump() {
		momentum.y = Player.JUMP_FORCE;
	}
	void onLand() {
	}
	
	public boolean canFire() {
		return gun.canFire();
	}
	public Bullet fire(Vector2 to) {
		return gun.fire(position, to);
	}
	
	public void update(float dt) {
		super.update(dt);
		gun.update(dt);
	}

	@Override
	public void draw(SpriteBatch batch, float x, float y, float width,
			float height) {
		ShapeRenderer r = new ShapeRenderer();
		r.begin(ShapeType.Rectangle);
		r.setColor(1, 1, 0, 1);
		r.translate(position.x, position.y, 0);
		r.scale(size.x, size.y, 1.0f);
		r.rect(-0.5f, -0.5f, 1.0f, 1.0f);
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

	@Override
	public boolean isExpired() {
		return false;
	}

	@Override
	public Vector2 getPosition() {
		return new Vector2(position);
	}

	@Override
	float getFeetYOffset() {
		return -size.y / 2;
	}
}
