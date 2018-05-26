package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import elmajdma.joketeller.Joke;
import elmajdma.showjoke.JokeShowActivity;


public class MainActivity extends AppCompatActivity implements JokeDelivery{
 private  static final String JOKE_KEY="joke_key";
    //private Joke joke=new Joke();
  String jokeToRead;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
     //new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));

      Intent jokeIntent = new Intent(this, JokeShowActivity.class);
      //jokeIntent.putExtra(JOKE_KEY,joke.getJoke());
      jokeIntent.putExtra(JOKE_KEY,jokeToRead);
      startActivity(jokeIntent);
        //Toast.makeText(this,joke.getJoke() , Toast.LENGTH_SHORT).show();


    }




  @Override
  public void getJoke(String joke) {
      jokeToRead=joke;

  }
}
