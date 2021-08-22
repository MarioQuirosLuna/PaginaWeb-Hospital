package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import cr.ac.ucr.movilapp_hospital.API.API_HospitalPatient;
import cr.ac.ucr.movilapp_hospital.Model.PatientData;
import cr.ac.ucr.movilapp_hospital.Model.PatientRegister;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    private Retrofit retrofit;

    private ProgressBar progress;

    private Spinner options_civil_state;

    private EditText txt_identification;
    private EditText txt_name;
    private EditText txt_password;
    private EditText txt_age;
    private EditText txt_bloodType;
    private EditText txt_telephone;
    private EditText txt_province;
    private EditText txt_canton;
    private EditText txt_district;
    private EditText txt_otherSigns;

    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progress = (ProgressBar) findViewById(R.id.progressAnimationRegister);

        options_civil_state = (Spinner) findViewById(R.id.Patient_Civil_State_Data_Register);
        txt_identification = (EditText) findViewById(R.id.Patient_Identification_Data_Register);
        txt_name = (EditText) findViewById(R.id.Patient_Name_Data_Register);
        txt_password = (EditText) findViewById(R.id.Patient_Password_Data_Register);
        txt_age = (EditText) findViewById(R.id.Patient_Age_Data_Register);
        txt_bloodType = (EditText) findViewById(R.id.Patient_Blood_type_Data_Register);
        txt_telephone = (EditText) findViewById(R.id.Patient_Telephone_Data_Register);
        txt_province = (EditText) findViewById(R.id.Patient_Address_Data_Register);
        txt_canton = (EditText) findViewById(R.id.Patient_Canton_Register_Register);
        txt_district = (EditText) findViewById(R.id.Patient_District_Register_Register);
        txt_otherSigns = (EditText) findViewById(R.id.Patient_Description_Data_Register);

        btn_register = (Button) findViewById(R.id.Update_Button_Data_Register);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options_civil_state, android.R.layout.simple_spinner_item);
        options_civil_state.setAdapter(adapter);

        btn_register.setOnClickListener(v -> {
            progress.setVisibility(View.VISIBLE);

            if(input_Validations()){
                retrofit = RetrofitSingleton.getRetrofit();
                registerPacient(
                        new PatientRegister(
                                Integer.parseInt(txt_identification.getText().toString().trim()),
                                txt_name.getText().toString().trim(),
                                txt_password.getText().toString().trim(),
                                Integer.parseInt(txt_age.getText().toString().trim()),
                                txt_bloodType.getText().toString().trim(),
                                options_civil_state.getSelectedItem().toString(),
                                txt_telephone.getText().toString().trim(),
                                txt_province.getText().toString().trim(),
                                txt_canton.getText().toString().trim(),
                                txt_district.getText().toString().trim(),
                                txt_otherSigns.getText().toString().trim()
                        )
                );
            }

        });
    }

    public void registerPacient(PatientRegister patientregister){

        API_HospitalPatient api = retrofit.create(API_HospitalPatient.class);

        Call<PatientData> call = api.addPatient(patientregister);

        call.enqueue(new Callback<PatientData>() {
            @Override
            public void onResponse(Call<PatientData> call, Response<PatientData> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }

                PatientData patientData = response.body();

                if(patientData != null){
                    Log.e(TAG, " onResponse: "+patientData.toString());
                    onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<PatientData> call, Throwable t) {
                Log.e(TAG, " onFailure: "+t.getMessage());
            }
        });
    }

    private boolean input_Validations(){
        if(txt_identification.getText().toString().equals("")){
            txt_identification.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_name.getText().toString().equals("")){
            txt_name.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_password.getText().toString().equals("")){
            txt_password.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_age.getText().toString().equals("")){
            txt_age.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_bloodType.getText().toString().equals("")){
            txt_bloodType.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_telephone.getText().toString().equals("")){
            txt_telephone.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_province.getText().toString().equals("")){
            txt_province.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_canton.getText().toString().equals("")){
            txt_canton.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_district.getText().toString().equals("")){
            txt_district.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        if(txt_otherSigns.getText().toString().equals("")){
            txt_otherSigns.setError(getString(R.string.input_required));
            progress.setVisibility(View.INVISIBLE);
            return false;
        }
        return true;
    }
}