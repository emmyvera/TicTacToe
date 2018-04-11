package com.example.emmyvera.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Thanks Immanuel
 */


public class MainActivity extends AppCompatActivity {

    private TicTacToe mGame;
    private Button mBoardButtons[];

    private TextView humanScore;
    private TextView tieScore;
    private TextView andyScore;

    private int hScore = 0;
    private int tScore = 0;
    private int aScore = 0;

    private boolean humanFirst = true;
    private boolean gameOver = false;

    private LinearLayout next;
    private LinearLayout first;

    public void nextPage(View view){
        first.setVisibility(View.GONE);
        next.setVisibility(View.VISIBLE);

    }

    public void startGame3(View view){

        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(i);

    }

    public void startGame4(View view){

        Intent n = new Intent(getApplicationContext(), Main3Activity.class);
        startActivity(n);
    }

    public void startGame5(View view){

        Intent f = new Intent(getApplicationContext(),Main5Activity.class);
        startActivity(f);
    }

    public void credit(View view){
        Intent t = new Intent(getApplicationContext(), Main4Activity.class);
        startActivity(t);

    }

    public void comingSoon(View view){
        Intent h = new Intent(getApplicationContext(), ComingSoonActivity.class);
        startActivity(h);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (LinearLayout)findViewById(R.id.nextPage);
        first = (LinearLayout)findViewById(R.id.firstPage);
    }
}
