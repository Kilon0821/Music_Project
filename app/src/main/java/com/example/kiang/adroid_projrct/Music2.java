package com.example.kiang.adroid_projrct;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Music2 extends AppCompatActivity {

    private MediaPlayer player;
    Button music2_start,music2_pause,music2_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music2);
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

    music2_start=(Button)findViewById(R.id.music2_btn_start);
        music2_start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                player.start();
            }catch(Exception e){}

        }
    });
    music2_pause=(Button)findViewById(R.id.music2_btn_pause);
        music2_pause.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(player.isPlaying()==false)return;
            try{
                player.pause();
            }catch (Exception e){}
        }
    });
    music2_stop=(Button)findViewById(R.id.music2_btn_stop);
        music2_stop.setOnClickListener(new View.OnClickListener() {
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
        player= MediaPlayer.create(this,R.raw.relax);
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
