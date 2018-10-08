package com.example.ohimarc.marc.view.mainMenu;

public interface StartMenuContract {
    interface Presenter {
        void start();

        void onBindBasicNoteRowViewAtPosition(UserViewHolder rowView, int position);

        int getUserRowsCount();

        void onUserClickedAtPosition(int adapterPosition);

        void onUserLongClickedAtPosition(int adapterPosition);
    }
}
