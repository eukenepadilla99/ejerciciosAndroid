package com.example.trial.ui.contacto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.trial.R;

public class ContactoFragment extends Fragment {

    private ContactoViewModel contactoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactoViewModel =
                ViewModelProviders.of(this).get(ContactoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contacto, container, false);
        final TextView textView = root.findViewById(R.id.text_contacto);
        contactoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}