package gomes.john.johngomes_comp304lab2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodMenuActivity extends AppCompatActivity {

    //Global variables
    private String chosenRadio = null;
    private String resPicked = null;
    String chosenRadioPause =null;
    //Array to hold food list that are picked from menu
    private ArrayList<String> foodList = new ArrayList<String>();

    //Instantiate drawerLayout
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        //Activity title
        getSupportActionBar().setTitle(R.string.title_activity_food_menu);


        //Menu drawer toggle
        drawerLayout = (DrawerLayout) findViewById(R.id.foodMenuDrawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menuOpen, R.string.menuClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Show restaurants
        showMenuGroup();

        //Method to show food menu in respect to which restaurant selected
        navigationItemSelected();

        //Next button click listener
        Button nxtButton = (Button) findViewById(R.id.nextButton);
        nxtButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                getChkedText();
                Intent intent = new Intent(FoodMenuActivity.this, CustomerInfoActivity.class);
                intent.putStringArrayListExtra("foodListData", foodList);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onPause()
    {
        super.onPause();
        chosenRadioPause = chosenRadio;
    }
    @Override
    public void onResume()
    {
        super.onResume();
        chosenRadioPause = chosenRadio;
        showMenuGroup();
        navigationItemSelected();

    }

    //Method identifies which restaurant menu to show
    private void showMenuGroup()
    {
        String americanCuisine = "americanCuisineRadio";
        String italianCuisine = "italianCuisineRadio";
        String chineseCuisine = "chineseCuisineRadio";
        String indianCuisine = "indianCuisineRadio";

        navigationView = (NavigationView) findViewById(R.id.navView);
        Menu nav_menu = navigationView.getMenu();


        //Get data from previous activity
        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            //Get's string of the radio chosen
            chosenRadio = extras.getString("RadioChosen");
        }

        //Match string from radio button in previous activity
        if(chosenRadio != null && chosenRadio.equals(americanCuisine) )
        {
            TextView testText = (TextView)findViewById(R.id.textViewTest);
            testText.setText(R.string.americanCuisineRadioButton);

            //Show only restaurant group related to that cuisine in the menu
            nav_menu.setGroupVisible(R.id.menu_group1,true);

        }
        else if (chosenRadio != null && chosenRadio.equals(italianCuisine))
        {
            TextView testText = (TextView)findViewById(R.id.textViewTest);
            testText.setText(R.string.italianCuisineRadioButton);

            //Show only restaurant group related to that cuisine in the menu
            nav_menu.setGroupVisible(R.id.menu_group2,true);
        }
        else if (chosenRadio != null && chosenRadio.equals(chineseCuisine))
        {
            TextView testText = (TextView)findViewById(R.id.textViewTest);
            testText.setText(R.string.chineseCuisineRadioButton);

            //Show only restaurant group related to that cuisine in the menu
            nav_menu.setGroupVisible(R.id.menu_group3,true);
        }
        else if (chosenRadio != null && chosenRadio.equals(indianCuisine))
        {
            TextView testText = (TextView)findViewById(R.id.textViewTest);
            testText.setText(R.string.indianCuisineRadioButton);

            //Show only restaurant group related to that cuisine in the menu
            nav_menu.setGroupVisible(R.id.menu_group4,true);
        }
    }

    //Method to display text(Food) in check boxes based on restaurant selection
    private void navigationItemSelected()
    {

        //setting up selected item listener
        navigationView = (NavigationView) findViewById(R.id.navView);
        //Set listener for navigation menu click
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {

                menuItem.setChecked(true);

                //Handle navigation view item clicks
                int id = menuItem.getItemId();
                resPicked = menuItem.toString();

                //American Cuisine
                //If restaurant 1 is selected
                if (id == R.id.nav_res1)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.americanCus1);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.americanCus2);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.americanCus3);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.americanCus4);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 2 is selected
                else if(id == R.id.nav_res2)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.americanCus5);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.americanCus6);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.americanCus7);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.americanCus8);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 3 is selected
                else if(id == R.id.nav_res3)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.americanCus9);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.americanCus10);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.americanCus11);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.americanCus12);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 4 is selected
                else if(id == R.id.nav_res4)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.americanCus13);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.americanCus14);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.americanCus15);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.americanCus16);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }

                //Italian Cuisine
                //If restaurant 5 is selected
                else if(id == R.id.nav_res5)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.italianCus1);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.italianCus2);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.italianCus3);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.italianCus4);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 6 is selected
                else if(id == R.id.nav_res6)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.italianCus5);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.italianCus6);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.italianCus7);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.italianCus8);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 7 is selected
                else if(id == R.id.nav_res7)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.italianCus9);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.italianCus10);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.italianCus11);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.italianCus12);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 8 is selected
                else if(id == R.id.nav_res8)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.italianCus13);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.italianCus14);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.italianCus15);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.italianCus16);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }

                //Chinese Cuisine
                //If restaurant 9 is selected
                else if(id == R.id.nav_res9)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.chineseCus1);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.chineseCus2);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.chineseCus3);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.chineseCus4);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 10 is selected
                else if(id == R.id.nav_res10)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.chineseCus5);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.chineseCus6);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.chineseCus7);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.chineseCus8);
                }
                //If restaurant 11 is selected
                else if(id == R.id.nav_res11)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.chineseCus9);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.chineseCus10);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.chineseCus11);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.chineseCus12);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 12 is selected
                else if(id == R.id.nav_res12)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.chineseCus13);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.chineseCus14);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.chineseCus15);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.chineseCus16);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }

                //Indian Cuisine
                //If restaurant 13 is selected
                else if(id == R.id.nav_res13)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.indianCus1);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.indianCus2);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.indianCus3);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.indianCus4);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 14 is selected
                else if(id == R.id.nav_res14)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.indianCus5);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.indianCus6);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.indianCus7);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.indianCus8);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 15 is selected
                else if(id == R.id.nav_res15)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.indianCus9);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.indianCus10);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.indianCus11);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.indianCus12);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }
                //If restaurant 16 is selected
                else if(id == R.id.nav_res16)
                {
                    CheckBox cb_1 = (CheckBox) findViewById(R.id.checkBox1);
                    cb_1.setText(R.string.indianCus13);

                    CheckBox cb_2 = (CheckBox) findViewById(R.id.checkBox2);
                    cb_2.setText(R.string.indianCus14);

                    CheckBox cb_3 = (CheckBox) findViewById(R.id.checkBox3);
                    cb_3.setText(R.string.indianCus15);

                    CheckBox cb_4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb_4.setText(R.string.indianCus16);

                    TextView testText = (TextView)findViewById(R.id.textViewTest);
                    testText.setText(resPicked + " Menu");
                }


                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    //Get text of food items for check boxes that are selected
    private void getChkedText()
    {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        if (checkBox1.isChecked())
        {
            String chkBox1Text= checkBox1.getText().toString();
            foodList.add(chkBox1Text);
        }
        if (checkBox2.isChecked())
        {
            String chkBox2Text= checkBox2.getText().toString();
            foodList.add(chkBox2Text);
        }
        if (checkBox3.isChecked())
        {
            String chkBox3Text= checkBox3.getText().toString();
            foodList.add(chkBox3Text);
        }
        if (checkBox4.isChecked())
        {
            String chkBox4Text= checkBox4.getText().toString();
            foodList.add(chkBox4Text);
        }

    }

    //Toggle drawer when option item selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
