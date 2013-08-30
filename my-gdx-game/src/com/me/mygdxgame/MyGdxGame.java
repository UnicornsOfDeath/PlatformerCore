package com.me.mygdxgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame implements ApplicationListener {
	Camera camera;
	Player player;
	PhysicsEngine physicsEngine;
	Collection<GameObject> gameObjects = new ArrayList<GameObject>();
	ControlScheme scheme;
	PlayerController controller;

	@Override
	public void create() {
		player = new Player(new Vector2(40, 70));
		scheme = new ControlScheme(Keys.A, Keys.D, Keys.SPACE);
		controller = new PlayerController(player, scheme);
		physicsEngine = new PhysicsEngine();
		physicsEngine.add(player);
		gameObjects.add(player);

		// create the camera and the SpriteBatch
		camera = new Camera(player, 800, 480, 0, 1000);
	}

	@Override
	public void render() {
		handleInput();
		update();
		draw();
	}
	
	void handleInput() {
		Bullet bullet = controller.handleInput(camera);
		if (bullet != null) {
			physicsEngine.add(bullet);
			gameObjects.add(bullet);
		}
	}

	void update() {
		Float dt = Gdx.graphics.getDeltaTime();
		physicsEngine.update(dt);
		for (GameObject o : gameObjects) {
			o.update(dt);
		}
		Iterator<GameObject> it = gameObjects.iterator();
		while (it.hasNext()) {
		    if (it.next().isExpired()) {
		        it.remove();
		    }
		}
		physicsEngine.postUpdate();

		// tell the camera to update its matrices.
		camera.update();
	}

	void draw() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		for (GameObject o : gameObjects) {
			o.draw(null, 0, 0, camera.width, camera.height);
		}
		controller.draw();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}