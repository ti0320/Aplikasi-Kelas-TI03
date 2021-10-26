package com.ti3.dedlen.ui.notifications;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ti3.dedlen.R;
import com.ti3.dedlen.ui.admin.checker;

public class NotificationsFragment extends Fragment {

    public String nama_string;
    EditText nama;
    public Button btninfos, btnnama, admin;
    Context mContext;
    public SharedPreferences myPrefs;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        btninfos = root.findViewById(R.id.btninfo);
        btninfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });

        btnnama = root.findViewById(R.id.btnnama);
        btnnama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        admin = root.findViewById(R.id.admin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationsFragment.this.getActivity(), checker.class);
                startActivity(intent);
            }
        });

        return root;
    }

    public void showPopup(View v) {

        View popupView = getActivity().getLayoutInflater().inflate(R.layout.info, null);

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAtLocation(v, Gravity.CENTER,0,0);
        Button closePopupBtn = (Button) popupView.findViewById(R.id.closePopupBtn);

        closePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }


}