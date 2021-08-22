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
    public class AllergyController : Controller
    {
        public IConfiguration Configuration { get; }

        public AllergyController(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        [HttpGet]
        public async Task<IActionResult> Index(int? id)
        {
            List<Allergy> allergies = new List<Allergy>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {

                    string sqlQuery = $"exec getAllergyByPatientIdentification @identification ='{id}'";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            int Id = Int32.Parse(dataReader["id"].ToString());
                            int PatientIdentification = Int32.Parse(dataReader["fk_patient_identification_card"].ToString());
                            string Patiend_name = dataReader["patient_name"].ToString();
                            string Allergy_name = dataReader["allergy_name"].ToString();
                            string Allergy_description = dataReader["allergy_description"].ToString();
                            DateTime Date = (DateTime)dataReader["diagnosis_date_time"];
                            string Medicine = dataReader["medicine"].ToString();

                            allergies.Add(new Allergy(Id, PatientIdentification, Patiend_name, Allergy_name, Allergy_description, Date, Medicine));
                        }//while
                        connection.Close();
                    }
                }
            }

            ViewBag.IdPatient = id;

            return View(allergies);
        }

        [HttpGet]
        public async Task<IActionResult> Details(int? id)
        {

            //TODO: Validate not found

            Allergy temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getAllergyById @id='{id}'";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            int Id = Int32.Parse(dataReader["id"].ToString());
                            int PatientIdentification = Int32.Parse(dataReader["fk_patient_identification_card"].ToString());
                            string Patiend_name = dataReader["patient_name"].ToString();
                            string Allergy_name = dataReader["allergy_name"].ToString();
                            string Allergy_description = dataReader["allergy_description"].ToString();
                            DateTime Date = (DateTime)dataReader["diagnosis_date_time"];
                            string Medicine = dataReader["medicine"].ToString();

                            temp = (new Allergy(Id, PatientIdentification, Patiend_name, Allergy_name, Allergy_description, Date, Medicine));

                        }//while
                        connection.Close();
                    }
                }
            }

            return View(temp);
        }

        // GET: Vaccine/Create
        [HttpGet]
        public async Task<IActionResult> Create(int? id)
        {

            //TODO: Validate not found

            Allergy temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec API_getPatientByIdentification @identification='{id}'";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            int PatientIdentification = Int32.Parse(dataReader["patient_identification_card"].ToString());
                            string Patiend_name = dataReader["patient_name"].ToString();

                            temp = new Allergy(PatientIdentification, Patiend_name);
                        }//while
                        connection.Close();
                    }
                }
            }

            return View(temp);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(Allergy allergy)
        {
            string dateCreate = "";
            if (ModelState.IsValid)
            {
                if (allergy.Year.Equals("Year") || allergy.Day.Equals("Day") || allergy.Month.Equals("Month"))
                {
                    ViewBag.ErrorDates = "Check the dates*";
                    return View(allergy);
                }

                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                var connection = new SqlConnection(connectionString);

                dateCreate = allergy.Year + "-" + allergy.Day + "-" + allergy.Month + " 00:00:01";

                string sqlQuery = $"exec addPatientAllergy @patient={allergy.Fk_patient_identification_card}, @allergy='{allergy.Allergy_name}', @date_time='{dateCreate}', @medicine='{allergy.Medicine}'";
                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    await command.ExecuteReaderAsync();
                    connection.Close();
                }
                return RedirectToAction("Index", new { id = allergy.Fk_patient_identification_card });
            }

            return View(allergy);
        }

        [HttpGet]
        public async Task<IActionResult> Edit(int? id)
        {
            //TODO: Validate not found

            Allergy temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getAllergyById @id='{id}'";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            int Id = Int32.Parse(dataReader["id"].ToString());
                            int PatientIdentification = Int32.Parse(dataReader["fk_patient_identification_card"].ToString());
                            string Patiend_name = dataReader["patient_name"].ToString();
                            string Allergy_name = dataReader["allergy_name"].ToString();
                            string Allergy_description = dataReader["allergy_description"].ToString();
                            DateTime Date = (DateTime)dataReader["diagnosis_date_time"];
                            string Medicine = dataReader["medicine"].ToString();

                            temp = new Allergy(Id, PatientIdentification, Patiend_name, Allergy_name, Allergy_description, Date, Medicine);
                        }//while
                        connection.Close();
                    }
                }
            }

            return View(temp);
        }

        //[HttpPut]
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(Allergy allergy)
        {
            string dateCreate = "";
            if (ModelState.IsValid)
            {
                if (allergy.Year.Equals("Year") || allergy.Day.Equals("Day") || allergy.Month.Equals("Month"))
                {
                    ViewBag.ErrorDates = "Check the dates*";
                    return View(allergy);
                }

                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                var connection = new SqlConnection(connectionString);

                dateCreate = allergy.Year + "-" + allergy.Day + "-" + allergy.Month + " 00:00:01";

                string sqlQuery = $"exec updatePatientAllergy @id='{allergy.Id}', @date_time='{dateCreate}', @medicine='{allergy.Medicine}'";
                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    await command.ExecuteReaderAsync();
                    connection.Close();
                }
                return RedirectToAction("Details", new { id = allergy.Id });
            }

            return View(allergy);

        }

        [HttpGet]
        public async Task<IActionResult> Delete(int? id)
        {
            //TODO: Validate not found
            Allergy temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getAllergyById @id='{id}'";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            int Id = Int32.Parse(dataReader["id"].ToString());
                            int PatientIdentification = Int32.Parse(dataReader["fk_patient_identification_card"].ToString());
                            string Patiend_name = dataReader["patient_name"].ToString();
                            string Allergy_name = dataReader["allergy_name"].ToString();
                            string Allergy_description = dataReader["allergy_description"].ToString();
                            DateTime Date = (DateTime)dataReader["diagnosis_date_time"];
                            string Medicine = dataReader["medicine"].ToString();

                            temp = new Allergy(Id, PatientIdentification, Patiend_name, Allergy_name, Allergy_description, Date, Medicine);
                        }//while
                        connection.Close();
                    }
                }
            }

            return View(temp);
        }

        //[HttpDelete]
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Delete(Allergy allergy)
        {
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec deletePatientAllergy @id='{allergy.Id}'";
                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    await command.ExecuteReaderAsync();
                    connection.Close();
                }
            }

            ViewBag.Mensaje = "Successful";

            return RedirectToAction("Index", new { id = allergy.Fk_patient_identification_card });
        }

    }
}
