package com.me.mygdxgame;

import com.badlogic.gdx.math.Vector2;

public abstract class MovingEntity implements GameObject {
	Vector2 position = new Vector2(Vector2.Zero);
	Vector2 momentum = new Vector2(Vector2.Zero);
	Boolean isJumping = false;
	public void update(float dt) {
		position.add(new Vector2(momentum).mul(dt));
	}
	public void addGravity(float force) {
		momentum.y += force;
	}
	public void jump() {
		if (!isJumping) {
			isJumping = true;
			onJump();
		}
	}
	abstract void onJump();
	public void land(float floorY) {
		if (position.y + getFeetYOffset() < floorY) {
			position.y = floorY - getFeetYOffset();
			momentum.y = 0;
			if (isJumping) {
				isJumping = false;
				onLand();
			}
		}
	}
	abstract void onLand();
	abstract float getFeetYOffset();
}
