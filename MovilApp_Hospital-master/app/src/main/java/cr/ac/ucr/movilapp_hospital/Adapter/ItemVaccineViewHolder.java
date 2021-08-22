package cr.ac.ucr.movilapp_hospital.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import cr.ac.ucr.movilapp_hospital.Activities.DetailsAllergyActivity;
import cr.ac.ucr.movilapp_hospital.Activities.DetailsVaccineActivity;
import cr.ac.ucr.movilapp_hospital.Model.AllergyData;
import cr.ac.ucr.movilapp_hospital.Model.VaccineData;
import cr.ac.ucr.movilapp_hospital.R;

public class ItemVaccineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    VaccineData vaccineData;

    Context context;
    TextView id;
    TextView vaccineName;
    TextView dateTime;
    ConstraintLayout itemPress;

    public ItemVaccineViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        id = (TextView) itemView.findViewById(R.id.id_vaccine_item);
        vaccineName = (TextView) itemView.findViewById(R.id.vaccine_name_item);
        dateTime = (TextView) itemView.findViewById(R.id.date_time_item);
        itemPress = (ConstraintLayout) itemView.findViewById(R.id.layout_eventPress_itemVaccine);

    }

    public void setOnClickListener(VaccineData vaccineData) {
        itemPress.setOnClickListener(this);
        this.vaccineData = vaccineData;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), DetailsVaccineActivity.class);
        intent.putExtra("identification", String.valueOf(this.vaccineData.getPatientIdentification()));
        intent.putExtra("name", this.vaccineData.getPatientName());
        intent.putExtra("vaccineName", String.valueOf(this.vaccineData.getVaccineName()));
        intent.putExtra("vaccineDescription", this.vaccineData.getVaccineDescription());
        intent.putExtra("dateTime", this.vaccineData.getDateTime());
        intent.putExtra("nextDoseDateTime", this.vaccineData.getNextDoseDateTime());
        intent.putExtra("clinicName", this.vaccineData.getClinicName());
        v.getContext().startActivity(intent);
   }
}
