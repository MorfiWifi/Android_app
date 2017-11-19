package com.apps.kasrazhino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

<<<<<<< HEAD:Kasrazhino/app/src/main/java/com/apps/kasrazhino/kasrazhino/MainActivity.java
import com.apps.kasrazhino.kasrazhino.Stuff_List.StuffList;
=======
import com.apps.kasrazhino.kasrazhino.R;
>>>>>>> e07130771d1b2d0bc3e44d907bb18ec5b50eff6b:app/src/main/java/com/apps/kasrazhino/MainActivity.java

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
