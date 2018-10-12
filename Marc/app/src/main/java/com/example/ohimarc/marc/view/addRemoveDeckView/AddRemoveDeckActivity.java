package com.example.ohimarc.marc.view.addRemoveDeckView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AddRemoveDeckPresenter;
import com.example.ohimarc.marc.view.editDeckView.EditDeckActivity;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

public class AddRemoveDeckActivity extends ToolbarExtension implements AddDeckView {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    AddRemoveDeckPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new AddRemoveDeckPresenter(this, getFilesDir().getAbsolutePath());

        setContentView(R.layout.activity_add_remove_deck);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new AddRemoveAdapter(presenter);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        initExtension(this, R.id.addRemoveDeckActivity, "Decks");
    }

    public void addButtonClicked(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create Deck");

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.add_deck_popup, (ViewGroup) findViewById(R.id.baseLayout), false);
        final EditText input = viewInflated.findViewById(R.id.input);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s = input.getText().toString();
                if (s.replaceAll("\\s", "").isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You cant create a deck without a name!", Toast.LENGTH_LONG).show();
                } else {
                    presenter.addDeck(input.getText().toString());
                    mAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void deleteDeck(final int deckIndex) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do you really want to delete this deck?");

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.delete_deck_popup, (ViewGroup) findViewById(R.id.baseLayout), false);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                presenter.deleteDeck(deckIndex);
                mAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                mAdapter.notifyDataSetChanged();
            }
        });

        builder.show();
    }

    @Override
    public void deckIsClicked(int deckIndex) {
        Intent intent = new Intent(AddRemoveDeckActivity.this, EditDeckActivity.class);
        intent.putExtra("deckIndex", deckIndex);
        startActivity(intent);
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            /*
            Point out which element that has been swiped
             */
            int position = viewHolder.getAdapterPosition();
            deleteDeck(position);
        }


    };

}

