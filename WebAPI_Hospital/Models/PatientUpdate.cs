using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class PatientUpdate
    {
        [Required(ErrorMessage = "Patient identification is required.")]
        public int Patient_identification { get; set; }
        [Required(ErrorMessage = "Civil status is required.")]
        public string Civil_status { get; set; }
        [Required(ErrorMessage = "Telephone is required.")]
        public string Telephone { get; set; }
        [Required(ErrorMessage = "Patient address is required.")]
        public Patient_Address Patient_addres { get; set; }

        public PatientUpdate()
        { }
    }
}
