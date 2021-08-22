using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class PatientAllergy
    {
        
        public int Id { get; set; }
        public int Patient_identification { get; set; }
        public string Patient_name { get; set; }
        public string Allergy_name { get; set; }
        public string Allergy_description { get; set; }
        public DateTime Diagnosis_dateTime { get; set; }
        public string Medicine { get; set; }

        public PatientAllergy()
        { }
        public PatientAllergy(int Id, int Patient_identification, string Patient_name, string Allergy_name, string Allergy_description, DateTime Diagnosis_dateTime, string Medicine)
        {
            this.Id = Id;
            this.Patient_identification = Patient_identification;
            this.Patient_name = Patient_name;
            this.Allergy_name = Allergy_name;
            this.Allergy_description = Allergy_description;
            this.Diagnosis_dateTime = Diagnosis_dateTime;
            this.Medicine = Medicine;
        }
    }
}
