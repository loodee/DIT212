package com.example.ohimarc.marc.view.addremovedeck;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AddRemoveDeckPresenter;

public class AddRemoveDeckViewHolder extends RecyclerView.ViewHolder implements AddRemoveDeckView {

    TextView titleTextView;

    public AddRemoveDeckViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.deck_Title);
    }

    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }


}
