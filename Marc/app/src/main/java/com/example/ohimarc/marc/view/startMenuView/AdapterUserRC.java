package com.example.ohimarc.marc.view.startMenuView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.StartMenuPresenter;


/**
 * @author Gustav Albertsson
 *
 * Class responsible for setting up the UserViewHolders for the recycler view
 */
class AdapterUserRC extends RecyclerView.Adapter<UserViewHolder> {

    private final StartMenuPresenter presenter;

    /**
     * Sets up a AdapterUserRC with the given presenter to communicate with
     *
     * @param presenter The presenter in which the instance can communicate with
     */
    public AdapterUserRC(StartMenuPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UserViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_user, viewGroup, false), presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        presenter.onBindUserRowViewAtPosition(userViewHolder, i);
    }


    @Override
    public int getItemCount() {
        return presenter.getUserRowsCount();
    }

}
