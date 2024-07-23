package com.example.hackathon_event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private ProgressBar progressBar;
    private EditText numberInput;
    private Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        progressBar = view.findViewById(R.id.progressBar);
        numberInput = view.findViewById(R.id.number_input);
        submitButton = view.findViewById(R.id.submit_button);

        // Set  min and max values
        progressBar.setMin(0); // set min value
        progressBar.setMax(50); // set max value

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = numberInput.getText().toString();
                if (!inputText.isEmpty()) {
                    int progress = Integer.parseInt(inputText);
                    // Ensure the progress value is within the set range
                    if (progress >= progressBar.getMin() && progress <= progressBar.getMax()) {
                        progressBar.setProgress(progress);
                    }
                }
            }
        });
        return view;
    }
}
