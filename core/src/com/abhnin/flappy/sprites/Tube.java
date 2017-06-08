package com.abhnin.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Sony on 6/8/2017.
 */

public class Tube {
    private static final int FLUCTUATION = 130;
    public static final int TUBE_WIDTH = 52;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    private Texture topTube;
    private Texture bottomTube;
    private Rectangle boundsTop, boundsBottom;

    private Vector2 posTopTube, posBottomTube;
    private Random rand;

    public Tube(float x){
        topTube = new Texture("topTube.png");
        bottomTube = new Texture("bottomTube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING );
        posBottomTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(getPosTopTube().x, getPosTopTube().y, topTube.getWidth(), topTube.getHeight());
        boundsBottom =  new Rectangle(getPosBottomTube().x, getPosBottomTube().y, bottomTube.getWidth(), bottomTube.getHeight());

    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public void reposition(float x) {
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING );
        posBottomTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBottom.setPosition(posBottomTube.x, posBottomTube.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(boundsTop) || player.overlaps(boundsBottom);
    }

    public void dispose() {
        topTube.dispose();
        bottomTube.dispose();

    }
}
