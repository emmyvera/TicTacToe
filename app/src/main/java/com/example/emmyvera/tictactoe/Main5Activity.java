package com.example.emmyvera.tictactoe;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    private TicTacToe_five mGame;
    private Button mBoardButtons[];

    private TextView humanScore;
    private TextView tieScore;
    private TextView andyScore;

    private int hScore = 0;
    private int tScore = 0;
    private int aScore = 0;

    private boolean humanFirst = true;
    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mBoardButtons = new Button[mGame.getBoardSize()];
        mBoardButtons[0] = (Button)findViewById(R.id.b0);
        mBoardButtons[1] = (Button)findViewById(R.id.b1);
        mBoardButtons[2] = (Button)findViewById(R.id.b2);
        mBoardButtons[3] = (Button)findViewById(R.id.b3);
        mBoardButtons[4] = (Button)findViewById(R.id.b4);
        mBoardButtons[5] = (Button)findViewById(R.id.b5);
        mBoardButtons[6] = (Button)findViewById(R.id.b6);
        mBoardButtons[7] = (Button)findViewById(R.id.b7);
        mBoardButtons[8] = (Button)findViewById(R.id.b8);
        mBoardButtons[9] = (Button)findViewById(R.id.b9);
        mBoardButtons[10] = (Button)findViewById(R.id.b10);
        mBoardButtons[11] = (Button)findViewById(R.id.b11);
        mBoardButtons[12] = (Button)findViewById(R.id.b12);
        mBoardButtons[13] = (Button)findViewById(R.id.b13);
        mBoardButtons[14] = (Button)findViewById(R.id.b14);
        mBoardButtons[15] = (Button)findViewById(R.id.b15);
        mBoardButtons[16] = (Button)findViewById(R.id.b16);
        mBoardButtons[17] = (Button)findViewById(R.id.b17);
        mBoardButtons[18] = (Button)findViewById(R.id.b18);
        mBoardButtons[19] = (Button)findViewById(R.id.b19);
        mBoardButtons[20] = (Button)findViewById(R.id.b20);
        mBoardButtons[21] = (Button)findViewById(R.id.b21);
        mBoardButtons[22] = (Button)findViewById(R.id.b22);
        mBoardButtons[23] = (Button)findViewById(R.id.b23);
        mBoardButtons[24] = (Button)findViewById(R.id.b24);

        humanScore = (TextView)findViewById(R.id.humanScore);
        tieScore = (TextView)findViewById(R.id.tiesScore);
        andyScore = (TextView)findViewById(R.id.andyScore);

        //humanScore.setText(String.valueOf(hScore));
        humanScore.setText(Integer.toString(hScore));
        tieScore.setText(Integer.toString(tScore));
        andyScore.setText(Integer.toString(aScore));

        mGame = new TicTacToe_five();

        startGame();

    }

    private void startGame() {
        mGame.clearBoard();

        for (int i = 0; i < mBoardButtons.length; i++) {

            mBoardButtons[i].setText("");
            mBoardButtons[i].setEnabled(true);
            mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));

        }

        if (humanFirst) {
            humanFirst = false;
        } else {
            int move = mGame.getComputerMove();
            setMove(mGame.computerPlayer, move);
            humanFirst = true;
        }

        gameOver = false;
    }

    private class ButtonClickListener implements View.OnClickListener{
        int location;
        public ButtonClickListener(int location){
            this.location = location;
        }

        public void onClick(View view){
            if (!gameOver){
                if (mBoardButtons[location].isEnabled()){
                    setMove(mGame.humanPlayer, location);
                    int winner = mGame.checkForWinning();
                    if (winner == 0){
                        int move = mGame.getComputerMove();
                        setMove(mGame.computerPlayer, move);
                        winner = mGame.checkForWinning();
                    }

                    if (winner == 1){
                        tScore++;
                        tieScore.setText(Integer.toString(tScore));
                        gameOver = true;
                    }
                    else if (winner == 2){
                        hScore++;
                        humanScore.setText(Integer.toString(hScore));
                        gameOver = true;
                    }
                    else if (winner == 3){
                        aScore++;
                        andyScore.setText(Integer.toString(aScore));
                        gameOver = true;
                    }

                    if (gameOver){
                        if (winner == 2){
                            Toast.makeText(getApplicationContext(), "You Won", Toast.LENGTH_SHORT).show();
                        }

                        if (winner == 3){
                            Toast.makeText(getApplicationContext(),"Andy Won",Toast.LENGTH_SHORT).show();
                        }

                        if (winner == 1){
                            Toast.makeText(getApplicationContext(),"It's a Draw",Toast.LENGTH_SHORT).show();
                        }
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startGame();
                            }
                        }, 3000);
                    }

                }


            }
        }
    }

    private void setMove(char player, int location){
        mGame.setMove(player, location);
        mBoardButtons[location].setEnabled(false);
        mBoardButtons[location].setText(String.valueOf(player));
        if (player == mGame.computerPlayer)
            mBoardButtons[location].setTextColor(Color.BLUE);
        else
            mBoardButtons[location].setTextColor(Color.RED);
    }

    public void reset(View view){
        aScore = 0;
        hScore = 0;
        tScore = 0;
        andyScore.setText(Integer.toString(aScore));
        tieScore.setText(Integer.toString(tScore));
        humanScore.setText(Integer.toString(hScore));
        startGame();
    }
}
