package com.geektech.homework_5;

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

    private EditText editText;
    private Button button;
    private final String KEY = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.button);
        editText = view.findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                SecondFragment fragment = new SecondFragment();
                bundle.putString(KEY, editText.getText().toString());
                fragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, fragment).commit();
            }
        });
    }
}