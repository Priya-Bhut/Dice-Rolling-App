package com.example.dicerollingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView imageview1,imageview2;
    TextView cpu,player;
    Random r;
    Button exit;

    int cpuPoints=0,playerPoints=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview1=(ImageView)findViewById(R.id.imageView);
        imageview2=(ImageView)findViewById(R.id.imageView2);

        cpu=(TextView)findViewById(R.id.textView);
        player=(TextView)findViewById(R.id.textView1);
        exit=(Button)findViewById(R.id.button);
        r=new Random();

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cpuPoints>playerPoints)
                {
                    Toast.makeText(getApplicationContext(),"RESULT :: CPU is Win!!!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"RESULT :: YOU is Win!!!",Toast.LENGTH_SHORT).show();
                }
                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Do you want to exit?");
                builder.setPositiveButton("Yes.Exit Now!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  cpuThrow=r.nextInt(6)+1;
                int  playerThrow=r.nextInt(6)+1;

                setImageview1(cpuThrow);
                setImageview2(playerThrow);

                if(cpuThrow>playerThrow)
                {
                    cpuPoints++;
                }

                if(playerThrow>cpuThrow)
                {
                    playerPoints++;
                }
                if(playerThrow==cpuThrow)
                {
                    Toast.makeText(MainActivity.this,"Draw!!",Toast.LENGTH_SHORT).show();
                }

                cpu.setText("cpu: "+cpuPoints);
                player.setText("YOU: "+playerPoints);

                Animation shake= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);
                imageview1.startAnimation(shake);
                imageview2.startAnimation(shake);
            }
        });
    }


    public void setImageview1(int num)
    {
        switch(num)
        {
            case 1:
                imageview1.setImageResource(R.drawable.dice_1);
                break;

            case 2:
                imageview1.setImageResource(R.drawable.dice_2);
                break;

            case 3:
                imageview1.setImageResource(R.drawable.dice_3);
                break;

            case 4:
                imageview1.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                imageview1.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                imageview1.setImageResource(R.drawable.dice_6);
                break;
        }
    }
    public void setImageview2 (int num)
    {
        switch(num)
        {
            case 1:
                imageview2.setImageResource(R.drawable.dice_1);
                break;

            case 2:
                imageview2.setImageResource(R.drawable.dice_2);
                break;

            case 3:
                imageview2.setImageResource(R.drawable.dice_3);
                break;

            case 4:
                imageview2.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                imageview2.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                imageview2.setImageResource(R.drawable.dice_6);
                break;
        }
    }

}

