package gomes.john.johngomes_comp304lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static gomes.john.johngomes_comp304lab2.R.styleable.MenuItem;

public class CustomerInfoActivity extends AppCompatActivity
{
    //Global Variables
    private String custNameInput;
    private String custAddressInput;
    private String custPostalCodeInput;
    private String custCityInput;
    private String custCreditCardInput;
    private String custCardMonthInput;
    private String custCardYearInput;
    private String favCuisineInput;
    private String favResInput;
    private int errorPassed=0;
    //Array to hold food list that are picked from menu, utilizing this list in next activity
    private ArrayList<String> foodList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        //Activity title
        getSupportActionBar().setTitle(R.string.custInfoTitle);

        //Get data from prev activity, set them to spinners of this activity
        getSetCustData();

        //Order button click listener
        Button orderButton = (Button) findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                //Method to verify CX input and show error if not done properly
                getSetCustInput();
                Intent intent = new Intent(CustomerInfoActivity.this, CheckOutActivity.class);
                //Put data in intent.putExtra for next activity to utilize
                intent.putExtra("name", custNameInput);
                intent.putExtra("address", custAddressInput);
                intent.putExtra("postalCode", custPostalCodeInput);
                intent.putExtra("city", custCityInput);
                intent.putExtra("creditCard", custCreditCardInput);
                intent.putExtra("monthExpiry", custCardMonthInput);
                intent.putExtra("yearExpiry", custCardYearInput);
                intent.putExtra("favCuisine", favCuisineInput);
                intent.putExtra("favRest", favResInput);
                intent.putStringArrayListExtra("foodListData", foodList);//Send array list data into next activity

                //If all errors are fixed, go to next activity
                if (errorPassed ==5) {
                    startActivity(intent);
                }
                else //Else show message, and reset errorPassed variable
                {
                    Toast.makeText(CustomerInfoActivity.this, "Please clear all errors", Toast.LENGTH_LONG).show();
                    errorPassed = 0;
                }
            }
        });

    }

    private void getSetCustData()
    {
        //Get food items array list
        ArrayList<String> foodData = getIntent().getStringArrayListExtra("foodListData");
        foodList = foodData; //Put data into new arrayList

        //Months Spinner
        Spinner monthSpinner = (Spinner) findViewById(R.id.custMonthExpSpinner);
        //Set XML list to array adapter
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(CustomerInfoActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.months));
        //Set adapter to spinner data
        monthsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthsAdapter);

        //Years Spinner
        Spinner yearSpinner = (Spinner) findViewById(R.id.custYearExpirySpinner);
        //Set XML array list to array adapter
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(CustomerInfoActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.years));
        //Set adapter data to spinner data
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        //Favourite Cuisine
        ArrayAdapter<String> cuisineAdapter = new ArrayAdapter<String>(CustomerInfoActivity.this, android.R.layout.select_dialog_item, getResources().getStringArray(R.array.cuisineNames));
        //Set adapter data to spinner data
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.cuisineTextviewAuto);
        autoCompleteTextView.setAdapter(cuisineAdapter);

        //Favourite Restaurant Spinner
        Spinner favResSpinner = (Spinner) findViewById(R.id.custFavResSpinner);
        //Set XML array list to array adapter
        ArrayAdapter<String> favResAdapter = new ArrayAdapter<String>(CustomerInfoActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.restNames));
        //Set adapter data to spinner data
        favResAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        favResSpinner.setAdapter(favResAdapter);
    }

    private void getSetCustInput()
    {
        //Name
        EditText custNameText = (EditText) findViewById(R.id.custNameEditText);

        if(custNameText.length()==0)
        {
            custNameText.setError("Required Field");
        }
        else if (custNameText.getError()==null )
        {
            custNameInput = custNameText.getText().toString();
            errorPassed ++;
        }

        //Address
        EditText custAddressText = (EditText) findViewById(R.id.custAddressEditText);

        if(custAddressText.length()==0 || custAddressText.length() < 5)
        {
            custAddressText.setError("Required Filed");
        }
        else if (custAddressText.getError() == null)
        {
            custAddressInput = custAddressText.getText().toString();
            errorPassed ++;
        }

        //Postal Code
        EditText custPostalCodeText = (EditText) findViewById(R.id.postalCodeEditText);

        if(custPostalCodeText.length()==0 || custPostalCodeText.length() <6 )
        {
            custPostalCodeText.setError("Required Filed");
        }
        else if (custPostalCodeText.getError() == null)
        {
            custPostalCodeInput = custPostalCodeText.getText().toString();
            errorPassed ++;
        }

        //City
        EditText custCityText = (EditText) findViewById(R.id.cityEditText);

        if(custCityText.length()==0 || custCityText.length() <5 || custCityText.getText().toString().matches(".*\\d+.*"))
        {
            custCityText.setError("Required Filed");
        }
        else if (custCityText.getError() == null)
        {
            custCityInput = custCityText.getText().toString();
        }

        //Credit Card Number
        EditText custCreditCardText = (EditText) findViewById(R.id.creditCardEditText);

        if(custCreditCardText.length()==0 || custCreditCardText.length() < 16)
        {
            custCreditCardText.setError("Required Filed");
        }
        else if (custCreditCardText.getError() == null)
        {
            custCreditCardInput = custCreditCardText.getText().toString();
            errorPassed ++;
        }

        //Credit Card Expiry Month
        Spinner custCreditCardMonthText = (Spinner) findViewById(R.id.custMonthExpSpinner);
        custCardMonthInput = custCreditCardMonthText.getSelectedItem().toString();


        //Credit Card Expiry Year
        Spinner custCreditCardYearText = (Spinner) findViewById(R.id.custYearExpirySpinner);
        custCardYearInput = custCreditCardYearText.getSelectedItem().toString();

        //Favourite Cuisine
        AutoCompleteTextView custFavCusText = (AutoCompleteTextView) findViewById(R.id.cuisineTextviewAuto);

        if(custFavCusText.length()==0)
        {
            custFavCusText.setError("Required Filed");
        }
        else if (custFavCusText.getError()== null)
        {
            favCuisineInput = custFavCusText.getText().toString();
            errorPassed ++;
        }

        //Favourite Rest
        Spinner custFavRestText = (Spinner) findViewById(R.id.custFavResSpinner);
        favResInput = custFavRestText.getSelectedItem().toString();

    }

    //Override back button functionality to retain info
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}
