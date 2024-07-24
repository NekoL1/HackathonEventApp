package com.example.hackathon_event;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class RegisterFragment2 extends Fragment {

    private EditText idEditText, emailEditText, phoneEditText, cityEditText;
    private Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register2, container, false);

        idEditText = view.findViewById(R.id.idEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        phoneEditText = view.findViewById(R.id.phoneEditText);
        cityEditText = view.findViewById(R.id.cityEditText);
        nextButton = view.findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String city = cityEditText.getText().toString();

                Bundle bundle = getArguments();
                if (bundle != null) {
                    bundle.putString("id", id);
                    bundle.putString("email", email);
                    bundle.putString("phone", phone);
                    bundle.putString("city", city);
                }

               
            }
        });

        return view;
    }
}