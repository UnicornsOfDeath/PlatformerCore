package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class AnimatedPlayer extends Player {
	float stateCounter = 0;
	boolean isWalking = false;
	public AnimatedPlayer(Vector2 size) {
		super(size);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		if (!isWalking) {
			isWalking = true;
			stateCounter = 0;
		}
	}
	@Override
	public void moveRight() {
		super.moveRight();
		if (!isWalking) {
			isWalking = true;
			stateCounter = 0;
		}
	}
	@Override
	public void stopMoving() {
		super.stopMoving();
		if (isWalking) {
			isWalking = false;
			stateCounter = 0;
		}
	}

	@Override
	void onJump() {
		super.onJump();
		stateCounter = 0;
	}
	@Override
	void onLand() {
		super.onLand();
		stateCounter = 0;
	}
	
	@Override
	public void update(float dt) {
		super.update(dt);
		stateCounter += dt;
	}
	@Override
	public void draw(SpriteBatch batch, float x, float y, float width,
			float height) {
		super.draw(batch, x, y, width, height);
		ShapeRenderer r = new ShapeRenderer();
		if (isJumping) {
			int jumpFrame = (Math.round(stateCounter*1000) / 40) % 25;
			float yScalar = 0.5f * MathUtils.sin(jumpFrame * MathUtils.PI * 2 / 30);
			yScalar += 1.0;
			r.begin(ShapeType.Triangle);
			r.translate(position.x, position.y, 0);
			r.scale(size.x / 4, size.y / 4 * yScalar, 1.0f);
			r.triangle(0, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f);
			r.end();
		} else if (isWalking) {
			int walkFrame = (Math.round(stateCounter*1000) / 40) % 25;
			r.begin(ShapeType.Rectangle);
			r.translate(position.x, position.y - size.y / 4, 0);
			r.rotate(0, 0, 1, walkFrame * 360 / 25);
			r.scale(size.y / 2, size.y / 2, 1.0f);
			r.rect(-0.5f, -0.5f, 1.0f, 1.0f);
			r.end();
		}
	}
}
