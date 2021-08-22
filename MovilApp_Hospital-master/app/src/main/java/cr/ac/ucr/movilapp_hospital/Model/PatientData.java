package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientData {
    @SerializedName("id")
    public int id;
    @SerializedName("patient_identification")
    public int patient_identification;
    @SerializedName("patient_name")
    public String patient_name;
    @SerializedName("age")
    public int age;
    @SerializedName("blood_type")
    public String blood_type;
    @SerializedName("civil_status")
    public String civil_status;
    @SerializedName("telephone")
    public String telephone;
    @SerializedName("patient_addres")
    @Expose
    public PatientAddres patient_addres;

    public PatientData() { }

    public int getId() { return id; }
    public int getPatient_identification() { return patient_identification; }
    public String getPatient_name() { return patient_name; }
    public int getAge() { return age; }
    public String getBlood_type() { return blood_type; }
    public String getCivil_status() { return civil_status; }
    public void setCivil_status(String civil_status) { this.civil_status = civil_status; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public PatientAddres getPatient_addres() { return patient_addres; }

    @Override
    public String toString() {
        return "PatientData{" +
                "id=" + id +
                ", patient_identification=" + patient_identification +
                ", patient_name='" + patient_name + '\'' +
                ", age=" + age +
                ", blood_type='" + blood_type + '\'' +
                ", civil_status='" + civil_status + '\'' +
                ", telephone='" + telephone + '\'' +
                ", patient_addres=" + patient_addres +
                '}';
    }
}
