/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import Business.University.CourseSchedule.CourseLoad;  
import Business.University.CourseSchedule.SeatAssignment;  
import java.util.ArrayList; 

/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile {

    Person person;
    CourseLoad currentCourseLoad;
    ArrayList<CourseLoad> courseLoads;
//    Transcript transcript;
    //   EmploymentHistroy employmenthistory;

    public StudentProfile(Person p) {
        super(p);
        courseLoads = new ArrayList();

//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
    
    public CourseLoad getCurrentCourseLoad() {
        return currentCourseLoad;
    }
    
    public CourseLoad newCourseLoad(String semester) {
        currentCourseLoad = new CourseLoad(semester);
        courseLoads.add(currentCourseLoad);
        return currentCourseLoad;
    }
    
    public ArrayList<SeatAssignment> getCourseList() {
        ArrayList<SeatAssignment> allAssignments = new ArrayList();
        for (CourseLoad cl : courseLoads) {
            allAssignments.addAll(cl.getSeatAssignments());
        }
        return allAssignments;
    }

}
