package com.sebastian.quizeducativ.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sebastian.quizeducativ.R;

import java.util.List;

public class QuizResponseAdapter extends ArrayAdapter<QuizModel> {
    public List<QuizModel> quizModels;
    private final int resource;
    public QuizResponseAdapter(@NonNull Context context, int resource, @NonNull List<QuizModel> objects) {
        super(context, resource, objects);
        this.resource = resource;
        quizModels = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource,parent,false);
            QuizModel quizModel =  quizModels.get(position);
            TextView name = convertView.findViewById(R.id.iacob_sebastian_mihai_name_quiz);
            name.setText(quizModel.getName());
            TextView correctAnswers = convertView.findViewById(R.id.iacob_sebastian_mihai_correct_answers_text_quiz);
            String correctAnswersText = quizModel.getCorrectAnswers() + "/" + quizModel.getQuestions().size() + " correct";
            correctAnswers.setText(correctAnswersText);
            TextView wrongAnswers = convertView.findViewById(R.id.iacob_sebastian_mihai_wrong_answers_text_quiz);
            String wrongAnswersText = quizModel.getWrongAnswers() + "/" + quizModel.getQuestions().size() + " wrong";
            wrongAnswers.setText(wrongAnswersText);
            int progress = (int) ( ((float) quizModel.getCorrectAnswers()/quizModel.getQuestions().size())*100);
            ProgressBar correctAnswersProgressBar = convertView.findViewById(R.id.iacob_sebastian_quiz_correct_answers_progress_bar_item);
            correctAnswersProgressBar.setProgress(progress);
            ProgressBar wrongAnswersProgressBar = convertView.findViewById(R.id.iacob_sebastian_quiz_wrong_answers_progress_bar_item);
            wrongAnswersProgressBar.setProgress(100 - progress);
            ImageView gradeImageView = convertView.findViewById(R.id.iacob_sebastian_image_view_grade_item);
            if (progress > 80) {
                gradeImageView.setImageResource(R.drawable.happy_face);
            } else if (progress > 40) {
                gradeImageView.setImageResource(R.drawable.neutral_face);
            }else {
                gradeImageView.setImageResource(R.drawable.sad_face);
            }
        }
        return convertView;
    }
}
