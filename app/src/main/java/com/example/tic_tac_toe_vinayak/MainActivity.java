package com.example.tic_tac_toe_vinayak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean winner=false;
    int imgclicked=-1;
    int player=1;
    int [][]ws={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{6,4,2}};
    int []gs={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load (View view)
    {
        ImageView v=(ImageView) view;
        int tag= Integer.parseInt(v.getTag().toString());
        imgclicked=gs[tag];
        if(winner==false && imgclicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                Toast.makeText(this, tag + " " + " Cross", Toast.LENGTH_SHORT).show();
                gs[tag] = player;
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                Toast.makeText(this, tag + " " + " Zero", Toast.LENGTH_SHORT).show();
                gs[tag] = player;
                player = 1;
            }
            for (int i = 0; i < ws.length; i++) {
                if (gs[ws[i][0]] == gs[ws[i][1]] && gs[ws[i][1]] == gs[ws[i][2]] && gs[ws[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    winner=true;
                }
            }
        }
    }
    public void reset(View view)
    {
        androidx.gridlayout.widget.GridLayout gridlayout = findViewById(R.id.gridlayout);
        int total_images=gridlayout.getChildCount();
        for(int i=0;i<total_images;i++)
        {
            ImageView v= (ImageView) gridlayout.getChildAt(i);
            v.setImageDrawable(null);

        }
        winner=false;
        imgclicked=-1;
        player=1;
        for(int i=0;i<gs.length;i++)
        {
            gs[i]=-1;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}