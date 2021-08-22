using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using WebApp_Hospital.Models;

namespace WebApp_Hospital.Controllers
{
    public class PatientController : Controller
    {
        public IConfiguration Configuration { get; }

        public PatientController(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        [HttpGet]
        public async Task<IActionResult> Index()
        {
            List<Patient> patients = new List<Patient>();

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getPatients";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            int Id = Int32.Parse(dataReader["id"].ToString());
                            int PatientIdentification = Int32.Parse(dataReader["patient_identification_card"].ToString());
                            string Patiend_name = dataReader["patient_name"].ToString();

                            patients.Add(new Patient(Id, PatientIdentification, Patiend_name));
                        }//while
                        connection.Close();
                    }
                }
            }

            return View(patients);
        }

        [HttpGet]
        public async Task<IActionResult> IndexVaccine()
        {
            List<Patient> patients = new List<Patient>();

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getPatients";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            int Id = Int32.Parse(dataReader["id"].ToString());
                            int PatientIdentification = Int32.Parse(dataReader["patient_identification_card"].ToString());
                            string Patiend_name = dataReader["patient_name"].ToString();

                            patients.Add(new Patient(Id, PatientIdentification, Patiend_name));
                        }//while
                        connection.Close();
                    }
                }
            }

            return View(patients);
        }

        [HttpGet]
        public async Task<IActionResult> IndexAllergy()
        {
            List<Patient> patients = new List<Patient>();

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getPatients";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            int Id = Int32.Parse(dataReader["id"].ToString());
                            int PatientIdentification = Int32.Parse(dataReader["patient_identification_card"].ToString());
                            string Patiend_name = dataReader["patient_name"].ToString();

                            patients.Add(new Patient(Id, PatientIdentification, Patiend_name));
                        }//while
                        connection.Close();
                    }
                }
            }

            return View(patients);
        }

    }
}
