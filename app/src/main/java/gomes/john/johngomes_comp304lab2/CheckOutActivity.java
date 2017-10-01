package gomes.john.johngomes_comp304lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        //Activity title
        getSupportActionBar().setTitle(R.string.activityTitleCheckout);
        //Set data to textview to display all customer information
        getSetCustData();

    }

    private void getSetCustData()
    {
        //Get data from prev activity
        String custName = getIntent().getStringExtra("name");
        String custAddress = getIntent().getStringExtra("address");
        String custPostalCode = getIntent().getStringExtra("postalCode");
        String custCity = getIntent().getStringExtra("city");
        String custCreditCard = getIntent().getStringExtra("creditCard");
        String custMonthExpiry = getIntent().getStringExtra("monthExpiry");
        String custYearExpiry = getIntent().getStringExtra("yearExpiry");
        String favCuisine = getIntent().getStringExtra("favCuisine");
        String favRest = getIntent().getStringExtra("favRest");
        ArrayList<String> foodData = getIntent().getStringArrayListExtra("foodListData"); //arratList for chosen food list


        //Set info from prev activity to this activity's textview's
        //Name
        TextView nameTextview = (TextView)findViewById(R.id.custNameTextview);
        nameTextview.setText(custName);

        //Address
        TextView addressTextview = (TextView)findViewById(R.id.custAddressTextView);
        addressTextview.setText(custAddress + ", "+ custPostalCode+ ", "+ custCity);

        //Card Num
        TextView credCardTextview = (TextView)findViewById(R.id.custCreditCardTextView);
        String maskCard = custCreditCard.replaceAll("\\w(?=\\w{4})", "*");//Mask credit card info and show only last four digits
        credCardTextview.setText(maskCard);

        //Card Expire Info
        TextView cardExpiryTextView = (TextView) findViewById(R.id.expiryTextview);
        cardExpiryTextView.setText(custMonthExpiry+ ", "+ custYearExpiry);

        //Fav Cuisine Info
        TextView favCuisineTextView = (TextView) findViewById(R.id.favTextview);
        favCuisineTextView.setText(favCuisine);

        //Fav Rest Info
        TextView favRestTextView = (TextView) findViewById(R.id.favRestTextview);
        favRestTextView.setText(favRest);

        //ArrayAdapter sets data to listView of this activity and displays chosen food list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(CheckOutActivity.this, android.R.layout.simple_list_item_1, foodData);
        ListView foodList = (ListView)findViewById(R.id.foodListview);
        foodList.setAdapter(arrayAdapter);
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
