package com.example.ohimarc.marc.view.startMenuView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.StartMenuPresenter;

/**
 * @author Gustav Albertsson
 *
 * Class responsbile for holding the information for one user in one row in the recyclerView
 * */
public class UserViewHolder extends RecyclerView.ViewHolder{

    private final TextView username;

    /**
     * Sets up a new UserViewHolder for a given View
     * @param itemView The view for which the instance is responsible for
     * @param presenter The presenter to which the UserViewHolder should communicate with
     * */
    public UserViewHolder(@NonNull View itemView, final StartMenuPresenter presenter) {
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


    /**
     * Method for setting the text of the username
     * @param name The username that should be displayed
     * */
    public void setUsername(String name){
        username.setText(name);
    }


}
