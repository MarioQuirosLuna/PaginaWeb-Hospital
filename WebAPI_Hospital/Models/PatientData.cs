using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class PatientData
    {
        [Required(ErrorMessage = "Id is required.")]
        public int Id { get; set; }
        [Required(ErrorMessage = "Patient identification is required.")]
        public int Patient_identification { get; set; }
        [Required(ErrorMessage = "Patient name is required.")]
        public string Patient_name { get; set; }
        [Required(ErrorMessage = "Age is required.")]
        public int Age { get; set; }
        [Required(ErrorMessage = "Blood type is required.")]
        public string Blood_type { get; set; }
        [Required(ErrorMessage = "Civil status is required.")]
        public string Civil_status { get; set; }
        [Required(ErrorMessage = "Telephone is required.")]
        public string Telephone { get; set; }
        [Required(ErrorMessage = "Patient address is required.")]
        public Patient_Address Patient_addres { get; set; }

        public PatientData()
        {
        }
        public PatientData(int Id, int Patient_identification, string Patient_name, int Age, string Blood_type, string Civil_status, string Telephone, Patient_Address Patient_addres)
        {
            this.Id = Id;
            this.Patient_identification = Patient_identification;
            this.Patient_name = Patient_name;
            this.Age = Age;
            this.Blood_type = Blood_type;
            this.Civil_status = Civil_status;
            this.Telephone = Telephone;
            this.Patient_addres = Patient_addres;
        }
    }
}
