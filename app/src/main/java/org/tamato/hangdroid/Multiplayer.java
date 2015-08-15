package org.tamato.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Multiplayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);
    }

    public void startMultiplayerGame(View v)
    {
        EditText editText = (EditText) findViewById(R.id.editTextWord);

        String wordToGuess = editText.getText().toString();

        Intent myIntent = new Intent(this, MultiplayerGameActivity.class);

        myIntent.putExtra("WORD_IDENTIFIER", wordToGuess);

        startActivity(myIntent);
    }
}
