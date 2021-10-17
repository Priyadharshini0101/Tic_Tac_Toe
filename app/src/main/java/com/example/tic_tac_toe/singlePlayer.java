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

public class singlePlayer extends AppCompatActivity {
    private ImageView img0, img1, img2, img3, img4, img5, img6, img7, img8;
    private TextView text;
    private int[] boxes = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    public static int counter = 0;
    private boolean status = true;
    private int[][] winningPosition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}};
    private int[][] loop = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}};
    public boolean loops = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleplayer);

        img0 = (ImageView) findViewById(R.id.zero);
        img1 = (ImageView) findViewById(R.id.one);
        img2 = (ImageView) findViewById(R.id.two);
        img3 = (ImageView) findViewById(R.id.three);
        img4 = (ImageView) findViewById(R.id.four);
        img5 = (ImageView) findViewById(R.id.five);
        img6 = (ImageView) findViewById(R.id.six);
        img7 = (ImageView) findViewById(R.id.seven);
        img8 = (ImageView) findViewById(R.id.eight);
        text = (TextView) findViewById(R.id.turn);
        img0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img0.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img0.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                    counter++;
                    text.setText("Bot's Turn");
                    set();
                    bot();
                }

            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img1.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img1.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                    counter++;
                    text.setText("Bot's Turn");
                    set();
                    bot();
                }


            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img2.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img2.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                    counter++;
                    text.setText("Bot's Turn");
                    set();
                    bot();

                }

            }

        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img3.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img3.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                    text.setText("Bot's Turn");
                    counter++;
                    set();
                    bot();
                }


            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img4.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img4.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                    text.setText("Bot's Turn");
                    counter++;
                    set();
                    bot();

                }


            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img5.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img5.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                }
                text.setText("Bot's Turn");
                counter++;
                set();
                bot();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img6.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img6.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                    text.setText("Bot's Turn");
                    counter++;
                    set();
                    bot();
                }

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img7.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img7.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                    text.setText("Bot's Turn");
                    counter++;
                    set();
                    bot();
                }

            }

        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tappedBoxes = Integer.parseInt(img8.getTag().toString());
                if (boxes[tappedBoxes] == 2 && status) {
                    img8.setImageResource(R.drawable.baseline_panorama_fish_eye_24);
                    boxes[tappedBoxes] = 0;
                    text.setText("Bot's Turn");
                    counter++;
                    set();
                    bot();
                }

            }
        });
    }

    public static boolean win;

     public static boolean done=false;
    public void bot() {
        win = false;
        bots1();
        if (!win&&counter!=8) {
           if(counter==7){
               bots2();
           }
            if ((counter == 3 || counter == 7)) {
                bots2();
                if (counter ==3 && done) {
                    bots3();
                }
                if(counter==7 && done){
                    bots3();
                }
            } else if ((counter == 1) || (counter == 5)) {

                bots3();
            }
        }
    set();
    }

    public void bots1() {
        for (int[] winningPosition : loop) {
            if ((boxes[winningPosition[1]] == 1) && (boxes[winningPosition[2]] == 1) && (boxes[winningPosition[0]] == 2)) {
                if (status) {
                    int j = winningPosition[0];
                    switches(j);
                    boxes[winningPosition[0]] = 1;
                    win = true;
                    done=true;
                }

                break;
            }
            if ((boxes[winningPosition[0]] == 1) && (boxes[winningPosition[2]] == 1) && (boxes[winningPosition[1]] == 2)) {
                if (status) {
                    int j = winningPosition[1];
                    switches(j);
                    boxes[winningPosition[1]] = 1;
                    win = true;
                    done=true;
                }
                break;
            }
            if ((boxes[winningPosition[0]] == 1) && (boxes[winningPosition[1]] == 1) && (boxes[winningPosition[2]] == 2)) {
                if (status) {
                    int j = winningPosition[2];
                    switches(j);
                    boxes[winningPosition[2]] = 1;
                    win = true;
                    done=true;
                }
                break;
            }
        }
    }

    public void bots2() {
        for (int[] winningPosition : loop) {
            if ((boxes[winningPosition[1]] == 0) && (boxes[winningPosition[2]] == 0) && (boxes[winningPosition[0]] == 2)) {
                if (status) {
                    int j = winningPosition[0];
                    switches(j);
                    boxes[winningPosition[0]] = 1;
                    done=true;
                }
                break;
            }
            if ((boxes[winningPosition[0]] == 0) && (boxes[winningPosition[2]] == 0) && (boxes[winningPosition[1]] == 2)) {
                if (status) {
                    int j = winningPosition[1];
                    switches(j);
                    boxes[winningPosition[1]] = 1;
                    done=true;
                }
                break;
            }
            if ((boxes[winningPosition[0]] == 0) && (boxes[winningPosition[1]] == 0) && (boxes[winningPosition[2]] == 2)) {
                if (status) {
                    int j = winningPosition[2];
                    switches(j);
                    boxes[winningPosition[2]] = 1;
                    done=true;
                }
                break;
            }
        }
    }

    public void bots3() {
        for (int[] winningPosition : loop) {
            if (boxes[winningPosition[2]] == 0 && boxes[winningPosition[0]] == 2) {
                if (status) {
                    int j = winningPosition[0];
                    switches(j);
                    boxes[winningPosition[0]] = 1;
                    done=true;
                }
                break;
            }
            if (boxes[winningPosition[0]] == 0 && boxes[winningPosition[1]] == 2) {
                if (status) {
                    int j = winningPosition[1];
                    switches(j);
                    boxes[winningPosition[1]] = 1;
                    done=true;
                }
                break;
            }

            if (boxes[winningPosition[1]] == 0 && boxes[winningPosition[2]] == 2) {
                if (status) {
                    int j = winningPosition[2];
                    switches(j);
                    boxes[winningPosition[2]] = 1;
                    done=true;
                }

                break;
            }
        }


    }


    public void switches(int value) {
        switch (value) {
            case 0:
                img0.setTranslationY(-1000f);
                img0.setImageResource(R.drawable.baseline_close_18);
                img0.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
            case 1:
                img1.setTranslationY(-1000f);
                img1.setImageResource(R.drawable.baseline_close_18);
                img1.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
            case 2:
                img2.setTranslationY(-1000f);
                img2.setImageResource(R.drawable.baseline_close_18);
                img2.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
            case 3:
                img3.setTranslationY(-1000f);
                img3.setImageResource(R.drawable.baseline_close_18);
                img3.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
            case 4:
                img4.setTranslationY(-1000f);
                img4.setImageResource(R.drawable.baseline_close_18);
                img4.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
            case 5:
                img5.setTranslationY(-1000f);
                img5.setImageResource(R.drawable.baseline_close_18);
                img5.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
            case 6:
                img6.setTranslationY(-1000f);
                img6.setImageResource(R.drawable.baseline_close_18);
                img6.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
            case 7:
                img7.setTranslationY(-1000f);
                img7.setImageResource(R.drawable.baseline_close_18);
                img7.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
            case 8:
                img8.setTranslationY(-1000f);
                img8.setImageResource(R.drawable.baseline_close_18);
                img8.animate().translationYBy(1000f).setDuration(300);
                text.setText("Your Turn");
                counter++;
                break;
        }
    }
