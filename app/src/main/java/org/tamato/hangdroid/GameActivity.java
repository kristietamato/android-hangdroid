package org.tamato.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity
{
    String mWord = "WORD";

    int nFailCounter = 0;

    int nCorrectGuessedLetter = 0;

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

        myEditText.setText(""); // resets the EditText for new letter

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

        boolean letterGuessed = false;

        for (int counter = 0; counter < mWord.length(); counter++)
        {
            char charFromTheWord = (mWord.charAt(counter));
            if (charFromTheWord == charInput)
            {
                Log.d("MYLOG", "There was one match");

                letterGuessed = true;

                showLetterAtIndex(counter, charInput);

                nCorrectGuessedLetter++;
            }
        }

        if (letterGuessed == false)
        {
            letterFailed(Character.toString(charInput));
        }

        if (nCorrectGuessedLetter == mWord.length())
        {
            // TODO
            // Score one point
            // Clear all the text
            clearScreenText();
            // Start the game
        }
    }

    // clears all the text on the screen after the game is over
    public void clearScreenText()
    {
        TextView textViewFailed = (TextView) findViewById(R.id.failedLetters);
        textViewFailed.setText("");

        nCorrectGuessedLetter = 0;
        nFailCounter = 0;

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        for (int counter = 0; counter < layoutLetter.getChildCount(); counter++)
        {
            TextView currentTextView = (TextView) layoutLetter.getChildAt(counter);
            currentTextView.setText("_");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);
    }

    public void letterFailed(String letterFailed)
    {
        showFailedLetter(letterFailed);

        nFailCounter++;

        // change the image
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        switch (nFailCounter)
        {
            case 1: imageView.setImageResource(R.drawable.hangdroid_1);
                    break;
            case 2: imageView.setImageResource(R.drawable.hangdroid_2);
                    break;
            case 3: imageView.setImageResource(R.drawable.hangdroid_3);
                    break;
            case 4: imageView.setImageResource(R.drawable.hangdroid_4);
                    break;
            case 5: imageView.setImageResource(R.drawable.hangdroid_5);
                    break;
            case 6: Intent gameOverIntent = new Intent(this, GameOverActivity.class);
                    startActivity(gameOverIntent);
                    break;
        }
    }

    // show failed letter(s)
    public void showFailedLetter(String failedLetter)
    {
        TextView textViewFailed = (TextView) findViewById(R.id.failedLetters);

        // get the previous failed letter
        String previousFailed = textViewFailed.getText().toString();

        textViewFailed.setText(previousFailed + failedLetter);
    }

    // show the correctly guessed letter
    public void showLetterAtIndex(int position, char letterGuessed)
    {
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letterGuessed));
    }

}
