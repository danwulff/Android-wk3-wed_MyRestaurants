package com.epicodus.myrestaurants;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindRestaurantsButton;
    private EditText mLocationEditText;

    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //custom font
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface pacifico = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        mAppNameTextView.setTypeface(pacifico);

        mLocationEditText = (EditText) findViewById(R.id. locationEditText);
        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = mLocationEditText.getText().toString();

                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
