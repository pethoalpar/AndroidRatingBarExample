package com.pethoalpar.androidratingbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = (RatingBar) this.findViewById(R.id.ratingBar);
        editText = (EditText) this.findViewById(R.id.editText);
        button = (Button) this.findViewById(R.id.button);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),"Rating:"+rating,Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextString = editText.getText().toString();
                if(!editTextString.isEmpty()){
                    try{
                        float number = Float.parseFloat(editTextString);
                        ratingBar.setRating(number);
                    }catch (NumberFormatException nfr){
                        Toast.makeText(getApplicationContext(),"Wrong number format", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
