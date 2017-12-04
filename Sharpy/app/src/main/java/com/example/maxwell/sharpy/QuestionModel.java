package com.example.maxwell.sharpy;

import java.util.Random;

/**
 * Created by Maxwell on 07/08/2017.
 */

public class QuestionModel {

     public  String generateQuestion(){
          String[] mathOperator   =  {"+" , "-" ,"*" ,"/"} ;
         int firstPart  = 1 + new Random().nextInt(10)  ;
         int secondPart   = 1 + new  Random().nextInt(10)  ;
           return   firstPart + " " + mathOperator[1+
                   new  Random().nextInt(mathOperator.length)] + " " + secondPart ;
     }
}
