package com.example.maxwell.sharpy;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Random;

public class Play extends AppCompatActivity {

    private TextView txt;
    private TextView txtQuestion;
    private TextView score;
    private TextView txtIterate;
    int a,b,c;
    double af,bf,cf;
    private Button btn1,btn2,btn3,btn4;
    String buttonText;
    static double fa,fb,fc,fd;
    int[] optFinal;
    int operator = (int) (Math.random() * 4) + 1;
    int ca = 0;
    String question;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        txtQuestion = (TextView) findViewById(R.id.textQuestion);
        score = (TextView) findViewById(R.id.textScore);
        txt = (TextView) findViewById(R.id.textTimer);
        btn1 = (Button)findViewById(R.id.button2);
        btn2 = (Button)findViewById(R.id.button3);
        btn3 = (Button)findViewById(R.id.button4);
        btn4 = (Button)findViewById(R.id.button5);
        txtIterate = (TextView)findViewById(R.id.tvIterate);

        Bundle extras = getIntent().getExtras();
        String time = extras.getString("key");

      final CountDownTimer cdt =  new CountDownTimer(Long.parseLong(time), 1000) {

            public void onTick(long millisUntilFinished) {
                txt.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                fail();
            }
        }.start();


             quest();
        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buttonText = String.valueOf(ca);
                        if (buttonText.equals(btn1.getText().toString()))
                        {
                            quest();
                            cdt.cancel();
                            cdt.start();
                            addScore();
                        }
                        else
                        {
                            fail();
                        }

                    }
                }
        );

        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buttonText = String.valueOf(ca);
                        if (buttonText.equals(btn2.getText().toString()))
                        {
                            quest();
                            cdt.cancel();
                            cdt.start();
                            addScore();
                        }
                        else
                        {
                            fail();
                        }

                    }
                }
        );

        btn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buttonText = String.valueOf(ca);
                        if (buttonText.equals(btn3.getText().toString()))
                        {
                            quest();
                            cdt.cancel();
                            cdt.start();
                            addScore();
                        }
                        else
                        {
                            fail();
                        }

                    }
                }
        );

        btn4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buttonText = String.valueOf(ca);
                        if (buttonText.equals(btn4.getText().toString()))
                        {
                            quest();
                            cdt.cancel();
                            cdt.start();
                            addScore();
                        }
                        else
                        {
                            fail();
                        }

                    }
                }
        );


    }



    public  void getOption(int min, int max, int exclude) {
        //double opt ;
        min = min - 3;
        max = max + 2;
        Random rn = new Random();
        a = rn.nextInt(max - min + 1) + min;
        b = rn.nextInt(max - min + 1) + min;
        c = rn.nextInt(max - min + 1) + min;
        if (a==b || a==c || a==exclude)
        {
            a = rn.nextInt(max - min + 1) + min;
        }
       else if (b==a || b==c || b==exclude)
        {
            b = rn.nextInt(max - min + 1) + min;
        }
       else if (c==a || c==b || c==exclude)
        {
            c = rn.nextInt(max - min + 1) + min;
        }

    }

    public  void getOption(double min, double max, double exclude) {
        //double opt ;
        Random r = new Random();
        min = min - 2;
        max = max + 2;
        af = r.nextDouble()*(max-min) + min;
        bf = r.nextDouble()*(max-min) + min;
        cf = r.nextDouble()*(max-min) + min;
        if (af==bf || af==cf || af==exclude)
        {
            af = r.nextDouble()*(max-min) + min;
        }
        if (bf==af || bf==cf || bf==exclude)
        {
            bf = r.nextDouble()*(max-min) + min;
        }
        if (cf==af || cf==bf || cf==exclude)
        {
            cf = r.nextDouble()*(max-min) + min;
        }

    }

    // swap array elements i and j
    public void exchange(int[] a, int i, int j)
    {
        int temp =a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public  void  shuffle(int[] a)
    {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for(int i = 0; i < n; i++)
        {
            int change =i + random.nextInt(n - i);
            exchange(a,i,change);
        }
    }

    public void show(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {

            btn1.setText(String.valueOf(a[0]));
            btn2.setText(String.valueOf(a[1]));
            btn3.setText(String.valueOf(a[2]));
            btn4.setText(String.valueOf(a[3]));
        }
    }

    //
    //
    // For float values...................................................................
    //
    // swap array elements i and j
    public static void exchange(double[] a, int i, int j)
    {
        double temp =a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static  void  shuffle(double[] a)
    {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for(int i = 0; i < n; i++)
        {
            int change =i + random.nextInt(n - i);
            exchange(a,i,change);
        }
    }

    public void show(double[] a)
    {
        for (int i = 0; i < a.length; i++)
        {

            btn1.setText(String.valueOf(a[0]));
            btn2.setText(String.valueOf(a[1]));
            btn3.setText(String.valueOf(a[2]));
            btn4.setText(String.valueOf(a[3]));
        }
    }

    public void onClick(View v)
    {
        AlertDialog.Builder ab = new AlertDialog.Builder(Play.this);
        ab.setMessage("Do you want to restart this app!! ")
                .setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = ab.create();
        alert.setTitle("Restart!!!");
        alert.show();

    }

    public void fail()
    {
        AlertDialog.Builder ab = new AlertDialog.Builder(Play.this);
        ab.setMessage("Your score is : "+ onGameOver() +"\n restart game!! ")
                .setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent myI = new Intent(Play.this, MainActivity.class);
                        myI.putExtra("HighestScore", onGameOver());
                        setResult(Activity.RESULT_OK, myI);
                        finish();
                        startActivity(myI);
                    }
                });
        AlertDialog alert = ab.create();
        alert.setTitle("Game Over!!!");
        alert.show();
    }

    public void quest()
    {
                String operatorSwitch;
                int ba;


                Random number = new Random();
                int d = number.nextInt(25) + 1;
                int e = number.nextInt(25) + 1;

                Random operatorChoice = new Random();
                operator = operatorChoice.nextInt(4);

                switch (operator) {
                    case 0:
                        operatorSwitch = "+";
                        ca = d + e;
                        question ="" + d + operatorSwitch + e + "";
                        break;
                    case 1:
                        operatorSwitch = "-";
                        ca = d - e;
                        question ="" + d + operatorSwitch + e + "";
                        break;
                    case 2:
                        operatorSwitch = "*";
                        ca = d * e;
                        question ="" + d + operatorSwitch + e + "";
                        break;
                    case 3:
                        operatorSwitch = "/";
                        ca = d / e;
                        if (d > e) {
                            ca = d / e;
                            question ="" + d + operatorSwitch + e + "";
                        } else {
                            ca =  e / d;
                            question ="" + e + operatorSwitch + d + "";
                        }
                        break;
                    default:
                        operatorSwitch = "";
                }

                txtQuestion.setText(question);
                getOption(ca, ca, ca);
                optFinal = new int[]{ca, a, b, c};
                shuffle(optFinal);
                show(optFinal);
                score.setText(String.valueOf(ca));


    }

    public void addScore()
    {
        i++;
        txtIterate.setText(String.valueOf(i));
    }

    public String onGameOver()
    {
       // String res = txtIterate.getText().toString();
        Bundle extras = getIntent().getExtras();
        String perc = extras.getString("scoreCard");
        int tot = Integer.valueOf(perc) * Integer.valueOf(txtIterate.getText().toString());
        return String.valueOf(tot);
    }

}




