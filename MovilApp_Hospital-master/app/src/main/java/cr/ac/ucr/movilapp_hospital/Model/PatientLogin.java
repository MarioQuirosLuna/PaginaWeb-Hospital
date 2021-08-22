package cr.ac.ucr.movilapp_hospital.Model;

import com.google.gson.annotations.SerializedName;

public class PatientLogin {
    @SerializedName("identification")
    private Integer identification;
    @SerializedName("password")
    private String password;

    public PatientLogin(){}

    public PatientLogin(Integer identification, String password) {
        this.identification = identification;
        this.password = password;
    }

    public Integer getIdentification() { return identification; }

    public void setIdentification(Integer identification) { this.identification = identification; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "PatientLogin{" +
                "identification=" + identification +
                ", password='" + password + '\'' +
                '}';
    }
}
