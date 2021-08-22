package cr.ac.ucr.movilapp_hospital.API;

import java.util.List;

import cr.ac.ucr.movilapp_hospital.Model.AllergyData;
import cr.ac.ucr.movilapp_hospital.Model.AppointmentData;
import cr.ac.ucr.movilapp_hospital.Model.PatientData;
import cr.ac.ucr.movilapp_hospital.Model.PatientLogin;
import cr.ac.ucr.movilapp_hospital.Model.PatientRegister;
import cr.ac.ucr.movilapp_hospital.Model.PatientSession;
import cr.ac.ucr.movilapp_hospital.Model.PatientUpdate;
import cr.ac.ucr.movilapp_hospital.Model.VaccineData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API_HospitalPatient {
    @GET("showDataPatient")
    Call<PatientData> getPatientData(@Query("identification") int identification);

    @GET("showAppointmentPatient")
    Call<List<AppointmentData>> getAppointments(@Query("identification") int identification);

    @GET("showAllergyPatient")
    Call<List<AllergyData>> getAllergies(@Query("identification") int identification);

    @GET("showVaccinePatient")
    Call<List<VaccineData>> getVaccines(@Query("identification") int identification);

    @POST("loginPatient")
    Call<PatientSession> loginPatient(@Body PatientLogin patientLogin);

    @POST("createPatient")
    Call<PatientData> addPatient(@Body PatientRegister patientRegister);

    @PUT("updatePatient")
    Call<PatientUpdate> updatePatient(@Body PatientUpdate patientUpdate);

}
