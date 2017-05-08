package com.example.kiang.adroid_projrct;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Music extends AppCompatActivity {

    private MediaPlayer player;
    Button music1_star,music1_pause,music_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        music1_star=(Button)findViewById(R.id.music1_btn_star);
        music1_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    player.start();
                }catch(Exception e){}

            }
        });
        music1_pause=(Button)findViewById(R.id.music1_btn_pause);
        music1_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying()==false)return;
                try{
                    player.pause();
                }catch (Exception e){}
            }
        });
        music_stop=(Button)findViewById(R.id.music1_btn_stop);
        music_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    player.stop();
                    player.prepare();
                }catch (Exception e){}
            }
        });

    }

    public void onResume(){
        super.onResume();
        player= MediaPlayer.create(this,R.raw.some_body_hurt_my_dick);
        player.setOnCompletionListener(comL);
    }

    public void onPause(){
        super.onPause();
        player.release();
    }

    private MediaPlayer.OnCompletionListener comL=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            try{
                player.stop();
                player.prepare();
            }catch (Exception e){}
        }
    };

}
