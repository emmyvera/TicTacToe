package com.example.emmyvera.tictactoe;

import java.util.Random;

/**
 * Thanks Immanuel
 * Thanks Faithfulness
 * Created by EmmyVera on 3/31/2018.
 */

public class TicTacToe_four {

    private char mBoard[];
    private final static int boardSize = 16;

    public static final char humanPlayer = 'X';
    public static final char computerPlayer = 'O';
    public static final char emptySpace = ' ';

    private Random random;

    public static int getBoardSize() {

        return boardSize;
    }

    public TicTacToe_four(){

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

    public int getComputerMove(){
        int move;

        // Look for it winning move
        for (int i = 0; i < getBoardSize(); i++) {
            if (mBoard[i] != humanPlayer && mBoard[i] != computerPlayer) {
                char curr = mBoard[i];
                mBoard[i] = computerPlayer;
                if (checkForWinning() == 3) {
                    setMove(computerPlayer, i);
                    return i;
                } else
                    mBoard[i] = curr;

            }
        }
        //To blocks opponent's move
        for (int i = 0; i < getBoardSize(); i++){
            if (mBoard[i] != humanPlayer && mBoard[i] != computerPlayer){
                char curr = mBoard[i];
                mBoard[i] = humanPlayer;
                if (checkForWinning() == 2){
                    setMove(computerPlayer, i);
                    return i;
                }else
                    mBoard[i] = curr;

            }
        }


        do {
            move = random.nextInt(getBoardSize());
        }while (mBoard[move] == humanPlayer || mBoard[move] == computerPlayer);

        setMove(computerPlayer, move);
        return move;
    }

    /**
     * To check for winning moves
     * @return
     */

    public int checkForWinning(){

        // Check For Horizontal Winning
        for (int i = 0; i <= 12; i += 4 ){
            if (mBoard[i] == humanPlayer &&
                    mBoard[i+1] == humanPlayer&&
                    mBoard[i+2] == humanPlayer &&
                    mBoard[i+3] == humanPlayer)
                return 2;
            if (mBoard[i] == computerPlayer &&
                    mBoard[i+1] == computerPlayer&&
                    mBoard[i+2] == computerPlayer &&
                    mBoard[i+3] == computerPlayer)
                return 3;

        }

        // Check For Vertical Winning
        for (int i = 0; i <= 3; i++){
            if (mBoard[i] == humanPlayer &&
                    mBoard[i+4] == humanPlayer&&
                    mBoard[i+8] == humanPlayer &&
                    mBoard[i+12] == humanPlayer)
                return 2;
            if (mBoard[i] == computerPlayer &&
                    mBoard[i+4] == computerPlayer &&
                    mBoard[i+8] == computerPlayer &&
                    mBoard[i=12] == computerPlayer)
                return 3;

        }

        // Check For Diagonal Winning
        if ((mBoard[0] == humanPlayer &&
                mBoard[5] == humanPlayer &&
                mBoard[10] == humanPlayer &&
                mBoard[15] == humanPlayer) ||
                (mBoard[3] == humanPlayer &&
                        mBoard[6] == humanPlayer &&
                        mBoard[9] == humanPlayer &&
                        mBoard[12] == humanPlayer))
            return 2;

        if ((mBoard[0] == computerPlayer &&
                mBoard[5] == computerPlayer &&
                mBoard[10] == computerPlayer &&
                mBoard[15] == computerPlayer) ||
                (mBoard[3] == computerPlayer &&
                        mBoard[6] == computerPlayer &&
                        mBoard[9] == computerPlayer &&
                        mBoard[12] == computerPlayer))
            return 3;

        // Check For Ties
        for (int i = 0; i < getBoardSize(); i++){
            if (mBoard[i] != humanPlayer && mBoard[i] != computerPlayer)
                return 0;
        }
        return 1;
    }

}



