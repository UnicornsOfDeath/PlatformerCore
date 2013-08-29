package com.me.mygdxgame;

import com.badlogic.gdx.math.Vector2;

public interface PlayerControl {
	public void moveLeft();
	public void moveRight();
	public void stopMoving();

	public void jump();
	
	public Vector2 getPosition();
	public boolean canFire();
	public Bullet fire(Vector2 to);
}
