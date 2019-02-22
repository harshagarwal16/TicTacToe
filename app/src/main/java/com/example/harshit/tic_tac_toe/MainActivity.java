package com.example.harshit.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;  // Cross
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int tappedCounter= Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2) {
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.cross2);
                activePlayer = 1;
                gameState[tappedCounter]=0;
            } else {
                counter.setImageResource(R.drawable.check_circle_outline_blank_80890);
                activePlayer = 0;
                gameState[tappedCounter]=1;
            }
            counter.animate().translationYBy(0).rotation(360).setDuration(300);
        }

        for(int[] winningPosition: winningPositions) {

            if(gameState[winningPosition[0]]==gameState[winningPosition[1]]&&gameState[winningPosition[1]]==gameState[winningPosition[2]]&&gameState[winningPosition[0]]!=2) {
                System.out.println(gameState[winningPosition[0]]);
                Toast.makeText(MainActivity.this,String.valueOf(gameState[winningPosition[0]]),Toast.LENGTH_LONG).show();
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
