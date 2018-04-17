package com.example.emmyvera.tictactoe;


import java.util.Random;

/**
 * Thanks Immanuel
 * Thanks Faithfulness
 * Created by EmmyVera on 3/31/2018.
 */

/**
 * Note: Almost all or All the Comment on TicTacToe.java applies here
 * Only the computer does not make moves here
 * So Cool!!!
 */

public class TicTacToe_4 {

    private char mBoard[];
    private final static int boardSize = 16;

    public static final char playerX = 'X';
    public static final char playerO = 'O';
    public static final char emptySpace = ' ';
    

    private Random random;

    public static int getBoardSize() {

        return boardSize;
    }

    public TicTacToe_4(){

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
        for (int i = 0; i <= 12; i += 4 ){
            if (mBoard[i] == playerX &&
                    mBoard[i+1] == playerX&&
                    mBoard[i+2] == playerX &&
                    mBoard[i+3] == playerX)
                return 2;
            if (mBoard[i] == playerO &&
                    mBoard[i+1] == playerO&&
                    mBoard[i+2] == playerO &&
                    mBoard[i+3] == playerO)
                return 3;

        }

        // Check For Vertical Winning
        for (int i = 0; i <= 3; i++){
            if (mBoard[i] == playerX &&
                    mBoard[i+4] == playerX&&
                    mBoard[i+8] == playerX &&
                    mBoard[i+12] == playerX)
                return 2;
            if (mBoard[i] == playerO &&
                    mBoard[i+4] == playerO &&
                    mBoard[i+8] == playerO &&
                    mBoard[i=12] == playerO)
                return 3;

        }

        // Check For Diagonal Winning
        if ((mBoard[0] == playerX &&
                mBoard[5] == playerX &&
                mBoard[10] == playerX &&
                mBoard[15] == playerX) ||
                (mBoard[3] == playerX &&
                        mBoard[6] == playerX &&
                        mBoard[9] == playerX &&
                        mBoard[12] == playerX))
            return 2;

        if ((mBoard[0] == playerO &&
                mBoard[5] == playerO &&
                mBoard[10] == playerO &&
                mBoard[15] == playerO) ||
                (mBoard[3] == playerO &&
                        mBoard[6] == playerO &&
                        mBoard[9] == playerO &&
                        mBoard[12] == playerO))
            return 3;

        // Check For Ties
        for (int i = 0; i < getBoardSize(); i++){
            if (mBoard[i] != playerX && mBoard[i] != playerO)
                return 0;
        }
        return 1;
    }

}
