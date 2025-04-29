package com.sebastian.quizeducativ;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sebastian.quizeducativ.model.QuizModel;
import com.sebastian.quizeducativ.model.QuizQuestion;

import java.util.Collections;
import java.util.List;

public class QuizResolverActivity extends AppCompatActivity {

    public static final String QUIZ_MODEL_KEY = "quiz_model";
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private Button nextQuestionButton;

    //pentru final
    private ImageView gradeImageView;
    private TextView correctAnswersTextView;
    private ProgressBar correctanswersProgressBar;
    private TextView wrongAnswersTextView;
    private ProgressBar wrongAnswersProgressBar;
    private Button finishButton;

    private final int secondsForQuestionResponse = 5000;
    private final Handler handler = new Handler();

    private QuizModel quizModel;
    private List<QuizQuestion> quizQuestions;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_rezolver);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        intent = getIntent();
        quizModel = (QuizModel) intent.getSerializableExtra(QUIZ_MODEL_KEY);
        getOnBackPressedDispatcher().addCallback(this, callback);

        initComponents();
        nextQuestionButton.setOnClickListener(v -> nextQuestionOnClickedButton());
        finishButton.setOnClickListener(v -> {
            intent.putExtra(QUIZ_MODEL_KEY, quizModel);
            setResult(RESULT_OK, intent);
            finish();
        });

        //le punem intr o ordine aleatoare
        Collections.shuffle(quizModel.getQuestions());
        quizQuestions = quizModel.getQuestions();
        updateQuestionComponents();

        handler.postDelayed(responeRunnable, quizModel.getMileSeconds());
        handler.postDelayed(questionRunnable,quizModel.getMileSeconds() + secondsForQuestionResponse);
    }
    public void initComponents() {
        questionTextView = findViewById(R.id.iacob_sebastian_quiz_question_text_view);
        radioGroup = findViewById(R.id.iacob_sebastian_radio_group_quiz);
        nextQuestionButton = findViewById(R.id.iacob_sebastian_next_question_button);
        gradeImageView = findViewById(R.id.iacob_sebastian_image_view_grade);
        correctAnswersTextView = findViewById(R.id.iacob_sebastian_quiz_correct_answers_text_view);
        correctanswersProgressBar = findViewById(R.id.iacob_sebastian_quiz_correct_answers_progress_bar);
        wrongAnswersTextView = findViewById(R.id.iacob_sebastian_quiz_wrong_answers_text_view);
        wrongAnswersProgressBar = findViewById(R.id.iacob_sebastian_quiz_wrong_answers_progress_bar);
        finishButton = findViewById(R.id.iacob_sebastian_quiz_finish_button);
    }
    //Question Runner
    private int currentQuestionIndex = 0;
    public void proceedToTheNextQuestion() {
        nextQuestionButton.setEnabled(true);
        updateScore(radioGroup.getCheckedRadioButtonId());
        if (++currentQuestionIndex < quizQuestions.size()) {
            updateQuestionComponents();
            handler.postDelayed(responeRunnable,quizModel.getMileSeconds());
            handler.postDelayed(questionRunnable, quizModel.getMileSeconds() + secondsForQuestionResponse);
        }else {
            endQuiz();
        }
    }

    public final Runnable questionRunnable = this::proceedToTheNextQuestion;
    public final Runnable responeRunnable = this::setQuestionAnswerColor;
    private void nextQuestionOnClickedButton() {
        handler.removeCallbacks(questionRunnable);
        handler.removeCallbacks(responeRunnable);

        setQuestionAnswerColor();
        handler.postDelayed(this::proceedToTheNextQuestion, secondsForQuestionResponse);
    }

    public void updateScore(int idSelectedButton) {
        if(idSelectedButton!=-1 && ((RadioButton)findViewById(idSelectedButton)).getText().toString().compareTo(quizQuestions.get(currentQuestionIndex).getAnswer())==0){
            quizModel.setCorrectAnswers(quizModel.getCorrectAnswers()+1);
        }else {
            quizModel.setWrongAnswers(quizModel.getWrongAnswers()+1);
        }
    }
    //Layout update pentru radio button
    public void updateQuestionComponents() {
        //if ul este pentru primul element sa nu intre daca avem 0 intrebari
        if (currentQuestionIndex < quizQuestions.size()) {
            radioGroup.clearCheck();
            resetQuestionComponentsColor();
            QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);
            updateComponentsText(currentQuestion);
        }
    }
    public void updateComponentsText(QuizQuestion currentQuestion) {
        questionTextView.setText(currentQuestion.getQuestion());
        switchRadioButtonText((RadioButton) radioGroup.getChildAt(0),currentQuestion.getOption1());
        switchRadioButtonText((RadioButton) radioGroup.getChildAt(1),currentQuestion.getOption2());
        switchRadioButtonText((RadioButton) radioGroup.getChildAt(2),currentQuestion.getOption3());
        switchRadioButtonText((RadioButton) radioGroup.getChildAt(3),currentQuestion.getOption4());
    }
    public void switchRadioButtonText(RadioButton radioButton,String text) {
        radioButton.setText(text);
    }
    public void endQuiz() {
        handler.removeCallbacks(questionRunnable);
        questionTextView.setVisibility(View.GONE);
        radioGroup.setVisibility(View.GONE);
        nextQuestionButton.setVisibility(View.GONE);
        int totalQuestions = quizQuestions.size();
        int correctAnswers = quizModel.getCorrectAnswers();
        int wrongAnswers = quizModel.getWrongAnswers();
        int progress = (int) (((float) correctAnswers / totalQuestions) * 100);

        gradeImageView.setVisibility(View.VISIBLE);
        correctAnswersTextView.setVisibility(View.VISIBLE);
        correctanswersProgressBar.setVisibility(View.VISIBLE);
        wrongAnswersTextView.setVisibility(View.VISIBLE);
        wrongAnswersProgressBar.setVisibility(View.VISIBLE);
        finishButton.setVisibility(View.VISIBLE);

        String correctAnswersText = "Correct answers " + correctAnswers + "/" + totalQuestions;
        String wrongAnswersText = "Wrong answers " + wrongAnswers + "/" + totalQuestions;
        correctAnswersTextView.setText(correctAnswersText);
        correctanswersProgressBar.setProgress(progress);
        wrongAnswersTextView.setText(wrongAnswersText);
        wrongAnswersProgressBar.setProgress(100-progress);

        if (progress > 80) {
            gradeImageView.setImageResource(R.drawable.happy_face);
        } else if (progress > 40) {
            gradeImageView.setImageResource(R.drawable.neutral_face);
        }else {
            gradeImageView.setImageResource(R.drawable.sad_face);
        }
    }

    OnBackPressedCallback callback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            handler.removeCallbacks(responeRunnable);
            handler.removeCallbacks(questionRunnable);
            finish();
        }
    };

    //set Correct Answer with colors
    @SuppressLint("UseCompatLoadingForDrawables")
    public void setQuestionAnswerColor() {
        disableComponents();
        //coloram radio buttonul cu raspunsul corect si celelalte gresite
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            if (((RadioButton) radioGroup.getChildAt(i)).getText().toString().compareTo(quizQuestions.get(currentQuestionIndex).getAnswer()) == 0)
                setDrawableRadioButton(i,getDrawable(R.drawable.radio_button_drawable_correct));
            else
                setDrawableRadioButton(i, getDrawable(R.drawable.radio_button_drawable_wrong));
        }

    }
    public void disableComponents() {
        nextQuestionButton.setEnabled(false);
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            if (i != radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId())))
                radioGroup.getChildAt(i).setEnabled(false);
        }
    }

    public void resetQuestionComponentsColor() {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            setColorRadioButton(i, Color.TRANSPARENT);//2962
            radioGroup.getChildAt(i).setEnabled(true);
        }
    }

    public void setColorRadioButton(int id,int color) {
        radioGroup.getChildAt(id).setBackgroundColor(color);
    }
    public void setDrawableRadioButton(int id, Drawable drawable) {
        radioGroup.getChildAt(id).setBackground(drawable);
    }
}