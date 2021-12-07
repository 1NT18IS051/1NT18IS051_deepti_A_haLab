package com.example.mediaplayer_051;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  int starttime=0;
  int stoptime=0;
  int forwardtime=5000;
  int backwardtime=5000;
  MediaPlayer mediaPlayer,mediaPlayernew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mediaPlayer=MediaPlayer.create(this,R.raw.ringtone);
        mediaPlayernew=MediaPlayer.create(this,R.raw.ringtone);
        TextView songtitle=findViewById(R.id.songname);
        songtitle.setText("Instrumental");

        Button play=findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Playing song", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
            });

        Button pause=findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Pausing song", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });

        Button forward=findViewById(R.id.fd);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentpos=mediaPlayer.getCurrentPosition();
                if((currentpos+forwardtime)<=(stoptime=mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardtime);
                }
            }
        });

        Button rewind=findViewById(R.id.rd);
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentpos=mediaPlayer.getCurrentPosition();
                if((currentpos-backwardtime)>=0){
                    mediaPlayer.seekTo(currentpos-backwardtime);
                }
            }
        });

        Button stop=findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Stopping song", Toast.LENGTH_SHORT).show();
               mediaPlayer.stop();
               mediaPlayer=mediaPlayernew;
            }
        });

        Button restart=findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Restarting song", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });
    }
}