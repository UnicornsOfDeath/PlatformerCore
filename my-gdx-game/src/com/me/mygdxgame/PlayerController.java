package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class PlayerController {
	PlayerControl player;
	ControlScheme scheme;
	Vector2[] debugFiringLine = null;
	public PlayerController(PlayerControl player, ControlScheme scheme) {
		super();
		this.player = player;
		this.scheme = scheme;
	}
	public Bullet handleInput(Camera camera) {
		Bullet bullet = null;
		if (Gdx.input.isKeyPressed(scheme.Left)) {
			player.moveLeft();
		}
		else if (Gdx.input.isKeyPressed(scheme.Right)) {
			player.moveRight();
		}
		else {
			player.stopMoving();
		}
		if (Gdx.input.isKeyPressed(scheme.Jump)) {
			player.jump();
		}
		debugFiringLine = null;
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(
					Gdx.input.getX(),
					camera.height - Gdx.input.getY(),
					0);
			debugFiringLine = new Vector2[2];
			debugFiringLine[0] = player.getPosition();
			debugFiringLine[1] = new Vector2(touchPos.x, touchPos.y);
			if (player.canFire()) {
				bullet = player.fire(new Vector2(touchPos.x, touchPos.y));
			}
		}
		return bullet;
	}
	public void draw() {
		if (debugFiringLine == null) {
			return;
		}
		ShapeRenderer r = new ShapeRenderer();
		r.begin(ShapeType.Line);
		r.setColor(1, 1, 0, 1);
		r.line(debugFiringLine[0].x, debugFiringLine[0].y,
				debugFiringLine[1].x, debugFiringLine[1].y);
		r.end();
	}
}
