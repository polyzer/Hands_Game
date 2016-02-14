package com.mygdx.game;

/**
 * Created by cash on 14.02.2016.
 */
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

// в этом классе ничего не будет меняться.
public class Hand {

    Texture Texture;
    // здесь записана ширина и высота,
    // а так же положение руки
    Rectangle Rectangle;

    // левая или правая рука?
    // 1 - левая, 0 - правая
    boolean Directionality;

    // направление движения руки!
    boolean MovingDirection;

    public Hand()
    {
        this.Texture = new Texture();
        this.Rectangle = new Rectangle();
    }

    public Hand(Texture hTexture, Rectangle Rect)
    {
        this.Texture = hTexture;
        this.Rectangle = Rect;
    }

    public Texture getTexture()
    {
        return this.Texture;
    }

    public void setTexture(Texture hTexture)
    {
        this.Texture = hTexture;
    }

    public Rectangle getRectangle()
    {
        return this.Rectangle;
    }

    public void setRectangle(Rectangle hRect)
    {
        this.Rectangle = hRect;
    }
}
