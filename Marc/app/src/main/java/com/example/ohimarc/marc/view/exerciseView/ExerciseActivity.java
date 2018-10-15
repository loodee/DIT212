package com.example.ohimarc.marc.view.exerciseView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ExercisePresenter;
import com.example.ohimarc.marc.view.flashcardView.FlashcardActivity;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;
import com.example.ohimarc.marc.view.quizView.QuizActivity;

/**
 * @author Alexander Sandberg (alexandersand on github)
 */

public class ExerciseActivity extends ToolbarExtension {

    private ExercisePresenter presenter;
    private int deckIndex;
    private int modeIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        unpackBundle();

        presenter = new ExercisePresenter(deckIndex);
        initExtension(this, R.id.activity_exercise, presenter.getDeckTitle());
    }

    /**
     * This function is called when the "Flashcard Game" button is clicked in the view.
     * It sets the int modeIndex to 0, which is used in the function navigate later on.
     * @param v is a View which in this case is the XML-file activity_exercise.
     */

    public void flashcardClicked(View v) {
        modeIndex = 0;
        navigate();
    }

    /**
     * This function is called when the "Quiz Game" button is clicked in the view.
     * It sets the int modeIndex to 0, which is used in the function navigate later on.
     * @param v is a View which in this case is the XML-file activity_exercise.
     */

    public void quizClicked(View v) {
        modeIndex = 1;
        navigate();
    }

    /**
     * This function is used to handle any navigation from the view. With a case switch,
     * it uses the int variable modeIndex to set the Intent.
     * In the case where quiz has been selected, it will need to check whether the current deck
     * has got more than 3 cards in it in order not to break the program later on.
     * After the Intent has been set, the function checks whether Intent is null. If it is, the
     * function should do nothing in order not to break the program. Else, it will pack a bundle,
     * start the next activity and finish itself.
     */

    public void navigate() {
        Intent intent;
        switch (modeIndex) {
            case (0):
                intent = new Intent(getApplicationContext(), FlashcardActivity.class);
                break;
            case (1):
                if (presenter.getDeckSize() > 3) {
                    intent = new Intent(getApplicationContext(), QuizActivity.class);
                    break;
                } else {
                    Toast.makeText(getApplicationContext(), "The deck needs to contain at least" +
                            " 4 cards to play the quiz mode.", Toast.LENGTH_LONG).show();
                    return;
                }
            default:
                intent = null;
                break;
        }
        if (intent != null) {
            packBundle(intent);
            startActivity(intent);
            finish();
        }
    }

    /**
     * This functions handles the unpacking of a bundle. The bundle has previously been packed
     * by ChoosingDeckActivity. In the bundle, an int with the key "deckIndex" is expected to
     * be found, which marks what deck has been selected. This index needs to be forwarded to
     * the next activity.
     */

    private void unpackBundle() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            deckIndex = b.getInt("deckIndex");
        }
    }

    /**
     * This function handles the forwarding of the int deckIndex. It is packed into a bundle
     * with the key "deckIndex", which is then put into an Intent.
     * @param intent is an Intent, given by the function navigate(), above.
     */

    private void packBundle(Intent intent) {
        Bundle b = new Bundle();
        b.putInt("deckIndex", deckIndex);
        intent.putExtras(b);
    }

}
