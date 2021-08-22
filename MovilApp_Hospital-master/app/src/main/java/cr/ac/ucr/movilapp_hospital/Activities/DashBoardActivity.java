package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import cr.ac.ucr.movilapp_hospital.Model.PatientSession;
import cr.ac.ucr.movilapp_hospital.R;

public class DashBoardActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    PatientSession session;

    private TextView txt_Identification_Dashboard;
    private TextView txt_Name_Dashboard;

    private ImageButton btn_dataPatient;
    private ImageButton btn_appointmentPatient;
    private ImageButton btn_allergyPatient;
    private ImageButton btn_vaccinePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        txt_Identification_Dashboard = (TextView) findViewById(R.id.Patient_Identification_Dashboard);
        txt_Name_Dashboard = (TextView) findViewById(R.id.Patient_Name_Dashboard);

        btn_dataPatient = (ImageButton) findViewById(R.id.show_Data_Patient);
        btn_appointmentPatient = (ImageButton) findViewById(R.id.show_Appointment_Patient);
        btn_allergyPatient = (ImageButton) findViewById(R.id.show_Allergy_Patient);
        btn_vaccinePatient = (ImageButton) findViewById(R.id.show_Vaccine_Patient);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            session = new PatientSession(extra.getInt("identification"),extra.getString("name"));
            txt_Identification_Dashboard.setText(String.valueOf(session.getPatientIdentification()));
            txt_Name_Dashboard.setText(session.getPatientName());
        }

        btn_dataPatient.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DataPatientActivity.class);
            intent.putExtra("identification",session.getPatientIdentification());
            startActivity(intent);
        });

        btn_appointmentPatient.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ShowAppointmentsActivity.class);
            intent.putExtra("identification", String.valueOf(session.getPatientIdentification()));
            intent.putExtra("name", session.getPatientName());
            startActivity(intent);
        });

        btn_allergyPatient.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ShowAllergyActivity.class);
            intent.putExtra("identification", String.valueOf(session.getPatientIdentification()));
            intent.putExtra("name", session.getPatientName());
            startActivity(intent);
        });

        btn_vaccinePatient.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ShowVaccineActivity.class);
            intent.putExtra("identification", String.valueOf(session.getPatientIdentification()));
            intent.putExtra("name", session.getPatientName());
            startActivity(intent);
        });
    }
}