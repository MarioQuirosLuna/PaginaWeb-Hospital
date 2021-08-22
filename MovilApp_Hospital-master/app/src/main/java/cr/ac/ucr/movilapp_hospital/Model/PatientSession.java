package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.SerializedName;

public class PatientSession {
    @SerializedName("patient_identification")
    private Integer patientIdentification;
    @SerializedName("patient_name")
    private String patientName;

    public  PatientSession(){}

    public PatientSession(Integer patientIdentification, String patientName) {
        this.patientIdentification = patientIdentification;
        this.patientName = patientName;
    }

    public Integer getPatientIdentification() { return patientIdentification; }

    public void setPatientIdentification(Integer patientIdentification) { this.patientIdentification = patientIdentification; }

    public String getPatientName() { return patientName; }

    public void setPatientName(String patientName) { this.patientName = patientName; }

    @Override
    public String toString() {
        return "PatientSession{" +
                "patientIdentification=" + patientIdentification +
                ", patientName='" + patientName + '\'' +
                '}';
    }
}
