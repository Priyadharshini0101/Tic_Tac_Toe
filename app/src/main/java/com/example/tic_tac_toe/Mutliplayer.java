package com.example.tic_tac_toe;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class Mutliplayer extends AppCompatActivity {
    private int user1 = 1;
    private Button playAgain;
    private int[] boxes = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    public static int counter = 0;
    private boolean status = true;
    private int[][] winningPosition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer);
        playAgain = (Button) findViewById(R.id.playagain);
    }

    public void reset(View view) {
        if (!status) {
            status = true;
            user1 = 1;
            for (int i = 0; i < boxes.length; i++) {
                boxes[i] = 2;
            }
            ((ImageView) findViewById(R.id.zero)).setImageResource(0);
            ((ImageView) findViewById(R.id.one)).setImageResource(0);
            ((ImageView) findViewById(R.id.two)).setImageResource(0);
            ((ImageView) findViewById(R.id.three)).setImageResource(0);
            ((ImageView) findViewById(R.id.four)).setImageResource(0);
            ((ImageView) findViewById(R.id.five)).setImageResource(0);
            ((ImageView) findViewById(R.id.six)).setImageResource(0);
            ((ImageView) findViewById(R.id.seven)).setImageResource(0);
            ((ImageView) findViewById(R.id.eight)).setImageResource(0);
            TextView turn = (TextView) findViewById(R.id.turn);
            turn.setText("Tap to play");
            TextView result = (TextView) findViewById(R.id.winorlose);
            result.setText(" ");
        }
    }

    public void startToPlay(View view) {
        ImageView img = (ImageView) view;
        TextView turn = (TextView) findViewById(R.id.turn);
        int tappedBoxes = Integer.parseInt(img.getTag().toString());

        if (boxes[tappedBoxes] == 2 && status) {
            counter++;
            boxes[tappedBoxes] = user1;
            if (counter == 9) {
                status = false;
            }
            if (user1 == 1) {
                img.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                user1 = 0;
                turn.setText("X's Turn");
            } else {
                img.setImageResource(R.drawable.baseline_close_18);
                user1 = 1;
                turn.setText("O's Turn");
            }
        }
        int flag = 0;

        for (int[] winningPosition : winningPosition) {

            if ((boxes[winningPosition[0]] == boxes[winningPosition[1]]) && (boxes[winningPosition[1]] == boxes[winningPosition[2]]) && (boxes[winningPosition[0]] != 2)) {
                flag = 1;
                counter = 0;
                status = false;
                if (boxes[winningPosition[0]] == 0) {
                    TextView result = (TextView) findViewById(R.id.winorlose);
                    result.setText("X won");
                } else {
                    TextView result = (TextView) findViewById(R.id.winorlose);
                    result.setText("O won");
                }
            }
            if (counter == 9 && flag == 0) {
                counter = 0;
                TextView result = (TextView) findViewById(R.id.winorlose);
                result.setText("Draw");
            }
        }

    }


}



