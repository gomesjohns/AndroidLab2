package gomes.john.johngomes_comp304lab2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.Random;

import static gomes.john.johngomes_comp304lab2.R.id.enterButton;

public class MainActivity extends AppCompatActivity {
    final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView bg = (ImageView) findViewById(R.id.randomBG);
        final String str = "bg_"+random.nextInt(4);
        int image_ID = getResources().getIdentifier(str,"drawable", getPackageName());

        bg.setBackgroundResource(image_ID);

        //Enter button click listener
        Button enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                //Start cuisine type activity when enter button is clicked in the main activity
                startActivity(new Intent(MainActivity.this, CuisinesTypeActivity.class));
            }
        });
    }
}
