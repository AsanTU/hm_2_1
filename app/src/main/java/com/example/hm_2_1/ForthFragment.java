package com.example.hm_2_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ForthFragment extends Fragment {
    Button button;
    TextView textView1, textView2, textView3;

    String nameFromFF;
    String secondFromSF;
    String ageFromTF;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        setTexts();
    }


    private void setTexts() {
        textView1.setText(nameFromFF);
        textView2.setText(secondFromSF);
        textView3.setText(ageFromTF);
    }

    private void findViews() {
        button = requireActivity().findViewById(R.id.btn_dest);
        textView1 = requireView().findViewById(R.id.text_name);
        textView2 = requireView().findViewById(R.id.text_second_name);
        textView3 = requireView().findViewById(R.id.text_age);
    }

    private void getBundle() {
        if (getArguments() != null) {
            nameFromFF = getArguments().getString("name");
            secondFromSF = getArguments().getString("secondName");
            ageFromTF = getArguments().getString("age");
        }
    }
}