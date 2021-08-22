package cr.ac.ucr.movilapp_hospital.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.movilapp_hospital.Model.AllergyData;
import cr.ac.ucr.movilapp_hospital.Model.VaccineData;
import cr.ac.ucr.movilapp_hospital.R;

public class VaccineListAdapter extends RecyclerView.Adapter<ItemVaccineViewHolder>{

    private List<VaccineData> listVaccines;
    private Context context;
    private VaccineData vaccine;

    public VaccineListAdapter(Context context){
        this.listVaccines = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ItemVaccineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemList = inflater.inflate(R.layout.item_vaccine, parent, false);

        return new ItemVaccineViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(ItemVaccineViewHolder holder, int position) {
        vaccine = listVaccines.get(position);
        holder.id.setText(String.valueOf(vaccine.getId()));
        holder.vaccineName.setText(vaccine.getVaccineName());
        holder.dateTime.setText(vaccine.getDateTime());

        holder.setOnClickListener(vaccine);
    }

    @Override
    public int getItemCount() { return listVaccines.size(); }

    public void addListVaccine(List<VaccineData> list) {
        listVaccines.addAll(list);
        notifyDataSetChanged();
    }

}
