package com.me.mygdxgame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends MovingEntity implements Drawable {
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
	public void draw() {
		ShapeRenderer r = new ShapeRenderer();
		r.begin(ShapeType.Triangle);
		r.setColor(1, 0, 1, 1);
		r.triangle(
				position.x, position.y + size.y / 2,
				position.x + size.x / 2, position.y - size.y / 2,
				position.x - size.x / 2, position.y - size.y / 2);
		r.end();
	}
}
