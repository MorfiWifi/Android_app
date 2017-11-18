package com.apps.kasrazhino.kasrazhino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import com.apps.kasrazhino.kasrazhino.Stuff_List.StuffList;

public class MainActivity extends AppCompatActivity {
    static public int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation animation = AnimationUtils.loadAnimation(this , R.anim.move_left);

//        findViewById(R.id.loginback).startAnimation(animation);

        Intent intent = new Intent(this,StuffList.class);
        startActivity(intent);


}

    @Override
    public void onBackPressed() {
        if (i== 0){
            i++;
            TranslateAnimation trans = new TranslateAnimation(0, 100, 0, 100);
            trans.setDuration(250);
            trans.setInterpolator(new AccelerateInterpolator(1.0f));
            findViewById(R.id.loginback).startAnimation(trans);
        }
        else {
            super.onBackPressed();
        }

    }
}
