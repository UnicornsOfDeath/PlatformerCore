package com.me.mygdxgame;

import java.util.ArrayList;
import java.util.Collection;

public class PhysicsEngine {
	public static final Float GRAVITY = -981.0f;
	public static final Float FLOOR_Y = 20.0f;
	Collection<MovingEntity> entities = new ArrayList<MovingEntity>();
	
	public void add(MovingEntity entity) {
		entities.add(entity);
	}
	
	public void update(float dt) {
		for (MovingEntity entity : entities) {
			entity.addGravity(GRAVITY*dt);
		}
	}
	public void postUpdate() {
		for (MovingEntity entity : entities) {
			entity.land(FLOOR_Y);
		}
	}
}
