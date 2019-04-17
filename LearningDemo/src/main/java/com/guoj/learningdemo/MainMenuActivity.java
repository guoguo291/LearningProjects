package com.guoj.learningdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.guoj.learningdemo.annotation.Viewinject;

import butterknife.BindView;
import butterknife.OnClick;

//使用自定义注解
@Viewinject(mainlayoutid = R.layout.activity_main_menu)
public class MainMenuActivity extends BaseActivity {

   
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.id_rg_main_top)
    RadioGroup idRgMainTop;
    @BindView(R.id.rb_main_nav_home_beijing)
    RadioButton rbMainNavHomeBeijing;
    @BindView(R.id.rb_main_nav_car_source_shenzhen)
    RadioButton rbMainNavCarSourceShenzhen;
    @BindView(R.id.id_rg_main_bottom)
    RadioGroup idRgMainBottom;
    private boolean isChangeTopOrBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeAnima(idRgMainBottom,idRgMainTop);
    }

    @OnClick(R.id.fac_main_home)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.fac_main_home:
                isChangeTopOrBottom=!isChangeTopOrBottom;
                if(isChangeTopOrBottom){
                    changeAnima(idRgMainTop,idRgMainBottom);
                }else{
                    changeAnima(idRgMainBottom,idRgMainTop);
                }
        }
    }

    private void changeAnima(RadioGroup gone,RadioGroup show) {
        //消失的动画
        gone.clearAnimation();
        Animation animationGone= AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);
        //出现的动画
        show.clearAnimation();
        Animation animationShow= AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }
}
