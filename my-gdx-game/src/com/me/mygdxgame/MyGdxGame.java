package com.me.mygdxgame;

import java.util.ArrayList;
import java.util.Collection;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGame implements ApplicationListener {
   Camera camera;
   Player player;
   PhysicsEngine physicsEngine;
   Collection<Drawable> drawableObjects = new ArrayList<Drawable>();
   
   @Override
   public void create() {
      player = new Player(new Vector2(40, 40));
      physicsEngine = new PhysicsEngine();
      physicsEngine.add(player);
      drawableObjects.add(player);
	   
	   // create the camera and the SpriteBatch
      camera = new Camera(player, 800, 480, 0, 1000);
   }
   
   @Override
   public void render() {
      // clear the screen with a dark blue color. The
      // arguments to glClearColor are the red, green
      // blue and alpha component in the range [0,1]
      // of the color to be used to clear the screen.
      Gdx.gl.glClearColor(0, 0, 0.2f, 1);
      Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

      // process user input
      if (Gdx.input.isKeyPressed(Keys.A)) {
    	  player.moveLeft();
      }
      else if (Gdx.input.isKeyPressed(Keys.D)) {
    	  player.moveRight();
      }
      else {
    	  player.stopMoving();
      }
      if (Gdx.input.isKeyPressed(Keys.SPACE)) {
    	  player.jump();
      }
      if (Gdx.input.isTouched()) {
          Vector3 touchPos = new Vector3();
          touchPos.set(
        		  Gdx.input.getX(),
        		  camera.height - Gdx.input.getY(),
        		  0);
          ShapeRenderer r = new ShapeRenderer();
          r.begin(ShapeType.Line);
          r.setColor(1, 1, 0, 1);
          r.line(player.position.x, player.position.y,
        		  touchPos.x, touchPos.y);
          r.end();
          Bullet bullet = player.fire(new Vector2(touchPos.x, touchPos.y));
          physicsEngine.add(bullet);
          drawableObjects.add(bullet);
       }

      Float dt = Gdx.graphics.getDeltaTime();
      physicsEngine.update(dt);

      // tell the camera to update its matrices.
      camera.update();
      
      for (Drawable d : drawableObjects) {
    	  d.draw();
      }
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