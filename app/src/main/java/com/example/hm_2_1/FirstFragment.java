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


public class FirstFragment extends Fragment {

    EditText et1;
    Button btn1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        onClick();
    }

    private void onClick() {
        btn1.setOnClickListener(view -> {
            String textFromEditText = et1.getText().toString();
            navigate(textFromEditText);
        });
    }

    private void findViews() {
        et1 = requireActivity().findViewById(R.id.et_name);
        btn1 = requireActivity().findViewById(R.id.btn_one);
    }

    private void navigate(String name) {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container_view, secondFragment).addToBackStack(null).commit();

    }
}