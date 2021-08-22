package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import cr.ac.ucr.movilapp_hospital.API.API_HospitalPatient;
import cr.ac.ucr.movilapp_hospital.Model.PatientData;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Retrofit;

public class DetailsAppointmentActivity extends AppCompatActivity {

    private TextView identification;
    private TextView name;
    private TextView doctorCode;
    private TextView doctorName;
    private TextView clinicName;
    private TextView date;
    private TextView speciality;
    private TextView diagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_appointment);

        identification = (TextView) findViewById(R.id.Patient_Identification_Details_Appointment);
        name = (TextView) findViewById(R.id.Patient_Name_Details_Appointment);
        doctorCode = (TextView) findViewById(R.id.Patient_DoctorCode_Details_Appointment);
        doctorName = (TextView) findViewById(R.id.Patient_DoctorName_Details_Appointment);
        clinicName = (TextView) findViewById(R.id.Patient_ClinicName_Details_Appointment);
        date = (TextView) findViewById(R.id.Patient_DateTime_Details_Appointment);
        speciality = (TextView) findViewById(R.id.Patient_Speciality_Details_Appointment);
        diagnosis = (TextView) findViewById(R.id.Patient_Diagnosis_Details_Appointment);

        Bundle extra = getIntent().getExtras();
        if(extra != null){

            identification.setText(extra.getString("identification"));
            name.setText(extra.getString("name"));
            doctorCode.setText(extra.getString("doctorCode"));
            doctorName.setText(extra.getString("doctorName"));
            clinicName.setText(extra.getString("clinicName"));
            date.setText(extra.getString("date"));
            speciality.setText(extra.getString("speciality"));
            diagnosis.setText(extra.getString("diagnosis"));
        }
    }

}