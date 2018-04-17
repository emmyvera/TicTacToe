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



    private LinearLayout next;
    private LinearLayout first;


    /**
     * This enable the activity move to another on the player vs computer section
     * It allows the user to select either the 3*3, 4*4, or 5*5 board sizes
     * @param view
     */
    public void nextPage(View view){
        first.setVisibility(View.GONE);
        next.setVisibility(View.VISIBLE);

    }

    /**
     * It allows the user to begin the 3*3 TicTacToe game with the computer
     * @param view
     */

    public void startGame3(View view){

        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(i);

    }

    /**
     * It allows the user to begin the 4*4 TicTacToe game with the computer
     * @param view
     */

    public void startGame4(View view){

        Intent n = new Intent(getApplicationContext(), Main3Activity.class);
        startActivity(n);
    }

    /**
     * It allows the user to begin the 5*5 TicTacToe game with the computer
     * @param view
     */

    public void startGame5(View view){

        Intent f = new Intent(getApplicationContext(),Main5Activity.class);
        startActivity(f);
    }

    /**
     * This shows the activity where the name, email, appreciation and about the game section is
     * @param view
     */

    public void credit(View view){
        Intent t = new Intent(getApplicationContext(), Main4Activity.class);
        startActivity(t);

    }

    /**
     * Well this method was use earlier but is no more in use
     * It shows the coming soon activity
     * @param view
     */

    public void comingSoon(View view){
        Intent h = new Intent(getApplicationContext(), ComingSoonActivity.class);
        startActivity(h);
    }



    /**
     * This enable the activity move to another on the player vs player section
     * It allows the user to select either the 3*3, 4*4, or 5*5 board sizes
     * Users can play with other user
     * @param view
     */

    public void playerVsPlayer(View view){
        Intent p = new Intent(getApplicationContext(), PvsPActivity.class);
        startActivity(p);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (LinearLayout)findViewById(R.id.nextPage); // Allow the user to select different board sizes in the player vs computer section
        first = (LinearLayout)findViewById(R.id.firstPage); // Contain the player vs player, player vs computer and credit
    }
}
