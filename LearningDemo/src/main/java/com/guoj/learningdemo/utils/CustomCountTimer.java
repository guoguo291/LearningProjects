package com.guoj.learningdemo.utils;


import android.os.Handler;

/**
 * 自定义计时器
 * Created by guoj on 2019/4/16.
 */

public class CustomCountTimer implements Runnable{
    private int time;
    private int countDownTime;
    private ICountDownHandler countDownHandler;
    private boolean isRun;
    private Handler handler;
    public CustomCountTimer(int time,ICountDownHandler countDownHandler) {
        handler=new Handler();
        this.time = time;
        this.countDownTime=time;
        this.countDownHandler=countDownHandler;
    }

    @Override
    public void run() {
        if(isRun){
            if(countDownHandler!=null){
                countDownHandler.onTicker(countDownTime);
            }
            if(countDownTime==0){
                cancel();
                if(countDownHandler!=null){
                    countDownHandler.onFinish();
                }
            }else{
                countDownTime=time--;
                handler.postDelayed(this,1000);
            }
        }
    }
    //开始计时
    public void start(){
        isRun=true;
        handler.post(this);
    }
    public void cancel(){
        isRun=false;
        handler.removeCallbacks(this);
    }
    public interface ICountDownHandler{
        void onTicker(int time);
        void onFinish();
    }
}
