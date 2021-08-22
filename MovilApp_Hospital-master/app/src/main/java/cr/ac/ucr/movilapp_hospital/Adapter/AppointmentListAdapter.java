package cr.ac.ucr.movilapp_hospital.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.movilapp_hospital.Model.AppointmentData;
import cr.ac.ucr.movilapp_hospital.R;

public class AppointmentListAdapter extends RecyclerView.Adapter<ItemAppointmentViewHolder> {

    private List<AppointmentData> listAppointments;
    private Context context;
    private AppointmentData appointment;

    public AppointmentListAdapter(Context context){
        this.listAppointments =new ArrayList<>();
        this.context = context;
    }

    @Override
    public ItemAppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemList = inflater.inflate(R.layout.item_appointment, parent, false);

        return new ItemAppointmentViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(ItemAppointmentViewHolder holder, int position) {
        appointment = listAppointments.get(position);
        holder.id.setText(String.valueOf(appointment.getId()));
        holder.clinicName.setText(appointment.getClinicName());
        holder.dateTime.setText(appointment.getDateTime());

        holder.setOnClickListener(appointment);
    }

    @Override
    public int getItemCount() { return listAppointments.size(); }


    public void addListAppointment(List<AppointmentData> list) {
        listAppointments.addAll(list);
        notifyDataSetChanged();
    }
}
