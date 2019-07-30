package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture []bird;
	int flapState=0;
	float birdY=0;
	float velocity=0;
	int gameState=0;
	float gravity=2;

	Texture topTube;

	@Override
	public void create() {

		batch = new SpriteBatch();
		background = new Texture("bg.png");

		bird = new Texture[2];
		bird[0] = new Texture("bird.png");
		bird[1] = new Texture("bird2.png");

	}
//sssssssssssssssssssssssssssssssssssss
//ggggggggggggggggggggggg
	@Override
	public void render() {

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if (gameState != 0) {


			if (Gdx.input.justTouched()) {
				velocity = -25;

			}



			if (birdY>0 || velocity<0) {
				velocity = velocity + gravity;
				birdY -= velocity;
			}
		}else {

			if (Gdx.input.justTouched()){
				gameState=1;
			}
		}

		if (flapState == 0) {
			flapState = 1;
		} else {
			flapState = 0;
		}


		batch.draw(bird[flapState], Gdx.graphics.getWidth() / 2-bird[flapState].getWidth()/2, birdY);
		batch.end();
	}

}
