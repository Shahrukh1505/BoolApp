package com.example.boolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.boolapp.databinding.ActivityMainBinding;
import com.example.boolapp.model.Question;
import com.google.android.material.snackbar.Snackbar;

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
private int currentQuestionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        binding.questionTextView.setText(questionBank[0].getAnswerResId());
  binding.trueButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          checkAnswer(true);
      }
  });
  binding.falseButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          checkAnswer(false);
      }
  });
        binding.nextButton.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        currentQuestionIndex = (currentQuestionIndex + 1)%questionBank.length; //incrementing
        updateQuestion();

    }
});
binding.prevButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //decrementing
        if(currentQuestionIndex > 0){
            currentQuestionIndex = (currentQuestionIndex - 1)%questionBank.length;
       updateQuestion();
        }
    }
});

    }
    private void checkAnswer(boolean userChoseCorrect){
        boolean answerIsCorrect = questionBank[currentQuestionIndex].isAnswerTrue();
        int messageId;

        if(answerIsCorrect == userChoseCorrect){
            messageId = R.string.correct;
        }
        else{
            messageId = R.string.wrong;
        }
        Snackbar.make(binding.imageView, messageId,Snackbar.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        binding.questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }
}