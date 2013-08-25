package com.me.mygdxgame;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class Camera extends OrthographicCamera {
	MovingEntity subject;
	int width;
	int height;
	
	// Limits for where the camera can go
	int limitLeft;
	int limitRight;
	
	public Camera(MovingEntity subject, int width, int height, int limitLeft, int limitRight) {
		this.subject = subject;
		this.width = width;
		this.height = height;
		this.limitLeft = limitLeft;
		this.limitRight = limitRight;
		setToOrtho(false, width, height);
		position.set(0, 0, 0);
	}
	
	public void update() {
		//position.set(subject.position.x, subject.position.y, 0);
		//super.update();
	}
	
	public boolean isInShot(Vector2 v) {
		return v.x >= position.x - width / 2 && v.x < position.x + width / 2 &&
				v.y >= position.y - height / 2 && v.y < position.y + height / 2;
	}
}
