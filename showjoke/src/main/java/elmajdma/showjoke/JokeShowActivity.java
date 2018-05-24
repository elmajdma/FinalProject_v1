package elmajdma.showjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeShowActivity extends AppCompatActivity {
  private  static final String JOKE_KEY="joke_key";
  TextView tvShowJoke;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke_show);
    tvShowJoke=findViewById(R.id.tv_show_joke);
    Intent intent=getIntent();
    tvShowJoke.setText(intent.getStringExtra(JOKE_KEY));
  }
}
