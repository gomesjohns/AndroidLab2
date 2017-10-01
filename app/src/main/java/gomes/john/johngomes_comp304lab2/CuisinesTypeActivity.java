package gomes.john.johngomes_comp304lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class CuisinesTypeActivity extends AppCompatActivity {

    //Global variable for radio button
    private String radioChosen= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisines_type);

        //Radio button click listener
        RadioButton radioBtn = (RadioButton) findViewById(R.id.americanCuisine);
        radioBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                //Run onRadioButtonClicked method
                onRadioButtonClicked(v);
            }
        });

        //Radio button click listener
        RadioButton radioBtn2 = (RadioButton) findViewById(R.id.italianCuisine);
        radioBtn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                //Run onRadioButtonClicked method
                onRadioButtonClicked(v);
            }
        });

        //Radio button click listener
        RadioButton radioBtn3 = (RadioButton) findViewById(R.id.chineseCuisine);
        radioBtn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                //Run onRadioButtonClicked method
                onRadioButtonClicked(v);
            }
        });

        //Radio button click listener
        RadioButton radioBtn4 = (RadioButton) findViewById(R.id.indianCusisine);
        radioBtn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                //Run onRadioButtonClicked method
                onRadioButtonClicked(v);
            }
        });


    }

    //Method to pass data to next activity and identify which radio button was clicked
    private void onRadioButtonClicked(View v)
    {
        //Is the button checked?
        boolean checked = ((RadioButton) v).isChecked();

        //Check which radio button was selected
        switch (v.getId())
        {
            case R.id.americanCuisine:
                if (checked)
                    radioChosen = "americanCuisineRadio";
                break;

            case R.id.italianCuisine:
                if (checked)
                    radioChosen = "italianCuisineRadio";
                break;

            case R.id.chineseCuisine:
                if (checked)
                    radioChosen = "chineseCuisineRadio";
                break;

            case R.id.indianCusisine:
                if(checked)
                    radioChosen = "indianCuisineRadio";
                break;
        }

        //Pass data to next activity via intent
        Intent intent = new Intent(CuisinesTypeActivity.this, FoodMenuActivity.class);
        //Put chosen radio button data in intent
        intent.putExtra("RadioChosen", radioChosen);
        //start next activity
        startActivity(intent);
    }
}
