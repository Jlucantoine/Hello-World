package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button bkgdbttn;
    Button bkgdbttn2;

    //finding and biding for bkgd
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //User can tap to change background colors the label
        bkgdbttn = findViewById(R.id.bkgdbttn);
        bkgdbttn2 = findViewById(R.id.bkgdbttn2);
        layout = findViewById(R.id.RelativeLayout);

        bkgdbttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Reset to default the background color of the label
                findViewById(R.id.RelativeLayout).setBackgroundColor(getResources().getColor(R.color.Azul));
            }
        });


        bkgdbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //change the background color of the label
                layout.setBackgroundColor(Color.CYAN);

            }
        });

        //User can tap on button to set text default color
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change text color to default
                ((TextView) findViewById(R.id.text)).setTextColor(Color.BLACK);
            }
        });

        //User can tap on text color button to change the text color of the label
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change the text color of the label
                ((TextView) findViewById(R.id.text)).setTextColor(getResources().getColor(R.color.yellow));



            }
        });
    }
}