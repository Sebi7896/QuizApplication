package com.sebastian.quizeducativ.fragments;

import static com.sebastian.quizeducativ.fragments.QuizResponsesFragment.ARG_QUIZ_RESPONSE_LIST;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.chip.Chip;
import com.google.android.material.imageview.ShapeableImageView;
import com.sebastian.quizeducativ.QuizResolverActivity;
import com.sebastian.quizeducativ.R;
import com.sebastian.quizeducativ.model.QuizModel;
import com.sebastian.quizeducativ.model.QuizModels;

import java.util.ArrayList;
import java.util.List;


public class QuizMainFragment extends Fragment {

    public QuizMainFragment() {
        // Required empty public constructor
    }
    List<QuizModel> quizModelList;
    public static QuizMainFragment newInstance(List<QuizModel> quizModelList) {
        QuizMainFragment fragment = new QuizMainFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_QUIZ_RESPONSE_LIST,(ArrayList<QuizModel>) quizModelList);
        fragment.setArguments(bundle);
        return fragment;
    }
    ActivityResultLauncher<Intent> launcher;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            try {
                quizModelList = (ArrayList<QuizModel>) getArguments().getSerializable(ARG_QUIZ_RESPONSE_LIST);
            }catch (NullPointerException e){
                quizModelList = new ArrayList<>();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_quiz_main, container, false);
        ShapeableImageView easyQuestionsQuiz = view.findViewById(R.id.iacob_sebastian_quiz_main_card_easy_question_button);
        ShapeableImageView mediumQuestionsQuiz = view.findViewById(R.id.iacob_sebastian_quiz_main_card_medium_question_button);
        ShapeableImageView hardQuestionsQuiz = view.findViewById(R.id.iacob_sebastian_quiz_main_card_hard_question_button);
        Chip easyQuizChip = view.findViewById(R.id.iacob_sebastian_easy_quiz_about_chip);
        Chip mediumQuizChip = view.findViewById(R.id.iacob_sebastian_medium_quiz_about_chip);
        Chip hardQuizChip = view.findViewById(R.id.iacob_sebastian_hard_quiz_about_chip);

        String easyQuizAbout = QuizModels.createSimpleQuiz().getQuestions().size() + " questions and " + QuizModels.createSimpleQuiz().getMileSeconds()/1000 + " seconds per question";
        String mediumQuizAbout = QuizModels.createMediumQuiz().getQuestions().size() + " questions and " + QuizModels.createMediumQuiz().getMileSeconds()/1000 + " seconds per question";
        String hardQuizAbout = QuizModels.createHardQuiz().getQuestions().size() + " questions and " + QuizModels.createHardQuiz().getMileSeconds()/1000 + " seconds per question";

        easyQuizChip.setText(easyQuizAbout);
        mediumQuizChip.setText(mediumQuizAbout);
        hardQuizChip.setText(hardQuizAbout);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), o -> {
            requireActivity();
            if(o.getResultCode() == Activity.RESULT_OK){
                assert o.getData() != null;
                QuizModel quizModel = (QuizModel) o.getData().getSerializableExtra(QuizResolverActivity.QUIZ_MODEL_KEY);
                assert quizModel != null;
                quizModelList.add(quizModel);
            }
        });

        easyQuestionsQuiz.setOnClickListener(this::buttonClicked);
        mediumQuestionsQuiz.setOnClickListener(this::buttonClicked);
        hardQuestionsQuiz.setOnClickListener(this::buttonClicked);

        return view;
    }
    public void buttonClicked(View view){
        if(view.getId() == R.id.iacob_sebastian_quiz_main_card_easy_question_button){
            startQuiz(QuizModels.createSimpleQuiz(),view);
        } else if(view.getId() == R.id.iacob_sebastian_quiz_main_card_medium_question_button){
            startQuiz(QuizModels.createMediumQuiz(),view);
        } else if(view.getId() == R.id.iacob_sebastian_quiz_main_card_hard_question_button){
            startQuiz(QuizModels.createHardQuiz(),view);
        }
    }
    public void startQuiz(QuizModel quizModel, View view){
        Intent intent = new Intent(view.getContext(), QuizResolverActivity.class);
        intent.putExtra(QuizResolverActivity.QUIZ_MODEL_KEY,quizModel);
        launcher.launch(intent);
    }

}