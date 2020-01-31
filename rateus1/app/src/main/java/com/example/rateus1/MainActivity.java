package com.example.rateus1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView titlerate, resultrate;
    Button btnfeedback;
    RatingBar rateStars;
    ImageView charPlace;
    String answerValue;
    Animation charanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlerate = findViewById(R.id.titlerate);
        resultrate = findViewById(R.id.resultrate);

        btnfeedback = findViewById(R.id.btnfeedback);

        rateStars = findViewById(R.id.rateStars);

        charPlace = findViewById(R.id.charPlace);

        //load animation
        charanim = AnimationUtils.loadAnimation(this, R.anim.charanim);

        //give animate
        charPlace.startAnimation(charanim);

        // give Condition
        rateStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                answerValue = String.valueOf((int) (rateStars.getRating()));
                if (answerValue.equals("1")){
                    charPlace.setImageResource(R.drawable.onestarsprite);
                    resultrate.setText("Just So So");
                } else if (answerValue.equals("2")){
                    charPlace.setImageResource(R.drawable.twostarsprite);
                    resultrate.setText("Just So So");
                } else if (answerValue.equals("3")){
                    charPlace.setImageResource(R.drawable.threestarsprite);
                    resultrate.setText("Good Job");
                } else if (answerValue.equals("4")){
                    charPlace.setImageResource(R.drawable.fourstarsprite);
                    resultrate.setText("Good Job");
                } else if (answerValue.equals("5")){
                    charPlace.setImageResource(R.drawable.fivestartsprite);
                    resultrate.setText("Awesome.");
                } else {
                    Toast.makeText(getApplicationContext(), "No Point", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //import font
        Typeface M1 = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Black.ttf");
        Typeface M2 = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Medium.ttf");

        //customize fonts
        titlerate.setTypeface(M1);
        resultrate.setTypeface(M2);
        btnfeedback.setTypeface(M1);
    }
}
