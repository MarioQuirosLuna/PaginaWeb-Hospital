using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class PatientRegister
    {
        [Required(ErrorMessage="Patient identification is required.")]
        public int Patient_identification { get; set; }
        [Required(ErrorMessage = "Patient name is required.")]
        public string Patient_name { get; set; }
        [Required(ErrorMessage = "Patient password is required.")]
        public string Patient_password { get; set; }
        [Required(ErrorMessage = "Age is required.")]
        public int Age { get; set; }
        [Required(ErrorMessage = "Blood type is required.")]
        public string Blood_type { get; set; }
        [Required(ErrorMessage = "Civil status is required.")]
        public string Civil_status { get; set; }
        [Required(ErrorMessage = "Telephone is required.")]
        public string Telephone { get; set; }
        [Required(ErrorMessage = "Province is required.")]
        public string Province { get; set; }
        [Required(ErrorMessage = "Canton is required.")]
        public string Canton { get; set; }
        [Required(ErrorMessage = "District is required.")]
        public string District { get; set; }
        [Required(ErrorMessage = "Details address is required.")]
        public string Description { get; set; }

        public PatientRegister()
        {
        }

    }
}
