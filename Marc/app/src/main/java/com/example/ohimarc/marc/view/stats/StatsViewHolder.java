package com.example.ohimarc.marc.view.stats;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.R;

public class StatsViewHolder extends RecyclerView.ViewHolder{

    private TextView deckTitle;

    public StatsViewHolder(@NonNull View itemView) {
        super(itemView);

        deckTitle = itemView.findViewById(R.id.deckTitle);
    }

    public void setDeckTitle(String title) {
        deckTitle.setText(title);
    }
}
