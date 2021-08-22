package cr.ac.ucr.movilapp_hospital.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import cr.ac.ucr.movilapp_hospital.Activities.DetailsAllergyActivity;
import cr.ac.ucr.movilapp_hospital.Activities.DetailsAppointmentActivity;
import cr.ac.ucr.movilapp_hospital.Model.AllergyData;
import cr.ac.ucr.movilapp_hospital.Model.AppointmentData;
import cr.ac.ucr.movilapp_hospital.R;

public class ItemAllergyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    AllergyData allergyData;

    Context context;
    TextView id;
    TextView allergyName;
    TextView diagnosisDateTime;
    ConstraintLayout itemPress;

    public ItemAllergyViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        id = (TextView) itemView.findViewById(R.id.id_allergy_item);
        allergyName = (TextView) itemView.findViewById(R.id.allergy_name_item);
        diagnosisDateTime = (TextView) itemView.findViewById(R.id.date_time_item);
        itemPress = (ConstraintLayout) itemView.findViewById(R.id.layout_eventPress_itemAllergy);

    }

    public void setOnClickListener(AllergyData allergyData) {
        itemPress.setOnClickListener(this);
        this.allergyData = allergyData;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), DetailsAllergyActivity.class);
        intent.putExtra("identification", String.valueOf(this.allergyData.getPatientIdentification()));
        intent.putExtra("name", this.allergyData.getPatientName());
        intent.putExtra("allergyName", String.valueOf(this.allergyData.getAllergyName()));
        intent.putExtra("allergyDescription", this.allergyData.getAllergyDescription());
        intent.putExtra("diagnosisDateTime", this.allergyData.getDiagnosisDateTime());
        intent.putExtra("medicine", this.allergyData.getMedicine());
        v.getContext().startActivity(intent);
    }
}
