using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPI_Hospital.Models
{
    public class PatientLogin
    {
        [Required(ErrorMessage="Identification is required.")]
        public int Identification { get; set; }
        [Required(ErrorMessage = "Password is required.")]
        public string Password { get; set; }
        public PatientLogin() { }
        public PatientLogin(int Identification, string Password) 
        {
            this.Identification = Identification;
            this.Password = Password;
        }
    }
}
