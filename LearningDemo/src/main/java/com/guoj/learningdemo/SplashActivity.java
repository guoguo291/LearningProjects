package com.guoj.learningdemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.guoj.learningdemo.utils.CustomCountTimer;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.id_vv_player)
    VideoView viewplayer;
    @BindView(R.id.id_tv_splash)
    TextView tv_splash;
    private CustomCountTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        viewplayer.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ File.separator+R.raw.splash));
        viewplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                viewplayer.start();
            }
        });
        viewplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                viewplayer.start();
            }
        });
        timer = new CustomCountTimer(5, new CustomCountTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                tv_splash.setText(time+R.string.time_second);
            }

            @Override
            public void onFinish() {
                tv_splash.setText(R.string.tv_skip);
            }
        });
        timer.start();
    }
    @OnClick(R.id.id_tv_splash)
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.id_tv_splash:
                startActivity(new Intent(SplashActivity.this,MainMenuActivity.class));
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
