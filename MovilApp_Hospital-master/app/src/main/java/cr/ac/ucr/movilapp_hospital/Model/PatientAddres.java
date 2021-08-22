package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.SerializedName;

public class PatientAddres {
    @SerializedName("province")
    public String province;
    @SerializedName("canton")
    public String canton;
    @SerializedName("district")
    public String district;
    @SerializedName("description")
    public String description;

    public PatientAddres(){}

    public PatientAddres(String province, String canton, String district, String description) {
        this.province = province;
        this.canton = canton;
        this.district = district;
        this.description = description;
    }

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
        return province +", "+ canton +", "+ district;
    }
}
