package com.example.kiang.adroid_projrct;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    public MediaPlayer MC = new MediaPlayer();
    public MediaPlayer[] Player = {MC,MC,MC,MC,MC};
    public ImageView IV;
    public ConstraintLayout CL;
    public Random rand = new Random();
    public int[] Background = {R.mipmap.river,R.mipmap.bird,R.mipmap.forest,R.mipmap.rain,R.mipmap.beach};
    public int Num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        IV = (ImageView)findViewById(R.id.imageView);
        CL = (ConstraintLayout)findViewById(R.id.screen);

        Player[0] = MediaPlayer.create(this,R.raw.background);
        Player[1] = MediaPlayer.create(this,R.raw.bird);
        Player[2] = MediaPlayer.create(this,R.raw.bug);
        Player[3] = MediaPlayer.create(this,R.raw.rain);
        Player[4] = MediaPlayer.create(this,R.raw.sea);

        IV.setY(259*3);
        IV.setX(168*3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();
        try
        {
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    Num = rand.nextInt(5)+0;
                    Player[Num].seekTo(0);
                    Player[Num].start();
                    if(Background[Num] == 0) CL.setBackgroundColor(Color.BLUE);
                    else CL.setBackgroundResource(Background[Num]);
                    IV.setX(x-40);
                    IV.setY(y-125);
                    break;
                case MotionEvent.ACTION_UP:
                    Player[Num].stop();
                    Player[Num].prepare();
                    CL.setBackgroundColor(Color.WHITE);
                    break;
                case MotionEvent.ACTION_MOVE:
                    IV.setX(x-40);
                    IV.setY(y-125);
                    break;
            }
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

}
