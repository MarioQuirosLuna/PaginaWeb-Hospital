using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApp_Hospital.Models
{
    public class Appointment
    {
        public int Id { get; set; }
        public int Id_patient { get; set; }
        public int Fk_patient_identification_card { get; set; }
        public string Patient_name { get; set; }
        public int Fk_doctor_identification_card { get; set; }
        public int Doctor_code { get; set; }
        public string Doctor_name { get; set; }
        [Required(ErrorMessage="Clinic name required.")]
        public string Clinic_name { get; set; }
        public DateTime Date_time { get; set; }
        public string Year { get; set; }
        public string Month { get; set; }
        public string Day { get; set; }
        public string Hour { get; set; }

        [Required(ErrorMessage = "Speciality name required.")]
        public string Speciality { get; set; }
        public string Diagnosis { get; set; }

        public Appointment(int Id, int Id_patient, int Fk_patient_identification_card, string Patient_name, int Doctor_code, string Doctor_name, string Clinic_name, DateTime Date_time, string Speciality, string Diagnosis) 
        {
            this.Id = Id;
            this.Id_patient = Id_patient;
            this.Fk_patient_identification_card = Fk_patient_identification_card;
            this.Patient_name = Patient_name;
            this.Doctor_code = Doctor_code;
            this.Doctor_name = Doctor_name;
            this.Clinic_name = Clinic_name;
            this.Date_time = Date_time;
            this.Speciality = Speciality;
            this.Diagnosis = Diagnosis;
        }
        public Appointment(int Id_patient, int Fk_patient_identification_card, string Patient_name) 
        {
            this.Id_patient = Id_patient;
            this.Fk_patient_identification_card = Fk_patient_identification_card;
            this.Patient_name = Patient_name;
        }
        public Appointment() 
        {
        }
    }
}
