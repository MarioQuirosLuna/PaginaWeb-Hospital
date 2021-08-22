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
import cr.ac.ucr.movilapp_hospital.Model.AppointmentData;
import cr.ac.ucr.movilapp_hospital.R;

public class AllergyListAdapter extends RecyclerView.Adapter<ItemAllergyViewHolder>{

    private List<AllergyData> listAllergies;
    private Context context;
    private AllergyData allergy;

    public AllergyListAdapter(Context context){
        this.listAllergies = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ItemAllergyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemList = inflater.inflate(R.layout.item_allergy, parent, false);

        return new ItemAllergyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(ItemAllergyViewHolder holder, int position) {
        allergy = listAllergies.get(position);
        holder.id.setText(String.valueOf(allergy.getId()));
        holder.allergyName.setText(allergy.getAllergyName());
        holder.diagnosisDateTime.setText(allergy.getDiagnosisDateTime());

        holder.setOnClickListener(allergy);
    }

    @Override
    public int getItemCount() { return listAllergies.size(); }

    public void addListAllergy(List<AllergyData> list) {
        listAllergies.addAll(list);
        notifyDataSetChanged();
    }

}
