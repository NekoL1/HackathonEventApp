package com.example.hackathon_event;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    private RadioGroup radioGroupExploreBy;
    private TextView textViewList;
    private Switch switchBackground;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        radioGroupExploreBy = view.findViewById(R.id.radioGroupExploreBy);
        textViewList = view.findViewById(R.id.textViewList);
        switchBackground = view.findViewById(R.id.switchBackground);

        radioGroupExploreBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                textViewList.setVisibility(View.VISIBLE);
                if (checkedId == R.id.radioButtonByCity) {
                    populateCityList();
                } else if (checkedId == R.id.radioButtonByField) {
                    populateFieldList();
                }
            }
        });

        switchBackground.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    view.setBackgroundColor(Color.parseColor("#B39DDB")); // Custom color
                } else {
                    view.setBackgroundColor(Color.WHITE); // Default white background
                }
            }
        });

        return view;
    }

    private void populateCityList() {
        List<String> cities = getCities(); // Get the list of city names
        StringBuilder cityList = new StringBuilder();
        for (int i = 0; i < cities.size(); i++) {
            cityList.append("# ").append(cities.get(i));
            if ((i + 1) % 2 == 0) {
                cityList.append("\n"); // each line only display 2 names
            } else {
                cityList.append("      ");
            }
        }
        textViewList.setText(cityList.toString());
    }

    private void populateFieldList() {
        List<String> fields = getFields(); // Get the list of field names
        StringBuilder fieldList = new StringBuilder();
        for (int i = 0; i < fields.size(); i++) {
            fieldList.append("# ").append(fields.get(i));
            if ((i + 1) % 2 == 0) {
                fieldList.append("\n");
            } else {
                fieldList.append("      ");
            }
        }
        textViewList.setText(fieldList.toString());
    }

    // a list of city names
    private List<String> getCities() {
        List<String> cities = new ArrayList<>();
        cities.add("Pune");
        cities.add("Ottawa");
        cities.add("Oxford");
        cities.add("Noida");
        cities.add("Mumbai");
        cities.add("Toronto");
        cities.add("Vancouver");
        cities.add("New York");
        cities.add("Cambridge");
        cities.add("San Francisco");
        return cities;
    }

    // a list of field names
    private List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("API");
        fields.add("GPS");
        fields.add("Gaming");
        fields.add("Django");
        fields.add("Chatbot");
        fields.add("Security");
        fields.add("Ecommerce");
        fields.add("Automation");
        fields.add("Innovation");
        fields.add("3D Modelling");
        return fields;
    }
}
