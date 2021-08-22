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
import cr.ac.ucr.movilapp_hospital.Adapter.VaccineListAdapter;
import cr.ac.ucr.movilapp_hospital.Model.AllergyData;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.Model.VaccineData;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShowVaccineActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    private Retrofit retrofit;

    private VaccineListAdapter vaccineListAdapter;

    private TextView txt_identification;
    private TextView txt_name;

    private RecyclerView reciclerView;
    private TextView textNotData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_vaccine);

        textNotData = (TextView) findViewById(R.id.recycler_empty_vaccine);

        txt_identification = (TextView) findViewById(R.id.Patient_Identification_Vaccine);
        txt_name = (TextView) findViewById(R.id.Patient_Name_Vaccine);

        reciclerView = (RecyclerView) findViewById(R.id.show_Vaccines_Patient_RecyclerView);

        vaccineListAdapter = new VaccineListAdapter(this);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        reciclerView.setAdapter(vaccineListAdapter);
        reciclerView.setHasFixedSize(true);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            txt_identification.setText(extra.getString("identification"));
            txt_name.setText(extra.getString("name"));

            retrofit = RetrofitSingleton.getRetrofit();

            getVaccines(Integer.parseInt(extra.getString("identification")));
        }

    }

    public void getVaccines(int identification){

        API_HospitalPatient api = retrofit.create(API_HospitalPatient.class);

        Call<List<VaccineData>> call = api.getVaccines(identification);

        call.enqueue(new Callback<List<VaccineData>>() {
            @Override
            public void onResponse(Call<List<VaccineData>> call, Response<List<VaccineData>> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }

                List<VaccineData> list = response.body();

                if(!list.isEmpty()){
                    vaccineListAdapter.addListVaccine(list);
                }
                showNotData(list.isEmpty());
            }

            @Override
            public void onFailure(Call<List<VaccineData>> call, Throwable t) {
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