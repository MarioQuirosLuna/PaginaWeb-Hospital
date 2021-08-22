package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import cr.ac.ucr.movilapp_hospital.API.API_HospitalPatient;
import cr.ac.ucr.movilapp_hospital.Adapter.AppointmentListAdapter;
import cr.ac.ucr.movilapp_hospital.Model.AppointmentData;
import cr.ac.ucr.movilapp_hospital.Model.PatientData;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShowAppointmentsActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    private Retrofit retrofit;

    private AppointmentListAdapter appointmentListAdapter;

    private TextView txt_identification;
    private TextView txt_name;

    private RecyclerView reciclerView;
    private TextView textNotData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_appointments);

        textNotData = (TextView) findViewById(R.id.recycler_empty_appointment);

        txt_identification = (TextView) findViewById(R.id.Patient_Identification_Appointment_a);
        txt_name = (TextView) findViewById(R.id.Patient_Name_Appointment);

        reciclerView = (RecyclerView) findViewById(R.id.show_Appointments_Patient_RecyclerView);

        appointmentListAdapter = new AppointmentListAdapter(this);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        reciclerView.setAdapter(appointmentListAdapter);
        reciclerView.setHasFixedSize(true);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            txt_identification.setText(extra.getString("identification"));
            txt_name.setText(extra.getString("name"));

            retrofit = RetrofitSingleton.getRetrofit();

            getAppointments(Integer.parseInt(extra.getString("identification")));
        }
    }

    public void getAppointments(int identification){

        API_HospitalPatient api = retrofit.create(API_HospitalPatient.class);

        Call<List<AppointmentData>> call = api.getAppointments(identification);

        call.enqueue(new Callback<List<AppointmentData>>() {
            @Override
            public void onResponse(Call<List<AppointmentData>> call, Response<List<AppointmentData>> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }

                List<AppointmentData> list = response.body();

                if(!list.isEmpty()){
                    appointmentListAdapter.addListAppointment(list);
                }
                showNotData(list.isEmpty());

            }

            @Override
            public void onFailure(Call<List<AppointmentData>> call, Throwable t) {
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