package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import cr.ac.ucr.movilapp_hospital.R;

public class DetailsVaccineActivity extends AppCompatActivity {

    private TextView identification;
    private TextView name;
    private TextView vaccineName;
    private TextView vaccineDescription;
    private TextView date;
    private TextView nextDate;
    private TextView clinic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_vaccine);

        identification = (TextView) findViewById(R.id.Patient_Identification_Details_Vaccine);
        name = (TextView) findViewById(R.id.Patient_Name_Details_Vaccine);
        vaccineName = (TextView) findViewById(R.id.Patient_VaccineName_Details_Vaccine);
        vaccineDescription = (TextView) findViewById(R.id.Patient_VaccineDescription_Details_Vaccine);
        date = (TextView) findViewById(R.id.Patient_DateTime_Details_Vaccine);
        nextDate = (TextView) findViewById(R.id.Patient_NextDateTime_Details_Vaccine);
        clinic = (TextView) findViewById(R.id.Patient_ClinicName_Details_Vaccine);

        Bundle extra = getIntent().getExtras();
        if(extra != null){

            identification.setText(extra.getString("identification"));
            name.setText(extra.getString("name"));
            vaccineName.setText(extra.getString("vaccineName"));
            vaccineDescription.setText(extra.getString("vaccineDescription"));
            date.setText(extra.getString("dateTime"));
            nextDate.setText(extra.getString("nextDoseDateTime"));
            clinic.setText(extra.getString("clinicName"));
        }

    }
}