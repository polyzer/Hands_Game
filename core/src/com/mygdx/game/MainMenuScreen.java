package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;


/**
 * Created by cash on 11.02.2016.
 */

public class MainMenuScreen implements Screen {

    final MyGdxGame game;

    OrthographicCamera camera;

    public MainMenuScreen(final MyGdxGame gam)
    {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 651, 970);

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        /////////////
        //////////
        /// РИСОВАНИЕ ЗДЕСЬ
        game.batch.end();
    }
    @Override
    public void dispose()
    {}
    @Override
    public void hide()
    {}
    @Override
    public void resize(int width, int height)
    {}
    @Override
    public void show()
    {}
    @Override
    public void resume()
    {}
    @Override
    public void pause()
    {}
}
