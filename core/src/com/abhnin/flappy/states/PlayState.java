package com.abhnin.flappy.states;

import com.abhnin.flappy.FlappyBird;
import com.abhnin.flappy.sprites.Bird;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sony on 6/8/2017.
 */

public class PlayState extends State{
    private Bird bird;
    private Texture bg;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 100);
        cam.setToOrtho(false, FlappyBird.WIDTH/2, FlappyBird.HEIGHT/2);
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2), 0);
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
