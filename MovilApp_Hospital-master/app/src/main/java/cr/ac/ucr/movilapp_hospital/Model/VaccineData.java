package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.SerializedName;

public class VaccineData {

    @SerializedName("id")
    private Integer id;
    @SerializedName("patient_identification")
    private Integer patientIdentification;
    @SerializedName("patient_name")
    private String patientName;
    @SerializedName("vaccine_name")
    private String vaccineName;
    @SerializedName("vaccine_description")
    private String vaccineDescription;
    @SerializedName("date_time")
    private String dateTime;
    @SerializedName("next_dose_date_time")
    private String nextDoseDateTime;
    @SerializedName("clinic_name")
    private String clinicName;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getPatientIdentification() { return patientIdentification; }
    public void setPatientIdentification(Integer patientIdentification) { this.patientIdentification = patientIdentification; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getVaccineName() { return vaccineName; }
    public void setVaccineName(String vaccineName) { this.vaccineName = vaccineName; }
    public String getVaccineDescription() { return vaccineDescription; }
    public void setVaccineDescription(String vaccineDescription) { this.vaccineDescription = vaccineDescription; }
    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public String getNextDoseDateTime() { return nextDoseDateTime; }
    public void setNextDoseDateTime(String nextDoseDateTime) { this.nextDoseDateTime = nextDoseDateTime; }
    public String getClinicName() { return clinicName; }
    public void setClinicName(String clinicName) { this.clinicName = clinicName; }

    @Override
    public String toString() {
        return "VaccineData{" +
                "id=" + id +
                ", patientIdentification=" + patientIdentification +
                ", patientName='" + patientName + '\'' +
                ", vaccineName='" + vaccineName + '\'' +
                ", vaccineDescription='" + vaccineDescription + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", nextDoseDateTime='" + nextDoseDateTime + '\'' +
                ", clinicName='" + clinicName + '\'' +
                '}';
    }
}
