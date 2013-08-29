package com.me.mygdxgame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Player extends MovingEntity implements Drawable {
	public static final Float MOVE_FORCE = 200.0f;
	public static final Float JUMP_FORCE = 450.0f;

	PlayerAssets assets;

	Vector2 size;
	Boolean isJumping = false;
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

	public void jump() {
		if (!isJumping) {
			momentum.y = Player.JUMP_FORCE;
			isJumping = true;
		}
	}
	public void onLand() {
		if (isJumping) {
			isJumping = false;
		}
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
	
	public void draw() {
		ShapeRenderer r = new ShapeRenderer();
		r.begin(ShapeType.Circle);
		r.setColor(1, 1, 0, 1);
		r.circle(position.x, position.y, size.x / 2);
		r.end();
	}
}
