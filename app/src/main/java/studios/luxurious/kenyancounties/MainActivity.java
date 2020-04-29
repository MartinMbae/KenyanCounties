package studios.luxurious.kenyancounties;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import studios.luxurious.kenya47counties.activities.CountyReturned;
import studios.luxurious.kenya47counties.activities.Kenya47Counties;
import studios.luxurious.kenya47counties.models.County;

public class MainActivity extends AppCompatActivity {

    //Declare the views to use
   private CheckBox showFlag, showNumber, orderAlphabetically;
   private Button showDialog;
   private TextView selectedCountyTextview;
   private ImageView flagImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the views
        showFlag = findViewById(R.id.checkbox_county_flag);
        showNumber = findViewById(R.id.checkbox_county_number);
        orderAlphabetically = findViewById(R.id.checkbox_county_alphabetically);
        showDialog = findViewById(R.id.showDialog);
        selectedCountyTextview = findViewById(R.id.selectedCounty);
        flagImageView = findViewById(R.id.flagImageView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Assign OnClickListener to the button
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Call the counties dialog

                /*
                 * The showAllCountiesDialog is a static method that contains the following parameters
                 *
                 * Context
                 * Dialog title
                 * boolean showCountyNumber  -> This are the official county numbers, eg 001 for Mombasa, 018 for Nyandarua, 047 for Nairobi
                 * boolean showCountyFlag
                 * boolean sortAlphabetically -> By default the counties are ordered by their county number ie Mombasa (001) leads and Nairobi (047) is at the bottom of the list. SortAlphabetically sorts them alphabetically
                 *
                 * */

                Kenya47Counties.showAllCountiesDialog(MainActivity.this,
                        "Select your county",
                        showNumber.isChecked(),
                        showFlag.isChecked(),
                        orderAlphabetically.isChecked(),
                        new CountyReturned() {
                    @Override
                    public void onSelectedCounty(County selectedCounty) {

                        String countyName = selectedCounty.getName();  //eg Mombasa
                        int countyId = selectedCounty.getId();  //eg 1 for Mombasa and 47 for Nairobi
                        String countyNumber = selectedCounty.getFormattedCountyNumber();  //eg  001 for Mombasa and 047 for Nairobi
                        Drawable countyFlag = selectedCounty.getFlag();  // Flag of the selected county

                        String selectionText = countyNumber + " - " + countyName;
                        selectedCountyTextview.setText(selectionText);
                        flagImageView.setImageDrawable(countyFlag);
                    }
                });


            }
        });
    }
}
