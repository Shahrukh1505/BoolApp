package com.example.boolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.boolapp.databinding.ActivityMainBinding;
import com.example.boolapp.model.Question;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
private Question[] questionBank = new Question[]{

new Question(R.string.first_question,true),
        new Question(R.string.second_question,true),
        new Question(R.string.third_question,false),
        new Question(R.string.fourth_question,true),
        new Question(R.string.fifth_question,true),
        new Question(R.string.sixth_question,false),
        new Question(R.string.seventh_question,false),
        new Question(R.string.eighth_question,false),
        new Question(R.string.ninth_question,true),
        new Question(R.string.tenth_question,false)

};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.questionTextView.setText(questionBank[0].getAnswerResId());

    }
}