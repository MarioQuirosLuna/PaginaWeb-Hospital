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
import android.widget.TextView;

import cr.ac.ucr.movilapp_hospital.API.API_HospitalPatient;
import cr.ac.ucr.movilapp_hospital.Model.PatientAddres;
import cr.ac.ucr.movilapp_hospital.Model.PatientData;
import cr.ac.ucr.movilapp_hospital.Model.PatientUpdate;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UpdatePatientActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    private Retrofit retrofit;

    private ProgressBar progress;
    private Spinner options_civil_state;

    private TextView txt_identification;
    private TextView txt_name;
    private EditText txt_telephone;
    private EditText txt_province;
    private EditText txt_canton;
    private EditText txt_district;
    private EditText txt_otherSigns;

    private Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_patient);

        progress = (ProgressBar) findViewById(R.id.progressAnimationUpdate);

        options_civil_state = (Spinner) findViewById(R.id.Patient_Civil_State_Update);
        txt_identification = (TextView) findViewById(R.id.Patient_Identification_Update);
        txt_name = (TextView) findViewById(R.id.Patient_Name_Update);
        txt_telephone = (EditText) findViewById(R.id.Patient_Telephone_Update);
        txt_province = (EditText) findViewById(R.id.Patient_Province_Update);
        txt_canton = (EditText) findViewById(R.id.Patient_Canton_Update);
        txt_district = (EditText) findViewById(R.id.Patient_District_Update);
        txt_otherSigns = (EditText) findViewById(R.id.Patient_Description_Update);

        btn_update = (Button) findViewById(R.id.Update_Button_Update);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options_civil_state, android.R.layout.simple_spinner_item);
        options_civil_state.setAdapter(adapter);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            txt_identification.setText(extra.getString("identification"));
            txt_name.setText(extra.getString("name"));
            txt_telephone.setText(extra.getString("telephone"));
            txt_province.setText(extra.getString("province"));
            txt_canton.setText(extra.getString("canton"));
            txt_district.setText(extra.getString("district"));
            txt_otherSigns.setText(extra.getString("description"));
        }

        btn_update.setOnClickListener(v -> {
            progress.setVisibility(View.VISIBLE);
            if(input_Validations()) {
                retrofit = RetrofitSingleton.getRetrofit();

                updatePatient(
                        new PatientUpdate(
                                Integer.parseInt(txt_identification.getText().toString()),
                                options_civil_state.getSelectedItem().toString(),
                                txt_telephone.getText().toString().trim(),
                                new PatientAddres(
                                        txt_province.getText().toString().trim(),
                                        txt_canton.getText().toString().trim(),
                                        txt_district.getText().toString().trim(),
                                        txt_otherSigns.getText().toString().trim()
                                )
                        )
                );
            }
        });
    }

    public void updatePatient(PatientUpdate patientUpdate){

        API_HospitalPatient api = retrofit.create(API_HospitalPatient.class);

        Call<PatientUpdate> call = api.updatePatient(patientUpdate);

        call.enqueue(new Callback<PatientUpdate>() {
            @Override
            public void onResponse(Call<PatientUpdate> call, Response<PatientUpdate> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }
                onBackPressed();
            }

            @Override
            public void onFailure(Call<PatientUpdate> call, Throwable t) {
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