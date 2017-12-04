package com.example.maxwell.sharpy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spin;
    private Button btn;
    private String time;
    private TextView hs;
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] data ={"Level 1","Level 2","Level 3"};
        spin = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        spin.setAdapter(adapter);
        btn = (Button)findViewById(R.id.button);
        //hs = (TextView)findViewById(R.id.tvHighScore);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String text = spin.getSelectedItem().toString();
                        if (text.equals("Level 1"))
                        {

                            Intent myI = new Intent(MainActivity.this, Play.class);
                            myI.putExtra("key", "15000");
                            myI.putExtra("scoreCard" , "2");
                            setResult(Activity.RESULT_OK, myI);
                            finish();
                            startActivity(myI);
                        }

                        if (text.equals("Level 2"))
                        {

                            Intent myI = new Intent(MainActivity.this, Play.class);
                            myI.putExtra("key", "10000");
                            myI.putExtra("scoreCard" , "6");
                            setResult(Activity.RESULT_OK, myI);
                            finish();
                            startActivity(myI);
                        }

                        if (text.equals("Level 3"))
                        {

                            Intent myI = new Intent(MainActivity.this, Play.class);
                            myI.putExtra("key", "5000");
                            myI.putExtra("scoreCard" , "10");
                            setResult(Activity.RESULT_OK, myI);
                            finish();
                            startActivity(myI);
                        }
                    }
                }
        );


    }


}
