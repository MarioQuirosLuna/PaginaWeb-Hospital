package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cr.ac.ucr.movilapp_hospital.API.API_HospitalPatient;
import cr.ac.ucr.movilapp_hospital.Adapter.AllergyListAdapter;
import cr.ac.ucr.movilapp_hospital.Adapter.AppointmentListAdapter;
import cr.ac.ucr.movilapp_hospital.Model.AllergyData;
import cr.ac.ucr.movilapp_hospital.Model.AppointmentData;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShowAllergyActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    private Retrofit retrofit;

    private AllergyListAdapter allergyListAdapter;

    private TextView txt_identification;
    private TextView txt_name;

    private RecyclerView reciclerView;
    private TextView textNotData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_allergy);

        textNotData = (TextView) findViewById(R.id.recycler_empty_allergy);

        txt_identification = (TextView) findViewById(R.id.Patient_Identification_Allergy);
        txt_name = (TextView) findViewById(R.id.Patient_Name_Allergy);

        reciclerView = (RecyclerView) findViewById(R.id.show_Allergies_Patient_RecyclerView);

        allergyListAdapter = new AllergyListAdapter(this);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        reciclerView.setAdapter(allergyListAdapter);
        reciclerView.setHasFixedSize(true);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            txt_identification.setText(extra.getString("identification"));
            txt_name.setText(extra.getString("name"));

            retrofit = RetrofitSingleton.getRetrofit();

            getAllergies(Integer.parseInt(extra.getString("identification")));
        }

    }

    public void getAllergies(int identification){

        API_HospitalPatient api = retrofit.create(API_HospitalPatient.class);

        Call<List<AllergyData>> call = api.getAllergies(identification);

        call.enqueue(new Callback<List<AllergyData>>() {
            @Override
            public void onResponse(Call<List<AllergyData>> call, Response<List<AllergyData>> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }

                List<AllergyData> list = response.body();

                if(!list.isEmpty()){
                    allergyListAdapter.addListAllergy(list);
                }
                showNotData(list.isEmpty());
            }

            @Override
            public void onFailure(Call<List<AllergyData>> call, Throwable t) {
                Log.e(TAG, " onFailure1: "+t.getMessage());
            }
        });

    }

    private void showNotData(boolean isEmpty){
        if(isEmpty){
            textNotData.setVisibility(View.VISIBLE);
            reciclerView.setVisibility(View.INVISIBLE);
        }else{
            textNotData.setVisibility(View.INVISIBLE);
            reciclerView.setVisibility(View.VISIBLE);
        }
    }

}