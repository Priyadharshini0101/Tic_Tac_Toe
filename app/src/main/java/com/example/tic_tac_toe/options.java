package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class options extends AppCompatActivity {
    private Button singlePlayer,multiPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
       singlePlayer=findViewById(R.id.singleplayer);
       multiPlayer=findViewById(R.id.multiplayer);
        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),singlePlayer.class);
                startActivity(intent);
            }
        });
        multiPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Mutliplayer.class);
                startActivity(intent);
            }
        });
    }
}