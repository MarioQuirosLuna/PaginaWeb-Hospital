using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.Data.SqlClient;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using WebApp_Hospital.Models;

namespace WebApp_Hospital.Controllers
{
    public class DoctorsController : Controller
    {
        public IConfiguration Configuration { get; }

        public DoctorsController(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        [HttpGet]
        public IActionResult Login()
        {
            return View();
        }

        //Login Doctor
        [HttpPost]
        public IActionResult Login(Doctor doctor) {

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:DB_Connection"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec doctor_login @identification='{doctor.Doctor_identification_card}', @code='{doctor.Doctor_code}', @password='{doctor.Doctor_password}'";
                    Console.WriteLine(sqlQuery);
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader doctorReader = command.ExecuteReader();
                        if (doctorReader.Read())
                        {
                            
                            HttpContext.Session.SetString("name", doctorReader["doctor_name"].ToString());

                            connection.Close();
                            return RedirectToAction("ShowDashBoard");
                        }                       
                    }
                    connection.Close();
                }
            }
            ViewBag.ErrorLogin = "Incorrect ID, doctor code or password*";
            return View();
            
        }

        public ActionResult ShowDashBoard() 
        {
            if (HttpContext.Session.GetString("name") != null) 
            {
                return View("Index", HttpContext.Session.GetString("name"));
            }else{
                return RedirectToAction("Login");
            }
        }
    }
}
