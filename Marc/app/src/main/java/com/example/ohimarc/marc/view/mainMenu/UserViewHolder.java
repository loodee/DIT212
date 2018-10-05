package com.example.ohimarc.marc.view.mainMenu;

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
