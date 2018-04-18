package com.example.emmyvera.tictactoe;

/**
 * Created by EmmyVera on 4/18/2018.
 */

/**
 * Thanks Immanuel
 * Thanks Faithfulness
 * Created by EmmyVera on 3/31/2018.
 */

import java.util.Random;

/**
 * Note: Almost all or All the Comment on TicTacToe.java applies here
 * Only the computer does not make moves here 
 * So Cool!!!
 */

public class TicTacToe_5 {

    private char mBoard[];
    private final static int boardSize = 25;

    public static final char playerX = 'X';
    public static final char playerO = 'O';
    public static final char emptySpace = ' ';


    private Random random;

    public static int getBoardSize() {

        return boardSize;
    }

    public TicTacToe_5(){

        mBoard = new char[boardSize];

        for (int i = 0; i < boardSize; i++)
            mBoard[i] = emptySpace;

        random = new Random();

    }

    public void clearBoard(){

        for (int i =0; i < boardSize; i++) {
            mBoard[i] = emptySpace;
        }
    }

    public void setMove(char player, int location){

        mBoard[location] = player;
    }

    /**
     * Set Computer move
     * @return
     */



    /**
     * To check for winning moves
     * @return
     */

    public int checkForWinning(){

        // Check For Horizontal Winning
        for (int i = 0; i <= 20; i += 5 ){
            if (mBoard[i] == playerX &&
                    mBoard[i+1] == playerX&&
                    mBoard[i+2] == playerX &&
                    mBoard[i+3] == playerX &&
                    mBoard[i+4] == playerX)
                return 2;
            if (mBoard[i] == playerO &&
                    mBoard[i+1] == playerO &&
                    mBoard[i+2] == playerO &&
                    mBoard[i+3] == playerO &&
                    mBoard[i+4] == playerO)
                return 3;

        }

        // Check For Vertical Winning
        for (int i = 0; i <= 4; i++){
            if (mBoard[i] == playerX &&
                    mBoard[i+5] == playerX&&
                    mBoard[i+10] == playerX &&
                    mBoard[i+15] == playerX &&
                    mBoard[i+20] == playerX)
                return 2;
            if (mBoard[i] == playerO &&
                    mBoard[i+5] == playerO &&
                    mBoard[i+10] == playerO &&
                    mBoard[i=15] == playerO &&
                    mBoard[i+20] == playerO)
                return 3;

        }

        // Check For Diagonal Winning
        if ((mBoard[0] == playerX &&
                mBoard[6] == playerX &&
                mBoard[12] == playerX &&
                mBoard[18] == playerX &&
                mBoard[24] == playerX) ||
                (mBoard[4] == playerX &&
                        mBoard[8] == playerX &&
                        mBoard[12] == playerX &&
                        mBoard[16] == playerX &&
                        mBoard[20] == playerX))
            return 2;

        if ((mBoard[0] == playerO &&
                mBoard[6] == playerO &&
                mBoard[12] == playerO &&
                mBoard[18] == playerO &&
                mBoard[24] == playerO) ||
                (mBoard[4] == playerO &&
                        mBoard[8] == playerO &&
                        mBoard[12] == playerO &&
                        mBoard[16] == playerO &&
                        mBoard[20] == playerO))
            return 3;

        // Check For Ties
        for (int i = 0; i < getBoardSize(); i++){
            if (mBoard[i] != playerX && mBoard[i] != playerO)
                return 0;
        }
        return 1;
    }

}

