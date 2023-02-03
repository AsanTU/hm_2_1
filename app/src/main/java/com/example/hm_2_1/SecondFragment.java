package com.example.hm_2_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SecondFragment extends Fragment {

    EditText et2;
    Button btn2;
    String nameFromFirst;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        onClick();
    }

    private void getBundle() {
        if (getArguments() != null) {
            nameFromFirst = getArguments().getString("name");
        }
    }

    private void onClick() {
        btn2.setOnClickListener(view -> {
            String textFromET = (et2.getText().toString());
            navigate(textFromET);
        });
    }

    private void navigate(String secondName) {
        Bundle bundle = new Bundle();
        bundle.putString("secondName", secondName);
        bundle.putString("name", nameFromFirst);
        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, thirdFragment)
                .addToBackStack(null).commit();
    }

    private void findViews() {
        et2 = requireActivity().findViewById(R.id.et_secon);
        btn2 = requireActivity().findViewById(R.id.btn_two);
    }
}