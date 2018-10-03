package com.example.ohimarc.marc.view.mainMenu;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;

public class AdapterUserRC extends RecyclerView.Adapter<UserViewHolder> {

    private final StartMenuContract.Presenter presenter;

    public AdapterUserRC(StartMenuContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UserViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_user, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        presenter.onBindBasicNoteRowViewAtPosition(userViewHolder, i);
    }


    @Override
    public int getItemCount() {
        return presenter.getUserRowsCount();
    }

}
