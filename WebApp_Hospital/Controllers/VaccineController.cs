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
    public class VaccineController : Controller
    {
        public IConfiguration Configuration { get; }

        public VaccineController(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        [HttpGet]
        public async Task<IActionResult> Index(int? id)
        {
            List<Vaccine> vaccines = new List<Vaccine>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                   
                    string sqlQuery = $"exec getVaccineByPatientId @id ='{id}'";
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
                            string Vaccine_name = dataReader["vaccine_name"].ToString();
                            string Vaccine_description = dataReader["vaccine_description"].ToString();
                            DateTime Date = (DateTime)dataReader["date_time"];
                            DateTime Next_dose_date_time = (DateTime)dataReader["next_dose_date_time"];
                            string Clinic_name = dataReader["clinic_name"].ToString();

                            vaccines.Add(new Vaccine(Id, PatientIdentification, Patiend_name, Vaccine_name, Vaccine_description, Date, Next_dose_date_time, Clinic_name));
                        }//while
                        connection.Close();
                    }
                }
            }

            ViewBag.IdPatient = id;

            return View(vaccines);
        }

        [HttpGet]
        public async Task<IActionResult> Details(int? id)
        {

            //TODO: Validate not found

            Vaccine temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getVaccineById @id='{id}'";
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
                            string Vaccine_name = dataReader["vaccine_name"].ToString();
                            string Vaccine_description = dataReader["vaccine_description"].ToString();
                            DateTime Date = (DateTime)dataReader["date_time"];
                            DateTime Next_dose_date_time = (DateTime)dataReader["next_dose_date_time"];
                            string Clinic_name = dataReader["clinic_name"].ToString();

                            temp = (new Vaccine(Id, PatientIdentification, Patiend_name, Vaccine_name, Vaccine_description, Date, Next_dose_date_time, Clinic_name));

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

            Vaccine temp = null;

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

                            temp = new Vaccine(PatientIdentification, Patiend_name);
                        }//while
                        connection.Close();
                    }
                }
            }

            return View(temp);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(Vaccine vaccine)
        {
            string dateCreate = "";
            string nextdateCreate = "";
            if (ModelState.IsValid)
            {
                if (vaccine.Year.Equals("Year") || vaccine.Day.Equals("Day") || vaccine.Month.Equals("Month") || vaccine.NextYear.Equals("Year") || vaccine.NextDay.Equals("Day") || vaccine.NextMonth.Equals("Month"))
                {
                    ViewBag.ErrorDates = "Check the dates*";
                    return View(vaccine);
                }

                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                var connection = new SqlConnection(connectionString);

                dateCreate = vaccine.Year + "-" + vaccine.Day + "-" + vaccine.Month + " 00:00:01";
                nextdateCreate = vaccine.NextYear + "-" + vaccine.NextDay + "-" + vaccine.NextMonth + " 00:00:01";

                string sqlQuery = $"exec addPatientVaccine @patient={vaccine.Fk_patient_identification_card}, @vaccine='{vaccine.Vaccine_name}', @date_time='{dateCreate}', @next_dose_date='{nextdateCreate}', @clinic='{vaccine.Clinic_name}'";
                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    await command.ExecuteReaderAsync();
                    connection.Close();
                }
                return RedirectToAction(nameof(Index), new { id = vaccine.Fk_patient_identification_card });
            }

            return View(vaccine);
        }

        [HttpGet]
        public async Task<IActionResult> Edit(int? id)
        {
            //TODO: Validate not found

            Vaccine temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getVaccineById @id='{id}'";
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
                            string Vaccine_name = dataReader["vaccine_name"].ToString();
                            string Vaccine_description = dataReader["vaccine_description"].ToString();
                            DateTime Date = (DateTime)dataReader["date_time"];
                            DateTime Next_dose_date_time = (DateTime)dataReader["next_dose_date_time"];
                            string Clinic_name = dataReader["clinic_name"].ToString();

                            temp = new Vaccine(Id, PatientIdentification, Patiend_name, Vaccine_name, Vaccine_description, Date, Next_dose_date_time, Clinic_name);
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
        public async Task<IActionResult> Edit(Vaccine vaccine)
        {
            string dateCreate = "";
            string nextdateCreate = "";
            if (ModelState.IsValid)
            {
                if (vaccine.Year.Equals("Year") || vaccine.Day.Equals("Day") || vaccine.Month.Equals("Month") || vaccine.NextYear.Equals("NextYear") || vaccine.NextDay.Equals("NextDay") || vaccine.NextMonth.Equals("NextMonth"))
                {
                    ViewBag.ErrorDates = "Check the dates*";
                    return View(vaccine);
                }

                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                var connection = new SqlConnection(connectionString);

                dateCreate = vaccine.Year + "-" + vaccine.Day + "-" + vaccine.Month + " 00:00:01";
                nextdateCreate = vaccine.NextYear + "-" + vaccine.NextDay + "-" + vaccine.NextMonth + " 00:00:01";

                string sqlQuery = $"exec updatePatientVaccine @id='{vaccine.Id}', @date_time='{dateCreate}', @next_dose_date='{nextdateCreate}', @clinic='{vaccine.Clinic_name}'";
                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    await command.ExecuteReaderAsync();
                    connection.Close();
                }
                return RedirectToAction("Details", new { id = vaccine.Id });
            }

            return View(vaccine);

        }

        [HttpGet]
        public async Task<IActionResult> Delete(int? id)
        {
            //TODO: Validate not found
            Vaccine temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec getVaccineById @id='{id}'";
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
                            string Vaccine_name = dataReader["vaccine_name"].ToString();
                            string Vaccine_description = dataReader["vaccine_description"].ToString();
                            DateTime Date = (DateTime)dataReader["date_time"];
                            DateTime Next_dose_date_time = (DateTime)dataReader["next_dose_date_time"];
                            string Clinic_name = dataReader["clinic_name"].ToString();

                            temp = new Vaccine(Id, PatientIdentification, Patiend_name, Vaccine_name, Vaccine_description, Date, Next_dose_date_time, Clinic_name);
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
        public async Task<IActionResult> Delete(Vaccine vaccine)
        {
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec deletePatientVaccine @id='{vaccine.Id}'";
                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    await command.ExecuteReaderAsync();
                    connection.Close();
                }

                return RedirectToAction("Index", new { id = vaccine.Fk_patient_identification_card });
            }

            return View();
        }

    }

}
