package cr.ac.ucr.movilapp_hospital.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import cr.ac.ucr.movilapp_hospital.Activities.DetailsAppointmentActivity;
import cr.ac.ucr.movilapp_hospital.Model.AppointmentData;
import cr.ac.ucr.movilapp_hospital.R;

public class ItemAppointmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    AppointmentData appointmentData;

    Context context;
    TextView id;
    TextView clinicName;
    TextView dateTime;
    ConstraintLayout itemPress;

    public ItemAppointmentViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        id = (TextView) itemView.findViewById(R.id.id_appointment_item);
        clinicName = (TextView) itemView.findViewById(R.id.clinic_name_item);
        dateTime = (TextView) itemView.findViewById(R.id.date_time_item);
        itemPress = (ConstraintLayout) itemView.findViewById(R.id.layout_eventPress_item);

    }

    public void setOnClickListener(AppointmentData appointmentData) {
        itemPress.setOnClickListener(this);
        this.appointmentData = appointmentData;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), DetailsAppointmentActivity.class);
        intent.putExtra("identification", String.valueOf(this.appointmentData.getPatientIdentification()));
        intent.putExtra("name", this.appointmentData.getPatientName());
        intent.putExtra("doctorCode", String.valueOf(this.appointmentData.getDoctorCode()));
        intent.putExtra("doctorName", this.appointmentData.getDoctorName());
        intent.putExtra("clinicName", this.appointmentData.getClinicName());
        intent.putExtra("date", this.appointmentData.getDateTime());
        intent.putExtra("speciality", this.appointmentData.getSpeciality());
        intent.putExtra("diagnosis", this.appointmentData.getDiagnosisDescription());
        v.getContext().startActivity(intent);
    }
}
