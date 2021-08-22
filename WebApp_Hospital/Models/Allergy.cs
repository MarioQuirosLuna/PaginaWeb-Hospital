using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApp_Hospital.Models
{
    public class Allergy
    {
        public int Id { get; set; }
        public int Id_patient { get; set; }
        public int Fk_patient_identification_card { get; set; }
        public string Patient_name { get; set; }
        public int Id_allergy { get; set; }
        public string Allergy_name { get; set; }
        public string Allergy_description { get; set; }
        public DateTime Diagnosis_date_time { get; set; }
        public string Year { get; set; }
        public string Month { get; set; }
        public string Day { get; set; }
        [Required(ErrorMessage = "Medicine required*")]
        public string Medicine { get; set; }

        public Allergy(int Id, int Fk_patient_identification_card, string Patient_name, string Allergy_name, string Allergy_description, DateTime Diagnosis_date_time, string Medicine)
        {
            this.Id = Id;
            this.Fk_patient_identification_card = Fk_patient_identification_card;
            this.Patient_name = Patient_name;
            this.Allergy_name = Allergy_name;
            this.Allergy_description = Allergy_description;
            this.Diagnosis_date_time = Diagnosis_date_time;
            this.Medicine = Medicine;
        }

        public Allergy(int Fk_patient_identification_card, string Patient_name)
        {
            this.Id_patient = Id_patient;
            this.Fk_patient_identification_card = Fk_patient_identification_card;
            this.Patient_name = Patient_name;
        }
        public Allergy()
        {
        }

    }
}
