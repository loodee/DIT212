package com.example.ohimarc.marc.view.startMenuView;

public interface StartMenuContract {
    interface Presenter {
        void onBindBasicNoteRowViewAtPosition(UserViewHolder rowView, int position);

        int getUserRowsCount();

        void onUserClickedAtPosition(int adapterPosition);

        void onUserLongClickedAtPosition(int adapterPosition);
    }
}
