package com.el.screenshoteffect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    //Declaring Variables

    Button takeScreenShotButton;
    FrameLayout ScreenShotEffectLayout;

    long fadeDuration=  2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeVariables();

        takeScreenShotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenShotEffect();
            }
        });
    }

    public void InitializeVariables(){
        takeScreenShotButton = (Button) findViewById(R.id.takeScreenShot);
        ScreenShotEffectLayout = (FrameLayout) findViewById(R.id.ScreenShotLayout);
    }

    public void ScreenShotEffect(){
        AlphaAnimation fade = new AlphaAnimation(1,0);
        fade.setDuration(fadeDuration);
        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ScreenShotEffectLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ScreenShotEffectLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        ScreenShotEffectLayout.startAnimation(fade);
    }

}
