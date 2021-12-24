package com.geektech.homework_5;

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

    private final String KEY = "key";
    private Button button;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_foarth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.button);
        textView = view.findViewById(R.id.textView);
        assert getArguments() != null;
        if (getArguments().getString("key") != null) {
            textView.setText(getArguments().getString("key"));
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FifthFragment fragment = new FifthFragment();
                bundle.putString(KEY, textView.getText().toString());
                fragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, fragment).commit();
            }
        });
    }
}