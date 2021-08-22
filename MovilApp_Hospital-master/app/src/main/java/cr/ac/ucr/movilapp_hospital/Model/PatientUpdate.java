package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.SerializedName;

public class PatientUpdate {
    @SerializedName("patient_identification")
    private Integer patientIdentification;
    @SerializedName("civil_status")
    private String civilStatus;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("patient_addres")
    private PatientAddres patientAddres;

    public PatientUpdate(Integer patientIdentification, String civilStatus, String telephone, PatientAddres patientAddres) {
        this.patientIdentification = patientIdentification;
        this.civilStatus = civilStatus;
        this.telephone = telephone;
        this.patientAddres = patientAddres;
    }

    public Integer getPatientIdentification() { return patientIdentification; }
    public void setPatientIdentification(Integer patientIdentification) { this.patientIdentification = patientIdentification; }
    public String getCivilStatus() { return civilStatus; }
    public void setCivilStatus(String civilStatus) { this.civilStatus = civilStatus; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public PatientAddres getPatientAddres() { return patientAddres; }
    public void setPatientAddres(PatientAddres patientAddres) { this.patientAddres = patientAddres; }

    @Override
    public String toString() {
        return "PatientUpdate{" +
                "patientIdentification=" + patientIdentification +
                ", civilStatus='" + civilStatus + '\'' +
                ", telephone='" + telephone + '\'' +
                ", patientAddres=" + patientAddres +
                '}';
    }
}
