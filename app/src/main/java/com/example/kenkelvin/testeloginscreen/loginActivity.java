package com.example.kenkelvin.testeloginscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import java.util.Vector;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class loginActivity extends Activity {

    private EditText edtNome;
    private EditText edtSenha;
    private SharedPreferences sp;
    private SharedPreferences.Editor spEdit;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ViewFlipper mViewFlipper;
    private Context mContext;
    private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // tentativa 1

        //final ImageView animImageViewCity = (ImageView) findViewById(R.id.ivAnimationCity);
        //animImageViewCity.setBackgroundResource(R.drawable.anim_city);
        //animImageViewCity.post(new Runnable() {
        //    @Override
        //    public void run() {
        //        AnimationDrawable frameAnimation =
        //                (AnimationDrawable) animImageViewCity.getBackground();
        //        frameAnimation.start();
        //    }
        //});

        // tentativa 2

        //ImageView img = (ImageView)findViewById(R.id.ivAnimationCity);
        //img.setBackgroundResource(R.drawable.anim_city);
        //AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        //frameAnimation.start();

        edtNome = (EditText) findViewById(R.id.edtNome);

        //sp = getSharedPreferences("prefs", MODE_PRIVATE);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        spEdit = sp.edit();

        //edtNome.setText( sp.getString("nome", "") );
        if (sp.contains("access_token")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }

        mContext = this;
        mViewFlipper = (ViewFlipper) this.findViewById(R.id.view_flipper);
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(5000);
        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
        mViewFlipper.startFlipping();
        mViewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }

    class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
                    mViewFlipper.showNext();
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.right_out));
                    mViewFlipper.showPrevious();
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public void login(View v){
        spEdit.putString("access_token", edtNome.getText().toString());
        spEdit.commit();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }



}
