package org.tamato.hangdroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity
{
    int nPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int points = getIntent().getIntExtra("PONTS_IDENTIFIER", 0);

        TextView textViewPoints = (TextView) findViewById(R.id.textViewPoints);
        textViewPoints.setText(String.valueOf(points));

        nPoints = points;
    }

    public void saveScore(View v)
    {
        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        EditText editText = (EditText) findViewById(R.id.editTextName);
        String name = editText.getText().toString();

        // NAME X POINTS /n
        SharedPreferences.Editor editor = preferences.edit();

        String previousScores = preferences.getString("SCORES", "");

        editor.putString("SCORES", name + " " + nPoints + " POINTS\n" + previousScores);
        editor.commit();

        // close the activity
        finish();
    }

}
