package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() {

    }

    public Course(String n, String cid) {
        setCourse_name(n);
        setCourse_id(cid);
    }

    public Course(String n, String cid, String l) {
        setCourse_name(n);
        setCourse_id(cid);
        setLecturer(l);
    }

    public Course(String n, String cid, String l, int max) {
        setCourse_name(n);
        setCourse_id(cid);
        setLecturer(l);
        max_students = max;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }

    // implement the other get and set methods here
    public String getLecturer() {
        // implement here
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = !lecturer.equalsIgnoreCase("")?lecturer:this.lecturer;
        // implement here
    }

    public int getMax_students() {
        // implement here
        return max_students;
    }

    public void setMax_students(int max_students) {
        // implement here
        if(max_students>=10)
            this.max_students=max_students;
    }

    public int getNo_students() {
        // implement here
        return no_students;
    }

    public void setNo_students(int no_students) {
        if(no_students>=0 && no_students <= max_students)
            this.no_students=no_students;
    }

    @Override
    public String toString() {
        String o = this.course_name + " ("
                + this.course_id + "), Teacher: "
                + this.lecturer + ", has "+(no_students==0?"NO student":(no_students==1?"ONE student":(no_students+" students")))+", [maximum: "+ max_students+"]";

        // implement the rest here

        return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        // implement the rest here
        if(m.find())
            return true;
        else return false;
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "^[0-9]{6}$";

    // all private attributes
    private String course_name="TBA";
    private String course_id="000000";
    private String lecturer="TBA";
    private int max_students=30;
    private int no_students=0;
}