package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import cr.ac.ucr.movilapp_hospital.API.API_HospitalPatient;
import cr.ac.ucr.movilapp_hospital.Model.PatientData;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataPatientActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    private Retrofit retrofit;
    private PatientData patientData;

    private TextView identification;
    private TextView name;
    private TextView age;
    private TextView bloodType;
    private TextView civilState;
    private TextView telephone;
    private TextView address;
    private TextView otherSigns;

    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_patient);

        identification = (TextView) findViewById(R.id.Patient_Identification_Data);
        name = (TextView) findViewById(R.id.Patient_Name_Data);
        age = (TextView) findViewById(R.id.Patient_Age_Data);
        bloodType = (TextView) findViewById(R.id.Patient_Blood_type_Data);
        civilState = (TextView) findViewById(R.id.Patient_Civil_State_Data);
        telephone = (TextView) findViewById(R.id.Patient_Telephone_Data);
        address = (TextView) findViewById(R.id.Patient_Address_Data);
        otherSigns = (TextView) findViewById(R.id.Patient_Description_Data);

        btnUpdate = (Button) findViewById(R.id.Update_Button_Data);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            retrofit = RetrofitSingleton.getRetrofit();

            show(extra.getInt("identification"));
        }
    }

    private void show(int id){

        API_HospitalPatient api = retrofit.create(API_HospitalPatient.class);

        Call<PatientData> call = api.getPatientData(id);

        call.enqueue(new Callback<PatientData>() {
            @Override
            public void onResponse(Call<PatientData> call, Response<PatientData> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }

                patientData = response.body();

                showDataPatientOnScreen();
                addEventUpdateBtn();

            }

            private void showDataPatientOnScreen(){
                identification.setText(String.valueOf(patientData.getPatient_identification()));
                name.setText(patientData.getPatient_name());
                age.setText(String.valueOf(patientData.getAge()));
                bloodType.setText(patientData.getBlood_type());
                civilState.setText(patientData.getCivil_status());
                telephone.setText(patientData.getTelephone());
                address.setText(patientData.getPatient_addres().toString());
                otherSigns.setText(patientData.getPatient_addres().getDescription());
            }

            private void addEventUpdateBtn() {
                if(patientData != null){
                    btnUpdate.setOnClickListener(v -> {
                        Intent intent = new Intent(getApplicationContext(),UpdatePatientActivity.class);
                        intent.putExtra("identification", identification.getText());
                        intent.putExtra("name", name.getText());
                        intent.putExtra("telephone", telephone.getText());
                        intent.putExtra("province", patientData.getPatient_addres().getProvince());
                        intent.putExtra("canton", patientData.getPatient_addres().getCanton());
                        intent.putExtra("district", patientData.getPatient_addres().getDistrict());
                        intent.putExtra("description", patientData.getPatient_addres().getDescription());
                        startActivity(intent);
                    });
                }
            }

            @Override
            public void onFailure(Call<PatientData> call, Throwable t) {
                Log.e(TAG, " onFailure: "+t.getMessage());
            }
        });
    }

}