package com.geektech.homework_5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {

    private final String KEY = "key";
    private Button button;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
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
                ForthFragment fragment = new ForthFragment();
                bundle.putString(KEY, textView.getText().toString());
                fragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, fragment).commit();
            }
        });
    }
}