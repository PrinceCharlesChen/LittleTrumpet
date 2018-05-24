package com.littletrumpet.services;

import org.junit.Test;

/**
 * Created by Administrator on 2017/10/20.
 */
public class Exercise {

//    public void test(Exam exam){
//        exam.score = 100;
//    }

    public void test2(StringBuffer score){
        int lenght = score.length();
        score = score.delete(0,lenght).append("cui");
        System.out.println(score);
    }


    @Test
    public void execute(){
        Exercise exe = new Exercise();
        //Exam exam = new Exam();
        //exam.score = 60;
        StringBuffer score = new StringBuffer("chen di");
        exe.test2(score);
        System.out.print(score);
    }




//    class Exam{
//        int score = 0;
//
//    }

}
