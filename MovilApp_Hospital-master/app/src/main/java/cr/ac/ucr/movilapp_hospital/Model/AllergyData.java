package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.SerializedName;

public class AllergyData {
    @SerializedName("id")
    private Integer id;
    @SerializedName("patient_identification")
    private Integer patientIdentification;
    @SerializedName("patient_name")
    private String patientName;
    @SerializedName("allergy_name")
    private String allergyName;
    @SerializedName("allergy_description")
    private String allergyDescription;
    @SerializedName("diagnosis_dateTime")
    private String diagnosisDateTime;
    @SerializedName("medicine")
    private String medicine;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getPatientIdentification() { return patientIdentification; }
    public void setPatientIdentification(Integer patientIdentification) { this.patientIdentification = patientIdentification; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getAllergyName() { return allergyName; }
    public void setAllergyName(String allergyName) { this.allergyName = allergyName; }
    public String getAllergyDescription() { return allergyDescription; }
    public void setAllergyDescription(String allergyDescription) { this.allergyDescription = allergyDescription; }
    public String getDiagnosisDateTime() { return diagnosisDateTime; }
    public void setDiagnosisDateTime(String diagnosisDateTime) { this.diagnosisDateTime = diagnosisDateTime; }
    public String getMedicine() { return medicine; }
    public void setMedicine(String medicine) { this.medicine = medicine; }

    @Override
    public String toString() {
        return "AllergyData{" +
                "id=" + id +
                ", patientIdentification=" + patientIdentification +
                ", patientName='" + patientName + '\'' +
                ", allergyName='" + allergyName + '\'' +
                ", allergyDescription='" + allergyDescription + '\'' +
                ", diagnosisDateTime='" + diagnosisDateTime + '\'' +
                ", medicine='" + medicine + '\'' +
                '}';
    }
}
