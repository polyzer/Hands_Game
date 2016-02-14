package com.mygdx.game;

/**
 * Created by cash on 11.02.2016.
 */

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;

public class GameScreen implements Screen {

    final MyGdxGame game;
    // сюда все будет отрисовываться
    SpriteBatch MainBatch;
    //even - четный - левая рука
    //odd - нечетный - правая рука
    Array<Texture> HandsTextures;
    // здесь хранятся все бэкграунды
    Array<Texture> BackTextures;
    // бэкзвуки
    Array<Music> BarBackSounds;
    // руки, которые отображаются
    Array<Rectangle> ScreenHands;

    // нужно чтобы проигрывать только один звук
    Music currentBarSoundBack;
    boolean available;
    int orientation;
    // основная камера
    OrthographicCamera camera;

    public GameScreen (final MyGdxGame gam) {

        this.game = gam;

        MainBatch = new SpriteBatch();

        HandsTextures = new Array<Texture>();
        BackTextures = new Array<Texture>();
        BarBackSounds = new Array<Music>();

        ScreenHands = new Array<Rectangle>();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 651, 970);

        Texture timeTexture;
        Rectangle timeRectangle;

        // добавление текстур рук
        for(int i = 1; i <= 2; i++) {
            HandsTextures.add(new Texture(Gdx.files.internal("Imgs/hand_"+ Integer.toString(i) +"_left.png")));
            HandsTextures.add(new Texture(Gdx.files.internal("Imgs/hand_"+ Integer.toString(i) +"_right.png")));
        }



        // добавление бэкграундов
        for(int i = 1; i <= 1; i++) {
            BackTextures.add(new Texture(Gdx.files.internal("Imgs/back_"+ Integer.toString(i)+".png")));
        }

        for(int i = 1; i <= 2; i++)
        {
            BarBackSounds.add(Gdx.audio.newMusic(Gdx.files.internal("BarSoundBacks/barsound_" + Integer.toString(i) + ".mp3")));
        }

        available = Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);
        currentBarSoundBack = BarBackSounds.random();
        currentBarSoundBack.setLooping(true);
        currentBarSoundBack.play();

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        MainBatch.setProjectionMatrix(camera.combined);
        MainBatch.begin();
        MainBatch.draw(BackTextures.random(), 0, 0);
        MainBatch.draw(HandsTextures.random(), 0, 0);
        MainBatch.end();
    }

    @Override
    public void dispose()
    {
        // временные объекты, используемые для удаления элементов массива
        Texture tT;
        Music tM;
        Iterator<Texture> T_iter;
        Iterator<Music> M_iter;

        T_iter = HandsTextures.iterator();
        while(T_iter.hasNext())
        {
            tT = T_iter.next();
            tT.dispose();
            T_iter.remove();
        }

        T_iter = BackTextures.iterator();
        while(T_iter.hasNext())
        {
            tT = T_iter.next();
            tT.dispose();
            T_iter.remove();
        }

        M_iter = BarBackSounds.iterator();
        while(M_iter.hasNext())
        {
            tM = M_iter.next();
            tM.dispose();
            M_iter.remove();
        }

        MainBatch.dispose();
    }

    @Override
    public void show()
    {}

    @Override
    public void resize(int width, int height)
    {}
    @Override
    public void pause()
    {}
    @Override
    public void resume()
    {}
    @Override
    public void hide()
    {}
}
