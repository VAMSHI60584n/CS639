package com.example.conversion;

import static java.lang.String.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.conversion.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonConvert.setOnClickListener(v -> {
            convertLitersToCups();
        });

        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );



    }



    @SuppressLint("SetTextI18n")
    private void convertLitersToCups() {
        try {
            String inputText = binding.editTextLiters.getText().toString();
            if (!inputText.isEmpty()) {
                double liters = Double.parseDouble(inputText);
                double cups = liters * 4.22;
                @SuppressLint("DefaultLocale") String resultText = String.format("%.2f liters is %.2f cups", liters, cups);
                binding.textViewCups.setText(resultText);
            } else {
                binding.textViewCups.setText("Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            binding.textViewCups.setText("Invalid input. Please enter a valid number.");
        }
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}