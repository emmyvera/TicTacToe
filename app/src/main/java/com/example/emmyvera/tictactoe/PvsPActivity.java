package com.example.emmyvera.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PvsPActivity extends AppCompatActivity {

    public void startGame3(View view){
        Intent i = new Intent(getApplicationContext(), PvsP3x3Activity.class);
        startActivity(i);
    }

    public void startGame4(View view){
        Intent f = new Intent(getApplicationContext(), PvsP4x4Activity.class);
        startActivity(f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvs_p);


    }
}
