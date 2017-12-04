package com.example.maxwell.sharpy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Maxwell on 07/08/2017.
 */

public class SampleLogic  extends AppCompatActivity {
      final  int SIZE  =  4 ;
      private  Button ansButton[] =  new Button[SIZE] ;
      private TextView txtQuestions ;
      private  QuestionModel questions ;
      private  long answer = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
         questions  =  new QuestionModel() ;
          String problem   =  questions.generateQuestion() ;
        problem   = problem.replace("" ," ") ;// replace the single space string
        txtQuestions  =  (TextView)findViewById(R.id.textQuestion) ; //
        txtQuestions.setText(String.valueOf(problem));
         answer  = Integer.parseInt(txtQuestions.getText().toString()) ;
       ansButton[0]  = (Button)findViewById(R.id.button) ;
        ansButton[0].setText(String.format("%s" ,answer));
        ansButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  String check   =  ansButton[0].getText().toString() ;
                   if(check.equalsIgnoreCase(String.valueOf(answer))){
                       txtQuestions.setText(questions.generateQuestion());
                      }
                      else{
                  new  Play().fail();
                         }

        }
           } ) ;

     }
        }





