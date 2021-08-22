using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class PatientVaccine
    {
        public int Id { get; set; }
        public int Patient_identification { get; set; }
        public string Patient_name { get; set; }
        public string Vaccine_name { get; set; }
        public string Vaccine_description { get; set; }
        public DateTime Date_time { get; set; }
        public DateTime Next_dose_date_time { get; set; }
        public string Clinic_name { get; set; }

        public PatientVaccine()
        { }
        public PatientVaccine(int Id, int Patient_identification, string Patient_name, string Vaccine_name, string Vaccine_description, DateTime Date_time, DateTime Next_dose_date_time, string Clinic_name)
        {
            this.Id = Id;
            this.Patient_identification = Patient_identification;
            this.Patient_name = Patient_name;
            this.Vaccine_name = Vaccine_name;
            this.Vaccine_description = Vaccine_description;
            this.Date_time = Date_time;
            this.Next_dose_date_time = Next_dose_date_time;
            this.Clinic_name = Clinic_name;
        }
    }
}
