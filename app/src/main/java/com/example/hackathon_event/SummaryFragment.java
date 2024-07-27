package com.example.hackathon_event;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SummaryFragment extends Fragment {
    private TextView summaryTextView;
    private Button backButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        summaryTextView = view.findViewById(R.id.summaryTextView);
        backButton = view.findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the RegisterFragment directly
                ((MainActivity) requireActivity()).bottomNavigationView.setSelectedItemId(R.id.register);
            }
        });

        

        return view;
    }
}
