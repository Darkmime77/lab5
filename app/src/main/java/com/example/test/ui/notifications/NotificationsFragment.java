package com.example.test.ui.notifications;

import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.MyPushNotification;
import com.example.test.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button button = binding.button3;

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MyPushNotification myPushNotification = new MyPushNotification(view.getContext().getApplicationContext(), requireActivity().getSystemService(NotificationManager.class));
                myPushNotification.sendNotify("День","Скоро конец рабочего дня");
                Log.d("test", "test");
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