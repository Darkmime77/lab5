package com.example.test.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.databinding.FragmentDashboardBinding;
import com.example.test.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = binding.button;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] Pers = {"Да", "Нет"};
                boolean[] pers = {false, false};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (pers[0] && !pers[1]) {
                            Toast myToast = Toast.makeText(getActivity().getApplicationContext(), "Все верно", Toast.LENGTH_LONG);
                            myToast.setGravity(Gravity.CENTER, 0, 0);
                            myToast.show();
                            dialogInterface.cancel();
                        } else {
                            dialogInterface.cancel();
                        }
                    }
                }).setMultiChoiceItems(Pers, pers, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        pers[i] = b;
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}