package com.example.ohimarc.marc.view.quizView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.QuizPresenter;
import com.example.ohimarc.marc.view.resultsView.ResultsActivity;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

/**
 * @author Alexander Sandberg (alexandersand on github)
 */

public class QuizActivity extends ToolbarExtension implements QuizView {

    private QuizPresenter presenter;

    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button answerButton4;
    private final Button[] buttons = new Button[4];

    private boolean hasAnswered = false;
    private int deckIndex;

    private TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.card);

        assignButtons();
        putButtonsInButtons();
        unpackBundle();

        presenter = new QuizPresenter(this, deckIndex);
        presenter.onCreate();
        initExtension(this, R.id.quiz_activity, presenter.getDeckTitle());
    }

    /**
     * This void is a helper function to onCreate, to make the code a bit more readable.
     * It simply assigns a few Button objects to their respective button in the XML-file
     * activity_quiz.
     */

    private void assignButtons() {
        answerButton1 = findViewById(R.id.answer1);
        answerButton2 = findViewById(R.id.answer2);
        answerButton3 = findViewById(R.id.answer3);
        answerButton4 = findViewById(R.id.answer4);
    }

    /**
     * This function is a helper function to onCreate, above, to make the code a bit more readable.
     * It simply puts the assigned Button objects in a list of buttons.
     */

    private void putButtonsInButtons() {
        buttons[0] = answerButton1;
        buttons[1] = answerButton2;
        buttons[2] = answerButton3;
        buttons[3] = answerButton4;
    }

    /**
     * This function sets a green color to a Button object in the list buttons. It is supposed to
     * mark the correct answer to the question with this green color.
     * @param i is an int which is the index of the Button object in buttons which is to be marked
     *          as the correct answer.
     */

    public void highlightRightAnswer(int i) {
        buttons[i].setBackgroundColor(Color.GREEN);
    }

    /**
     * This function sets a red color to a Button object in the list buttons. It is supposed to
     * mark the incorrect answer to the question with this red color.
     * @param i is an int which is the index of the Button object in buttons which is to be marked
     *          as the incorrect answer.
     */

    public void highlightWrongAnswer(int i) {
        buttons[i].setBackgroundColor(Color.RED);
    }

    /**
     * This function initializes the texts in the view. It assigns the question text to a Textview,
     * while also assigning the question alternatives to each Button in the list buttons.
     * @param list is a list of Strings which is given by QuizPresenter, where all the needed
     *             Strings are stored.
     */

    public void initTexts(String[] list) {
        questionText.setText(list[0]);
        for (int i = 0; i < 4; i++) {
            buttons[i].setText(list[i + 1]);
        }
    }

    /**
     * This function is called when the first answer alternative button is clicked in the view.
     * It sets calls the function questionAnswered in QuizPresenter with an index, 1, which is used
     * in the presenter. It also sets a boolean, hasAnswered to true, in order not to allow any more
     * answers to the given question.
     * @param v is a View which in this case is the XML-file activity_quiz.
     */

    public void answer1Clicked(View v) {
        if (!hasAnswered) {
            presenter.questionAnswered(1);
            hasAnswered = true;
        }
    }

    /**
     * This function is called when the second answer alternative button is clicked in the view.
     * It sets calls the function questionAnswered in QuizPresenter with an index, 2, which is used
     * in the presenter. It also sets a boolean, hasAnswered to true, in order not to allow any more
     * answers to the given question.
     * @param v is a View which in this case is the XML-file activity_quiz.
     */

    public void answer2Clicked(View v) {
        if (!hasAnswered) {
            presenter.questionAnswered(2);
            hasAnswered = true;
        }
    }

    /**
     * This function is called when the third answer alternative button is clicked in the view.
     * It sets calls the function questionAnswered in QuizPresenter with an index, 3, which is used
     * in the presenter. It also sets a boolean, hasAnswered to true, in order not to allow any more
     * answers to the given question.
     * @param v is a View which in this case is the XML-file activity_quiz.
     */

    public void answer3Clicked(View v) {
        if (!hasAnswered) {
            presenter.questionAnswered(3);
            hasAnswered = true;
        }
    }

    /**
     * This function is called when the fourth answer alternative button is clicked in the view.
     * It sets calls the function questionAnswered in QuizPresenter with an index, 4, which is used
     * in the presenter. It also sets a boolean, hasAnswered to true, in order not to allow any more
     * answers to the given question.
     * @param v is a View which in this case is the XML-file activity_quiz.
     */

    public void answer4Clicked(View v) {
        if (!hasAnswered) {
            presenter.questionAnswered(4);
            hasAnswered = true;
        }
    }

    /**
     * This function is called when the "Proceed" button is clicked in the view. Before proceeding,
     * the user has to answer the question, which is handled by the boolean hasAnswered. If the
     * user has answered the question, the proceed function is called in QuizPresenter, while
     * also resetting the color of the Button objects in the list buttons.
     * If a answer has not answered the question, a notification is sent to the user in form of
     * a Toast, telling them that they need to answer the question before pressing "Proceed".
     * @param v is a View, which in this case is the XML-file activity_quiz.
     */

    public void proceedClicked(View v) {
        if (hasAnswered) {
            presenter.proceed();
            for (Button b : buttons) {
                b.setBackgroundColor(Color.WHITE);
            }
            hasAnswered = false;
        } else {
            Toast toast = Toast.makeText(this, "Please select an answer.", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    /**
     * This function handles the navigation to the next activity, namely ResultsActivity.
     * It sets the Intent, packs a bundle for the next activity, starts the activity and
     * finishes itself.
     */

    public void changeView() {
        Intent intent = new Intent(QuizActivity.this, ResultsActivity.class);
        packBundle(intent);
        startActivity(intent);
        finish();
    }

    /**
     * This function unpacks a bundle, given by the former activity, namely ExerciseActivity.
     * Here, an int is expected to be found in the bundle with the key "deckIndex", which marks
     * what deck has been selected. deckIndex is needed in QuizPresenter to find the correct
     * deck.
     */

    private void unpackBundle() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            deckIndex = b.getInt("deckIndex");
        }
    }

    /**
     * This function packs a bundle for ResultsActivity. It puts the results into the bundle,
     * the current game selected, i.e "Quiz Game", while also forwarding the deckIndex.
     * @param intent is an Intent, given by the function changeView().
     */

    private void packBundle(Intent intent) {
        Bundle b = new Bundle();
        b.putIntegerArrayList("results", presenter.getAmountCorrectAnswers());
        b.putInt("deckIndex", deckIndex);
        b.putString("mode", presenter.getGameName());
        intent.putExtras(b);
    }
}
