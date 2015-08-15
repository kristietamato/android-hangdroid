package org.tamato.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSinglePlayer(View v)
    {
        Intent myIntent = new Intent(this, GameActivity.class);

        startActivity(myIntent);
    }

    public void startMultiplayer(View v)
    {
        Intent myIntent = new Intent(this, Multiplayer.class);

        startActivity(myIntent);
    }
}