//    for (int[] winningPosition : winningPosition) {
//
//        if ((boxes[winningPosition[0]] == boxes[winningPosition[1]])  && (boxes[winningPosition[2]] != 2)) {
//
//
//            boxes[winningPosition[2]]=1;
//        }
//    }

    public void reset(View view) {
        if (!status) {
            status = true;
            for (int i = 0; i < boxes.length; i++) {
                boxes[i] = 2;
            }
            if (loops) {
                loop = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}};
                loops = false;
            } else {
                loop = new int[][]{{2, 4, 6}, {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
                loops = true;
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

    public void set() {
        int flag = 0;
        Log.v("singlePlayer", "vanducha");
        for (int[] winningPosition : winningPosition) {

            if ((boxes[winningPosition[0]] == boxes[winningPosition[1]]) && (boxes[winningPosition[1]] == boxes[winningPosition[2]]) && (boxes[winningPosition[0]] != 2)) {
                flag = 1;
                counter = 0;
                status = false;
                if (boxes[winningPosition[0]] == 0) {
                    TextView result = (TextView) findViewById(R.id.winorlose);
                    result.setText("O won");
                } else {
                    TextView result = (TextView) findViewById(R.id.winorlose);
                    result.setText("X won");
                }
            }
            if (counter == 9 && flag == 0) {
                counter = 0;
                status = false;
                TextView result = (TextView) findViewById(R.id.winorlose);
                result.setText("Draw");
            }
        }

    }
}





