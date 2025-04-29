package com.sebastian.quizeducativ.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizModel implements Serializable {

    private final String name;
    private  final ArrayList<QuizQuestion> questions;
    private int correctAnswers = 0;
    private int wrongAnswers = 0;
    private final int mileSeconds ;

    public QuizModel(String name,int mileSeconds,  ArrayList<QuizQuestion> questions) {
        this.name = name;
        this.mileSeconds = mileSeconds;
        this.questions = questions;
    }
    public String getName() {
        return name;
    }
    public List<QuizQuestion> getQuestions() {
        return questions;

    }
    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getMileSeconds() {
        return mileSeconds;
    }

}
