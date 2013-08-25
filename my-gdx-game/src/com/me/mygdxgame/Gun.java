package com.me.mygdxgame;

import com.badlogic.gdx.math.Vector2;

public class Gun {
	public static final Float SPEED = 800.0f;
	public Bullet fire(Vector2 from, Vector2 to) {
		return new Bullet(
				new Vector2(5, 5),
				new Vector2(from),
				new Vector2(to).add(new Vector2(from).mul(-1)).nor().mul(SPEED));
	}
}
