package com.example.ieapp;

public class QuestionLibrary {
        private static String[] mfilename = {"0","Question 1.txt","Question 2.txt","Question 3.txt"};

        public static String getQuestionFile(int a) {
            return mfilename[a];
        }
}
