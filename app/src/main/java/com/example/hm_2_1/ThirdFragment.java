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

public class ThirdFragment extends Fragment {

    EditText editText;
    Button button;
    String nameFromFirst;
    String secondFromSecond;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        onClick();
    }

    private void onClick() {
        button.setOnClickListener(view -> {
            String textFromEditText = editText.getText().toString();
            navigate(textFromEditText);
        });
    }

    private void getBundle() {
        if (getArguments() != null) {
            nameFromFirst = getArguments().getString("name");
            secondFromSecond = getArguments().getString("secondName");
        }
    }

    private void navigate(String age) {
        Bundle bundle = new Bundle();
        bundle.putString("age", age);
        bundle.putString("name", nameFromFirst);
        bundle.putString("secondName", secondFromSecond);
        ForthFragment forthFragment = new ForthFragment();
        forthFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,
                forthFragment).addToBackStack(null).commit();
    }

    private void findViews() {
        editText = requireActivity().findViewById(R.id.et_age);
        button = requireActivity().findViewById(R.id.btn_tree);
    }
}
