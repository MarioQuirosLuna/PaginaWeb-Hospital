package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import cr.ac.ucr.movilapp_hospital.R;

public class DetailsAllergyActivity extends AppCompatActivity {

    private TextView identification;
    private TextView name;
    private TextView allergyName;
    private TextView allergyDescription;
    private TextView date;
    private TextView medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_allergy);

        identification = (TextView) findViewById(R.id.Patient_Identification_Details_Allergy);
        name = (TextView) findViewById(R.id.Patient_Name_Details_Allergy);
        allergyName = (TextView) findViewById(R.id.Patient_AllergyName_Details_Allergy);
        allergyDescription = (TextView) findViewById(R.id.Patient_AllergyDescription_Details_Allergy);
        date = (TextView) findViewById(R.id.Patient_DateTime_Details_Allergy);
        medicine = (TextView) findViewById(R.id.Patient_Medicine_Details_Allergy);

        Bundle extra = getIntent().getExtras();
        if(extra != null){

            identification.setText(extra.getString("identification"));
            name.setText(extra.getString("name"));
            allergyName.setText(extra.getString("allergyName"));
            allergyDescription.setText(extra.getString("allergyDescription"));
            date.setText(extra.getString("diagnosisDateTime"));
            medicine.setText(extra.getString("medicine"));
        }

    }
}