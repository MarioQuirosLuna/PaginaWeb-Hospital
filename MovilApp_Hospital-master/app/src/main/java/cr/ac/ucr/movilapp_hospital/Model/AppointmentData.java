package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.SerializedName;

public class AppointmentData {

    @SerializedName("id")
    private Integer id;
    @SerializedName("patient_identification")
    private Integer patientIdentification;
    @SerializedName("patient_name")
    private String patientName;
    @SerializedName("doctor_code")
    private Integer doctorCode;
    @SerializedName("doctor_name")
    private String doctorName;
    @SerializedName("clinic_name")
    private String clinicName;
    @SerializedName("date_time")
    private String dateTime;
    @SerializedName("speciality")
    private String speciality;
    @SerializedName("diagnosis_description")
    private String diagnosisDescription;

    public AppointmentData(Integer id, Integer patientIdentification, String patientName, Integer doctorCode, String doctorName, String clinicName, String dateTime, String speciality, String diagnosisDescription) {
        this.id = id;
        this.patientIdentification = patientIdentification;
        this.patientName = patientName;
        this.doctorCode = doctorCode;
        this.doctorName = doctorName;
        this.clinicName = clinicName;
        this.dateTime = dateTime;
        this.speciality = speciality;
        this.diagnosisDescription = diagnosisDescription;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getPatientIdentification() { return patientIdentification; }
    public void setPatientIdentification(Integer patientIdentification) { this.patientIdentification = patientIdentification; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public Integer getDoctorCode() { return doctorCode; }
    public void setDoctorCode(Integer doctorCode) { this.doctorCode = doctorCode; }
    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
    public String getClinicName() { return clinicName; }
    public void setClinicName(String clinicName) { this.clinicName = clinicName; }
    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }
    public String getDiagnosisDescription() { return diagnosisDescription; }
    public void setDiagnosisDescription(String diagnosisDescription) { this.diagnosisDescription = diagnosisDescription; }

    @Override
    public String toString() {
        return "AppointmentData{" +
                "id=" + id +
                ", patientIdentification=" + patientIdentification +
                ", patientName='" + patientName + '\'' +
                ", doctorCode=" + doctorCode +
                ", doctorName='" + doctorName + '\'' +
                ", clinicName='" + clinicName + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", speciality='" + speciality + '\'' +
                ", diagnosisDescription='" + diagnosisDescription + '\'' +
                '}';
    }
}
