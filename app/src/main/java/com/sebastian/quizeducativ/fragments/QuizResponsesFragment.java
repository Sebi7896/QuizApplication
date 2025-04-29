package com.sebastian.quizeducativ.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sebastian.quizeducativ.R;
import com.sebastian.quizeducativ.model.QuizModel;
import com.sebastian.quizeducativ.model.QuizResponseAdapter;

import java.util.ArrayList;
import java.util.List;


public class QuizResponsesFragment extends Fragment {

    public static final String ARG_QUIZ_RESPONSE_LIST = "quiz_response_list";
    QuizResponseAdapter adapter;
    List<QuizModel> quizModelList;

    public QuizResponsesFragment() {
        // Required empty public constructor
    }

    public static QuizResponsesFragment newInstance(List<QuizModel> quizModelList) {
        QuizResponsesFragment fragment = new QuizResponsesFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_QUIZ_RESPONSE_LIST,(ArrayList<QuizModel>) quizModelList);
        fragment.setArguments(bundle);
        return fragment;
    }

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

        View view = inflater.inflate(R.layout.fragment_quiz_responses, container, false);
        ListView listView = view.findViewById(R.id.iacob_sebastian_quiz_responses_list_view);
        adapter = new QuizResponseAdapter(view.getContext(),R.layout.quiz_response_item,quizModelList);
        listView.setAdapter(adapter);
        return view;
    }
}