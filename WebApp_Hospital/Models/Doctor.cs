using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApp_Hospital.Models
{
    public class Doctor
    {
        public int Id { get; set; }
        [Required(ErrorMessage = "Identification required*")]
        public int Doctor_identification_card { get; set; }
        [Required(ErrorMessage = "Doctor code required*")]
        public int Doctor_code { get; set; }
        public string Doctor_name { get; set; }
        [Required(ErrorMessage = "Password required*")]
        public string Doctor_password { get; set; }
    }
}
