package com.example.ohimarc.marc.view.editdeck;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;

public class DialogActivity extends DialogFragment {


    private FloatingActionButton mConfirmDel;
    private FloatingActionButton mDeclineDel;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_custom, container, false);
        mDeclineDel = view.findViewById(R.id.fb_declineDel);
        mConfirmDel = view.findViewById(R.id.fb_confirmDel);


        mDeclineDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dialog test", "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        mConfirmDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("2nd Dialog test", "onClick: delete card");

                getDialog().dismiss();
            }
        });
        return view;
    }
}


