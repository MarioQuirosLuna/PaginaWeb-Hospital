using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApp_Hospital.Models
{
    public class Patient
    {
        public int Id { get; set; }
        public int Patient_identification_card { get; set; }
        public string Patient_name { get; set; }

        public Patient() 
        {
        }

        public Patient(int Id, int Patient_identification_card, string Patient_name) 
        {
            this.Id = Id;
            this.Patient_identification_card = Patient_identification_card;
            this.Patient_name = Patient_name;
        }
    }
}
