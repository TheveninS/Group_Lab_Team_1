/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;

import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.University.Department.Department;
import Business.University.CourseCatalog.Course;
import Business.University.CourseCatalog.CourseCatalog;
import Business.University.CourseSchedule.CourseSchedule;
import Business.University.CourseSchedule.CourseOffer;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

        // Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
        
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        Person person003 = persondirectory.newPerson("Adam Rollen");
        Person person004 = persondirectory.newPerson("Dr.Sarah Johnson");
        Person person005 = persondirectory.newPerson("Jim Dellon");
        Person person006 = persondirectory.newPerson("Anna Shnider");
        Person person007 = persondirectory.newPerson("Laura Brown");
        Person person008 = persondirectory.newPerson("Jack While");
        Person person009 = persondirectory.newPerson("Fidelity");

        // Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        
        FacultyDirectory facultydirectory = business.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person004);
        
        // CREATE COURSES AND ASSIGN TO FACULTY
        Department department = business.getDepartment();
        CourseCatalog catalog = department.getCourseCatalog();
        
        Course course1 = catalog.newCourse("Application Engineering", "INFO 5100", 4);
        Course course2 = catalog.newCourse("Data Structures", "INFO 6205", 4);
        Course course3 = catalog.newCourse("Web Development", "INFO 6150", 4);
        
        // CREATE COURSE SCHEDULE
        CourseSchedule fall2025 = department.newCourseSchedule("Fall2025");
        
        CourseOffer offer1 = fall2025.newCourseOffer("INFO 5100");
        offer1.generatSeats(40);
        offer1.AssignAsTeacher(facultyprofile0);  // Assign faculty to course
        
        CourseOffer offer2 = fall2025.newCourseOffer("INFO 6205");
        offer2.generatSeats(35);
        offer2.AssignAsTeacher(facultyprofile0);
        
        CourseOffer offer3 = fall2025.newCourseOffer("INFO 6150");
        offer3.generatSeats(30);
        offer3.AssignAsTeacher(facultyprofile0);
   
        // Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****");
        UserAccount ua4 = uadirectory.newUserAccount(studentprofile0, "adam", "****");
        UserAccount ua5 = uadirectory.newUserAccount(facultyprofile0, "faculty", "****");
        
        return business;
    }
}
