package com.example.hackathon_event;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FeedbackFragment extends Fragment {
    private EditText feedbackEditText;
    private Button submitFeedbackButton;
    private TextView displayFeedbackTextView;
    private SeekBar textSizeSeekBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        feedbackEditText = view.findViewById(R.id.feedbackEditText);
        submitFeedbackButton = view.findViewById(R.id.submitFeedbackButton);
        displayFeedbackTextView = view.findViewById(R.id.displayFeedbackTextView);
        textSizeSeekBar = view.findViewById(R.id.textSizeSeekBar);

        // click the submit button
        submitFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedbackText = feedbackEditText.getText().toString();
                if (TextUtils.isEmpty(feedbackText)) {
                    Toast.makeText(getContext(), "Please enter feedback", Toast.LENGTH_SHORT).show();
                } else {
                    String currentFeedback = displayFeedbackTextView.getText().toString();
                    String newFeedback = currentFeedback.equals("Thanks for your feedback:") ?
                            feedbackText : currentFeedback + "\n\n" + feedbackText;
                    displayFeedbackTextView.setText(newFeedback);
                    feedbackEditText.setText("");
                }
            }
        });

        // when the SeekBar change
        textSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                feedbackEditText.setTextSize(progress);
                displayFeedbackTextView.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // do nothing
            }
        });
        return view;
    }
}
