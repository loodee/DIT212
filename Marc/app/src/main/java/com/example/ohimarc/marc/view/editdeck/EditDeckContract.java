package com.example.ohimarc.marc.view.editdeck;

public interface EditDeckContract {
    interface View {
        void setPresenter(EditDeckContract.Presenter presenter);
    }

    interface Presenter {
        void start();

        void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder position, int rowView);

        int getBasicNoteRowsCount();
    }
}
