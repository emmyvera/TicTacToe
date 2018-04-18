package com.example.emmyvera.tictactoe;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PvsP5x5Activity extends AppCompatActivity {

    private TicTacToe_5 mGame;
    private Button mBoardButtons[];

    private TextView playerXScore;
    private TextView tieScore;
    private TextView playerOScore;
    private TextView xturn;
    private TextView oturn;

    private int xScore = 0;
    private int tScore = 0;
    private int oScore = 0;

    private boolean humanFirst = true;
    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvs_p5x5);

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

        playerXScore = (TextView)findViewById(R.id.playerXScore);
        tieScore = (TextView)findViewById(R.id.tiesScore);
        playerOScore = (TextView)findViewById(R.id.playerOScore);

        //playerXScore.setText(String.valueOf(xScore));
        playerXScore.setText(Integer.toString(xScore));
        tieScore.setText(Integer.toString(tScore));
        playerOScore.setText(Integer.toString(oScore));

        mGame = new TicTacToe_5();

        xturn = (TextView)findViewById(R.id.xTurn);
        oturn = (TextView)findViewById(R.id.oTurn);

        startGame();

    }

    private void startGame(){
        mGame.clearBoard();

        for (int i = 0; i < mBoardButtons.length; i++){

            mBoardButtons[i].setText("");
            mBoardButtons[i].setEnabled(true);
            mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));

        }

        if (humanFirst){
            humanFirst = true;

        }else {

            humanFirst = false;
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

                    int winner = mGame.checkForWinning();
                    if (winner == 0){
                        if (humanFirst){
                            setMove(mGame.playerX,location);
                            oturn.setVisibility(View.VISIBLE);
                            xturn.setVisibility(View.INVISIBLE);
                            humanFirst = false;

                        }else {

                            setMove(mGame.playerO,location );
                            xturn.setVisibility(View.VISIBLE);
                            oturn.setVisibility(View.INVISIBLE);
                            humanFirst = true;
                        }
                        winner = mGame.checkForWinning();
                    }

                    if (winner == 1){
                        tScore++;
                        tieScore.setText(Integer.toString(tScore));
                        gameOver = true;
                    }
                    else if (winner == 2){
                        xScore++;
                        playerXScore.setText(Integer.toString(xScore));
                        gameOver = true;
                    }
                    else if (winner == 3){
                        oScore++;
                        playerOScore.setText(Integer.toString(oScore));
                        gameOver = true;
                    }

                    if (gameOver){
                        if (winner == 2){
                            Toast.makeText(getApplicationContext(), "Player X Won", Toast.LENGTH_SHORT).show();
                        }

                        if (winner == 3){
                            Toast.makeText(getApplicationContext(),"Player O Won",Toast.LENGTH_SHORT).show();
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
        if (player == mGame.playerO)
            mBoardButtons[location].setTextColor(Color.BLUE);
        else
            mBoardButtons[location].setTextColor(Color.RED);
    }

    public void reset(View view){
        xScore = 0;
        oScore = 0;
        tScore = 0;
        playerXScore.setText(Integer.toString(xScore));
        tieScore.setText(Integer.toString(tScore));
        playerOScore.setText(Integer.toString(oScore));
        startGame();
    }

}
