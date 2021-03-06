package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import elmajdma.showjoke.JokeShowActivity;
import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
  private  static final String JOKE_KEY="joke_key";
  private JokeDelivery jokeDelivery;
  private static MyApi myApiService = null;
  private Context context;

  public EndpointsAsyncTask(Context context) {
    this.context = context.getApplicationContext();
  }

 /* public EndpointsAsyncTask(JokeDelivery jokeDelivery) {
  this.jokeDelivery=jokeDelivery;

  }*/

  @Override
  protected String doInBackground(Void... params) {

    /*if(myApiService == null) {  // Only do this once
     MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
          new AndroidJsonFactory(), null)
          // options for running against local devappserver
          // - 10.0.2.2 is localhost's IP address in Android emulator
          // - turn off compression when running against local devappserver
          .setRootUrl("http://10.0.2.2:8080/_ah/api/")
          .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
              abstractGoogleClientRequest.setDisableGZipContent(true);
            }
          });*/
      // end options for devappserver

      MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
          new AndroidJsonFactory(), null)
          .setRootUrl("http://192.168.1.4:8080/_ah/api/")
          .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
              abstractGoogleClientRequest.setDisableGZipContent(true);
            }
          });

      myApiService = builder.build();



    try {
      return myApiService.receiveJoke().execute().getData();
    } catch (IOException e) {
      return e.getMessage();
    }
  }

  @Override
  protected void onPostExecute(String result) {
    //Toast.makeText(, result, Toast.LENGTH_LONG).show();
   // jokeDelivery.getJoke(result);
    context.startActivity(new Intent(context, JokeShowActivity.class).putExtra(JOKE_KEY,result));


  }
}
