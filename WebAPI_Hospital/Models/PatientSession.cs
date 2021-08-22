using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class PatientSession
    {
        [Required(ErrorMessage ="Patient identification is required.")]
        public int Patient_identification { get; set; }
        [Required(ErrorMessage = "Patient name is required.")]
        public string Patient_name { get; set; }

        public PatientSession()
        {
        }
        public PatientSession(int Patient_identification, string Patient_name)
        {
            this.Patient_identification = Patient_identification;
            this.Patient_name = Patient_name;
        }
    }
}
