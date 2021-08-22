using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class Patient_Address
    {
        [Required(ErrorMessage = "Province is required.")]
        public string Province { get; set; }
        [Required(ErrorMessage = "Canton is required.")]
        public string Canton { get; set; }
        [Required(ErrorMessage = "District is required.")]
        public string District { get; set; }
        [Required(ErrorMessage = "Details address is required.")]
        public string Description { get; set; }

        public Patient_Address() 
        {
        }

        public Patient_Address(string Province, string Canton, string District, string Description)
        {
            this.Province = Province;
            this.Canton = Canton;
            this.District = District;
            this.Description = Description;
        }
    }
}
