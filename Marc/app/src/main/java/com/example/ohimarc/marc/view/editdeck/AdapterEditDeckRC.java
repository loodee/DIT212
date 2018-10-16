package com.example.ohimarc.marc.view.editdeck;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;

public class AdapterEditDeckRC extends RecyclerView.Adapter<BasicNoteViewHolder> {

    private final EditDeckContract.Presenter presenter;

    AdapterEditDeckRC(EditDeckContract.Presenter presenter) {
        this.presenter = presenter;
    }

<<<<<<< Updated upstream:Marc/app/src/main/java/com/example/ohimarc/marc/view/editdeck/AdapterEditDeckRC.java
=======
        /** Creates the viewHolder for every single item inside the recyclerView
         *
         * @param viewGroup is the viewHolder in the recyclerView
         * @param i is not used but is required due to the interface that is being used for the method
         * @return
         */
>>>>>>> Stashed changes:Marc/app/src/main/java/com/example/ohimarc/marc/view/editDeckView/AdapterEditDeckRC.java
    @NonNull
    @Override
    public BasicNoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BasicNoteViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_basic_note, viewGroup, false), presenter);
    }

<<<<<<< Updated upstream:Marc/app/src/main/java/com/example/ohimarc/marc/view/editdeck/AdapterEditDeckRC.java
=======
        /** Attaches a viewHolder to an item inside the recyclerView
         *
         * @param basicNoteViewHolder is the viewHolder for the items inside the recyclerView
         * @param i the position of the item inside of the recyclerView
         */
>>>>>>> Stashed changes:Marc/app/src/main/java/com/example/ohimarc/marc/view/editDeckView/AdapterEditDeckRC.java
    @Override
    public void onBindViewHolder(@NonNull BasicNoteViewHolder basicNoteViewHolder, int i) {
        presenter.onBindBasicNoteRowViewAtPosition(basicNoteViewHolder, i);
    }

<<<<<<< Updated upstream:Marc/app/src/main/java/com/example/ohimarc/marc/view/editdeck/AdapterEditDeckRC.java
=======
        /**
         * Used when the needed to know the amount of items in the recyclerView
         * @return the amount of items in the recyclerView
         */
>>>>>>> Stashed changes:Marc/app/src/main/java/com/example/ohimarc/marc/view/editDeckView/AdapterEditDeckRC.java
    @Override
    public int getItemCount() {
        return presenter.getBasicNoteRowsCount();
    }
}
