package com.example.toppersacademyapp.Model;

public class Question {

    private String mQuestion;
    private String mAnswer;

    private boolean expandeBtn;

    public Question() {
    }

    public Question(String mQuestion, String mAnswer) {
        this.mQuestion = mQuestion;
        this.mAnswer = mAnswer;
        this.expandeBtn = false;
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public String getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(String mAnswer) {
        this.mAnswer = mAnswer;
    }

    public boolean isExpandeBtn() {
        return expandeBtn;
    }

    public void setExpandeBtn(boolean expande) {
        this.expandeBtn = expande;
    }
}

