using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class PatientAppointment
    {
        public int Id { get; set; }
        public int Patient_identification { get; set; }
        public string Patient_name { get; set; }
        public int Doctor_code { get; set; }
        public string Doctor_name { get; set; }
        public string Clinic_name { get; set; }
        public DateTime Date_time { get; set; }
        public string Speciality { get; set; }
        public string Diagnosis_description { get; set; }

        public PatientAppointment()
        { }
        public PatientAppointment(int Id, int Patient_identification, string Patient_name, int Doctor_code, string Doctor_name, string Clinic_name, DateTime Date_time, string Speciality, string Diagnosis_description)
        {
            this.Id = Id;
            this.Patient_identification = Patient_identification;
            this.Patient_name = Patient_name;
            this.Doctor_code = Doctor_code;
            this.Doctor_name = Doctor_name;
            this.Clinic_name = Clinic_name;
            this.Date_time = Date_time;
            this.Speciality = Speciality;
            this.Diagnosis_description = Diagnosis_description;
        }
    }
}
