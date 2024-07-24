package com.example.hackathon_event;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class RegisterFragment1 extends Fragment {

    private EditText nameEditText;
    private Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register1, container, false);

        nameEditText = view.findViewById(R.id.nameEditText);
        nextButton = view.findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();

                Bundle bundle = new Bundle(); //created to store the retrieved name.
                bundle.putString("name", name);

                RegisterFragment2 registerFragment2 = new RegisterFragment2();
                registerFragment2.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .replace(R.id.container, registerFragment2)
                        .addToBackStack(null) //called to add the transaction to the back stack, allowing the user to navigate back.
                        .commit();
            }
        });

        return view;
    }
}