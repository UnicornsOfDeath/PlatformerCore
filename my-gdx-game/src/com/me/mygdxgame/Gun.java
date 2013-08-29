package com.me.mygdxgame;

import com.badlogic.gdx.math.Vector2;

public class Gun {
	public static final Float SPEED = 800.0f;
	public static final Float DELAY = 0.2f;
	float delay;
	float delayCounter = 0.0f;
	public Gun(float delay) {
		this.delay = delay;
	}
	public void update(float dt) {
		delayCounter += dt;
	}
	public boolean canFire() {
		return delayCounter > delay;
	}
	public Bullet fire(Vector2 from, Vector2 to) {
		assert canFire();
		delayCounter = 0;
		return new Bullet(
				new Vector2(5, 5),
				new Vector2(from),
				new Vector2(to).add(new Vector2(from).mul(-1)).nor().mul(SPEED));
	}
}
