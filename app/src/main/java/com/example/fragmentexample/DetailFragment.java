package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    // Views
    private TextView tvDetailTitle;
    private TextView tvDetailMessage;
    private Button btnGoBack;

    // Use newInstance() to pass data into the fragment
    public static DetailFragment newInstance(String message) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString("message", message);
        fragment.setArguments(args);
        return fragment;
    }

    // Step 1: Inflate the XML layout
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    // Step 2: Find views and set click listeners
    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Bind views
        tvDetailTitle   = view.findViewById(R.id.tvDetailTitle);
        tvDetailMessage = view.findViewById(R.id.tvDetailMessage);
        btnGoBack       = view.findViewById(R.id.btnGoBack);

        // Show the message passed from HomeFragment
        if (getArguments() != null) {
            tvDetailMessage.setText(getArguments().getString("message", "Detail Screen"));
        }

        // Go back to HomeFragment when Back button tapped
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity()
                        .getSupportFragmentManager()
                        .popBackStack();  // goes back to HomeFragment
            }
        });
    }
}