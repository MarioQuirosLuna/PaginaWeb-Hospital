package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.SerializedName;

public class PatientRegister {

    @SerializedName("patient_identification")
    private Integer patientIdentification;
    @SerializedName("patient_name")
    private String patientName;
    @SerializedName("patient_password")
    private String patientPassword;
    @SerializedName("age")
    private Integer age;
    @SerializedName("blood_type")
    private String bloodType;
    @SerializedName("civil_status")
    private String civilStatus;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("province")
    private String province;
    @SerializedName("canton")
    private String canton;
    @SerializedName("district")
    private String district;
    @SerializedName("description")
    private String description;

    public PatientRegister(Integer patientIdentification, String patientName, String patientPassword, Integer age, String bloodType, String civilStatus, String telephone, String province, String canton, String district, String description) {
        this.patientIdentification = patientIdentification;
        this.patientName = patientName;
        this.patientPassword = patientPassword;
        this.age = age;
        this.bloodType = bloodType;
        this.civilStatus = civilStatus;
        this.telephone = telephone;
        this.province = province;
        this.canton = canton;
        this.district = district;
        this.description = description;
    }

    public Integer getPatientIdentification() { return patientIdentification; }
    public void setPatientIdentification(Integer patientIdentification) { this.patientIdentification = patientIdentification; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getPatientPassword() { return patientPassword; }
    public void setPatientPassword(String patientPassword) { this.patientPassword = patientPassword; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }
    public String getCivilStatus() { return civilStatus; }
    public void setCivilStatus(String civilStatus) { this.civilStatus = civilStatus; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getCanton() { return canton; }
    public void setCanton(String canton) { this.canton = canton; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "PatientRegister{" +
                "patientIdentification=" + patientIdentification +
                ", patientName='" + patientName + '\'' +
                ", patientPassword='" + patientPassword + '\'' +
                ", age=" + age +
                ", bloodType='" + bloodType + '\'' +
                ", civilStatus='" + civilStatus + '\'' +
                ", telephone='" + telephone + '\'' +
                ", province='" + province + '\'' +
                ", canton='" + canton + '\'' +
                ", district='" + district + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
