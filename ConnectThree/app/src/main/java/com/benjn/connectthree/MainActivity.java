package com.benjn.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0 = yellow
    //1 = red

    int activePlayer =0;
    boolean gameIsActive = true;

    //2 = unPlayed
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameIsActive) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
        }

        for(int [] wp : winningPositions){
            if(gameState[wp[0]] == gameState[wp[1]] &&
                    gameState[wp[1]] == gameState[wp[2]] &&
                    gameState[wp[0]] != 2){
                //Some has won
                String winner;

                if (gameState[wp[0]] == 0) {
                    winner = "Yellow";
                }else{
                    winner ="Red";
                }

                LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                TextView winText = (TextView) findViewById(R.id.winnerMessage);
                winText.setText(winner +" has won!");
                layout.setVisibility(View.VISIBLE);
                gameIsActive = false;
            } else {
                boolean gameIsTie = true;
                for(int counterState : gameState){
                    if(counterState==2){
                        gameIsTie = false;
                    }
                }

                if(gameIsTie){
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    TextView winText = (TextView) findViewById(R.id.winnerMessage);
                    winText.setText("There was a tie!");
                    layout.setVisibility(View.VISIBLE);
                    gameIsActive = false;
                }
            }
        }
    }

    public void playAgain(View view){
        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        activePlayer =0;

        //2 = unPlayed
        for(int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }

        GridLayout grid = (GridLayout) findViewById(R.id.grid);

        for(int i = 0; i<grid.getChildCount(); i++){
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }

        gameIsActive = true;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
