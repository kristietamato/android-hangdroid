package org.tamato.hangdroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity
{
    String mWord = "WORD";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    // get the letter input
    public void introduceLetter(View v)
    {
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString();

        if (letter.length() == 1)
        {
            checkLetter(letter);
        }
        else
        {
            Toast.makeText(this, "Please introduce letter", Toast.LENGTH_SHORT).show();
        }
    }

    // check if letter input is in the word
    public void checkLetter(String letterInput)
    {
        char charInput = letterInput.charAt(0);

        for (int counter = 0; counter < mWord.length(); counter++)
        {
            char charFromTheWord = (mWord.charAt(counter));
            if (charFromTheWord == charInput)
            {
                Log.d("MYLOG", "There was one match");
                showLetterAtIndex(counter, charInput);
            }
        }
    }

    // show the correctly guessed letter
    public void showLetterAtIndex(int position, char letterGuessed)
    {
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letterGuessed));
    }

}
