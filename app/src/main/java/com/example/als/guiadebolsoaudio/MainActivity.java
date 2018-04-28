package com.example.als.guiadebolsoaudio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity{
    private MediaPlayer player;
    private Button play, pause, stop, fruta, numero, parente, expressao;
    private TextView inic, fim;
    private SeekBar seekBar;
    private double mStartTime = 0;
    private double mFinalTime = 0;
    private Handler manipular = new Handler();


    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            mStartTime = player.getCurrentPosition();
            inic.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long)mStartTime),
                                                         TimeUnit.MILLISECONDS.toSeconds((long)mStartTime) -
                                                         TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)mStartTime))));
            seekBar.setProgress((int)mStartTime);
            manipular.postDelayed(this,1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruta = findViewById(R.id.btnFrutas);
        parente = findViewById(R.id.btnParentes);
        expressao = findViewById(R.id.btnExpressoes);
        numero = findViewById(R.id.btnNumeros);
        fruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencaoFruta = new Intent(MainActivity.this, FrutasActivity.class);
                MainActivity.this.startActivity(intencaoFruta);
            }
        });
        parente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencaoParente = new Intent(MainActivity.this, ParenteActivity.class);
                MainActivity.this.startActivity(intencaoParente);
            }
        });
        expressao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencaoExpressao = new Intent(MainActivity.this, ExpressaoActivity.class);
                MainActivity.this.startActivity(intencaoExpressao);
            }
        });
        numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencaoNumero = new Intent(MainActivity.this, NumeroActivity.class);
                MainActivity.this.startActivity(intencaoNumero);
            }
        });

        play = findViewById(R.id.btnPlay);
        pause = findViewById(R.id.btnPause);
        stop = findViewById(R.id.btnStop);
        inic = findViewById(R.id.txtInic);
        fim = findViewById(R.id.txtFim);
        seekBar = findViewById(R.id.seek);
        seekBar.setClickable(false);
        player = MediaPlayer.create(this, R.raw.metallica);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                player.start();
                mFinalTime = player.getDuration();
                mStartTime = player.getCurrentPosition();
                fim.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long)mFinalTime),
                                                            TimeUnit.MILLISECONDS.toSeconds((long)mFinalTime) -
                                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)mFinalTime))));
                inic.setText(String.format("%d min, %d sec",TimeUnit.MILLISECONDS.toMinutes((long)mStartTime),
                                                            TimeUnit.MILLISECONDS.toSeconds((long)mStartTime) -
                                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)mStartTime))));
                double tempo = mFinalTime;
                seekBar.setMax(Integer.valueOf((int)tempo));
                seekBar.setProgress((int)mStartTime);
                manipular.postDelayed(UpdateSongTime, 100);
                inic.setText((String.valueOf(player.getCurrentPosition())));
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();
            }
        });
    }
}