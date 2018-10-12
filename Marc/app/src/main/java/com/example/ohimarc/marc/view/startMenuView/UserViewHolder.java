package com.example.ohimarc.marc.view.startMenuView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.R;

public class UserViewHolder extends RecyclerView.ViewHolder{

    private TextView username;

    public UserViewHolder(@NonNull View itemView, final StartMenuContract.Presenter presenter) {
        super(itemView);
        username = itemView.findViewById(R.id.username);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                presenter.onUserLongClickedAtPosition(getAdapterPosition());
                return true;
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onUserClickedAtPosition(getAdapterPosition());
            }
        });
    }

    public void setUsername(String name){
        username.setText(name);
    }


}
