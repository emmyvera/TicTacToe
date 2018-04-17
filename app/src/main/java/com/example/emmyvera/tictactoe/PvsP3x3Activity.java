package com.example.emmyvera.tictactoe;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PvsP3x3Activity extends AppCompatActivity {

    // When active player is equal to 0 nut drops, when equal to 1 cross drops
    int activePlayer = 0;

    // 2 rep the 9 counters
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    // setting the winning position
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameIsActive = true;

    int playerX = 0;
    int playerO = 0;
    int tie = 0;


    private TextView playerXScore;
    private TextView playerOScore;
    private TextView tieScore;

    private TextView xTurn;
    private TextView oTurn;



    public void buttonClicked (View view) {


        Button counter = (Button) view;
        System.out.println(counter.getTag().toString());
        int tapedCounter = Integer.parseInt(counter.getTag().toString());


        // This Code listen to taps and begins the game
        if (gameState[tapedCounter] == 2 && gameIsActive) {
            gameState[tapedCounter] = activePlayer;



            if (activePlayer == 0) {
                counter.setText("X");
                counter.setTextColor(Color.RED);
                oTurn.setVisibility(View.VISIBLE);
                xTurn.setVisibility(View.INVISIBLE);
                activePlayer = 1;
            } else {
                counter.setText("O");
                counter.setTextColor(Color.BLUE);
                xTurn.setVisibility(View.VISIBLE);
                oTurn.setVisibility(View.INVISIBLE);
                activePlayer = 0;
            }



            for (int[] winningPosition : winningPositions){
                if(gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 2){

                    if (gameState[winningPosition[1]]==1) {
                        String winner = "Nuts";
                        gameIsActive = false;
                        playerO++;
                        playerOScore.setText(Integer.toString(playerO));
                        Toast.makeText(getApplicationContext(), "Player O Win!", Toast.LENGTH_SHORT).show();
                    }



                    if (gameState[winningPosition[0]]==0){
                        String winner = "Crosses";
                        gameIsActive = false;
                        playerX++;
                        playerXScore.setText(Integer.toString(playerX));
                        Toast.makeText(getApplicationContext(), "Player X Win!", Toast.LENGTH_SHORT).show();

                    }






                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            playAgain();
                        }
                    }, 3000);

                    System.out.println(gameState[winningPosition[0]]);


                }else {
                    boolean gameIsOver =true;
                    for (int counterState:gameState){
                        if (counterState ==2 ) gameIsOver = false;

                    }if (gameIsOver){



                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                playAgain();

                            }
                        }, 3000);
                        System.out.println(gameState[winningPosition[0]]);



                    }


                }


            }

        }
    }




    public void playAgain(){
        gameIsActive = true;


        for (int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }
        GridLayout gripLayout = (GridLayout)findViewById(R.id.gripLayout);

        for (int i = 0; i<gripLayout.getChildCount(); i++){

            ((Button)gripLayout.getChildAt(i)).setText("");
        }
    }

    public void reset(View view){
        playAgain();
        playerX = 0;
        playerO = 0;
        playerXScore.setText(Integer.toString(playerX));
        playerOScore.setText(Integer.toString(playerO));
        xTurn.setVisibility(View.INVISIBLE);
        oTurn.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvs_p3x3);

        playerXScore = (TextView) findViewById(R.id.playerXScore);
        playerOScore = (TextView) findViewById(R.id.playerOScore);
        tieScore = (TextView) findViewById(R.id.tiesScore);

        xTurn = (TextView)findViewById(R.id.xTurn);
        oTurn = (TextView)findViewById(R.id.oTurn);
    }
}
