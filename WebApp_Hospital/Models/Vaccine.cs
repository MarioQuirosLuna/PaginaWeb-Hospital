using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApp_Hospital.Models
{
    public class Vaccine
    {

        public int Id { get; set; }
        public int Id_patient { get; set; }
        public int Fk_patient_identification_card { get; set; }
        public string Patient_name { get; set; }
        public int Id_vaccine { get; set; }
        public string Vaccine_name { get; set; }
        public string Vaccine_description { get; set; }
        public DateTime Date_time { get; set; }
        public string Year { get; set; }
        public string Month { get; set; }
        public string Day { get; set; }
        public DateTime Next_dose_date_time { get; set; }
        public string NextYear { get; set; }
        public string NextMonth { get; set; }
        public string NextDay { get; set; }
        [Required(ErrorMessage = "Clinic name required.")]
        public string Clinic_name { get; set; }

        public Vaccine(int Id, int Fk_patient_identification_card, string Patient_name, string Vaccine_name, string Vaccine_description, DateTime Date_time, DateTime Next_dose_date_time, string Clinic_name)
        {
            this.Id = Id;
            this.Fk_patient_identification_card = Fk_patient_identification_card;
            this.Patient_name = Patient_name;
            this.Vaccine_name = Vaccine_name;
            this.Vaccine_description = Vaccine_description;
            this.Date_time = Date_time;
            this.Next_dose_date_time = Next_dose_date_time;
            this.Clinic_name = Clinic_name;
        }

        public Vaccine(int Fk_patient_identification_card, string Patient_name)
        {
            this.Id_patient = Id_patient;
            this.Fk_patient_identification_card = Fk_patient_identification_card;
            this.Patient_name = Patient_name;
        }
        public Vaccine()
        {
        }

    }
}
