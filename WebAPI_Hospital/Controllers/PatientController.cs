using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using WebAPI_Hospital.Models;

namespace WebAPI_Hospital.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PatientController : ControllerBase
    {

        public IConfiguration Configuration { get; }

        public PatientController(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        [HttpGet]
        [Route("showDataPatient")]
        public async Task<ActionResult<PatientSession>> ShowDataPatient(int identification)
        {
            PatientData temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec API_getPatientByIdentification @identification={identification}";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        if (dataReader.Read())
                        {

                            int id = Int32.Parse(dataReader["id"].ToString());
                            int Patientidentification = Int32.Parse(dataReader["patient_identification_card"].ToString());
                            string name = dataReader["patient_name"].ToString();
                            int age = Int32.Parse(dataReader["patient_age"].ToString());
                            string blood = dataReader["blood_type"].ToString();
                            string civil = dataReader["status_name"].ToString();
                            string telephone = dataReader["telephone"].ToString();

                            string province = dataReader["province"].ToString();
                            string canton = dataReader["canton"].ToString();
                            string district = dataReader["district"].ToString();
                            string description = dataReader["address_description"].ToString();

                            temp = new PatientData(id, Patientidentification, name, age, blood, civil, telephone, new Patient_Address(province, canton, district, description));
                        }//while
                        connection.Close();
                        return Ok(temp);
                    }
                }
            }
            else
            {
                return BadRequest();
            }
        }

        [HttpGet]
        [Route("showAppointmentPatient")]
        public async Task<ActionResult<List<PatientAppointment>>> ShowAppointmentPatient(int identification)
        {
            List<PatientAppointment> patientAppointments = new List<PatientAppointment>();

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec API_getAppointmentByPatientIdentification  @identification={identification}";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {

                            int id = Int32.Parse(dataReader["id"].ToString());
                            int Patientidentification = Int32.Parse(dataReader["fk_patient_identification_card"].ToString());
                            string name = dataReader["patient_name"].ToString();
                            int doctorCode = Int32.Parse(dataReader["doctor_code"].ToString());
                            string doctorName = dataReader["doctor_name"].ToString();
                            string clinic_name = dataReader["clinic_name"].ToString();
                            DateTime dateTime = (DateTime)dataReader["date_time"];
                            string speciality = dataReader["speciality"].ToString();
                            string diagnosisDescription = dataReader["diagnosis_description"].ToString();

                            patientAppointments.Add(new PatientAppointment(id, Patientidentification, name, doctorCode, doctorName, clinic_name, dateTime, speciality, diagnosisDescription));
                        }//while
                        connection.Close();
                        return Ok(patientAppointments);
                    }
                }
            }
            else
            {
                return BadRequest();
            }
        }

        [HttpGet]
        [Route("showAllergyPatient")]
        public async Task<ActionResult<List<PatientAllergy>>> ShowAllergyPatient(int identification)
        {
            List<PatientAllergy> patientAllergies = new List<PatientAllergy>();

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec API_getAllergyByPatientIdentification  @identification={identification}";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {

                            int id = Int32.Parse(dataReader["id"].ToString());
                            int Patientidentification = Int32.Parse(dataReader["fk_patient_identification_card"].ToString());
                            string name = dataReader["patient_name"].ToString();
                            string allergy = dataReader["allergy_name"].ToString();
                            string allergyDescription = dataReader["allergy_description"].ToString();
                            DateTime diagnosisDate = (DateTime)dataReader["diagnosis_date_time"];
                            string medicine = dataReader["medicine"].ToString();


                            patientAllergies.Add(new PatientAllergy(id, Patientidentification, name, allergy, allergyDescription, diagnosisDate, medicine));
                        }//while
                        connection.Close();
                        return Ok(patientAllergies);
                    }
                }
            }
            else
            {
                return BadRequest();
            }
        }

        [HttpGet]
        [Route("showVaccinePatient")]
        public async Task<ActionResult<List<PatientVaccine>>> ShowVaccinePatient(int identification)
        {
            List<PatientVaccine> patientVaccines = new List<PatientVaccine>();

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec API_getVaccineByPatientIdentification  @identification={identification}";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {

                            int id = Int32.Parse(dataReader["id"].ToString());
                            int Patientidentification = Int32.Parse(dataReader["fk_patient_identification_card"].ToString());
                            string name = dataReader["patient_name"].ToString();
                            string vaccine = dataReader["vaccine_name"].ToString();
                            string vaccineDescription = dataReader["vaccine_description"].ToString();
                            DateTime date = (DateTime)dataReader["date_time"];
                            DateTime dateNextDose = (DateTime)dataReader["next_dose_date_time"];
                            string clinicName = dataReader["clinic_name"].ToString();


                            patientVaccines.Add(new PatientVaccine(id, Patientidentification, name, vaccine, vaccineDescription, date, dateNextDose, clinicName));
                        }//while
                        connection.Close();
                        return Ok(patientVaccines);
                    }
                }
            }
            else
            {
                return BadRequest();
            }
        }

        // POST api/<PatientController>/loginPatient
        [HttpPost]
        [Route("loginPatient")]
        public async Task<ActionResult<PatientSession>> LoginPatient(PatientLogin patientLogin)
        {
            PatientSession temp = null;

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec API_patient_login @identification={patientLogin.Identification}, @password='{patientLogin.Password}'";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader dataReader = await command.ExecuteReaderAsync();
                        while (dataReader.Read())
                        {
                            
                            string PatientName = dataReader["patient_name"].ToString();
                            int PatientIdentification = Int32.Parse(dataReader["patient_identification_card"].ToString());

                            temp = new PatientSession(PatientIdentification, PatientName);
                        }//while
                        connection.Close();
                    }
                }
            }

            return Ok(temp);
        }

        // POST api/<PatientController>/createdPatient
        [HttpPost]
        [Route("createPatient")]
        public async Task<ActionResult<PatientSession>> CreatePatient(PatientRegister patient)
        {

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec API_addPatient @patient_identification_card={patient.Patient_identification}, @patient_name='{patient.Patient_name}', @patient_password='{patient.Patient_password}', @patient_age={patient.Age}, @blood_type='{patient.Blood_type}', @fk_civil_status='{patient.Civil_status}', @telephone='{patient.Telephone}', @province='{patient.Province}', @canton='{patient.Canton}', @district='{patient.District}', @address='{patient.Description}'";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        await command.ExecuteReaderAsync();
                        connection.Close();
                        return Created($"/Patient/createPatient{ patient.Patient_name}", patient);
                    }
                }
            }
            else 
            {
                return BadRequest();
            }
        }

        [HttpPut]
        [Route("updatePatient")]
        public async Task<ActionResult> UpdatePatient(PatientUpdate patient) 
        {

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec API_updatePatient @identification={patient.Patient_identification}, @fk_civil_status='{patient.Civil_status}', @telephone='{patient.Telephone}', @province='{patient.Patient_addres.Province}', @canton='{patient.Patient_addres.Canton}', @district='{patient.Patient_addres.District}', @description='{patient.Patient_addres.Description}'";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        await command.ExecuteReaderAsync();
                        connection.Close();
                        return Ok(patient);
                    }
                }
            }
            else 
            {
                return BadRequest();
            }          
        }
    }
}
