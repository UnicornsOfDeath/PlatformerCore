package com.me.mygdxgame;

import com.badlogic.gdx.math.Vector2;

public abstract class MovingEntity {
	Vector2 position = new Vector2(Vector2.Zero);
	Vector2 momentum = new Vector2(Vector2.Zero);
	
	public void update(float dt) {
		position.add(new Vector2(momentum).mul(dt));
	}
	public void addGravity(float force) {
		momentum.y += force;
	}
	public void land(float floorY) {
		if (position.y < floorY) {
			position.y = floorY;
			momentum.y = 0;
			onLand();
		}
	}
	abstract void onLand();
}
