package com.example.kenkelvin.ondealuga;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ViewFlipper;


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
        edtNome = (EditText) findViewById(R.id.edtNome);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        spEdit = sp.edit();

//        if (sp.contains("access_token")){
//            Intent i = new Intent(this, MainActivity.class);
//            startActivity(i);
//            finish();
//        }

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

    public void cadastro(View v){
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
        finish();
    }

}
