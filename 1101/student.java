public class student {
    private String studentID;
    private String name;

    public student(){
        new student("00000000", "未知");
    }

    public student(String studentID){
        new student(studentID, "未知");
    }

    public student(String studentID, String name){
        this.studentID = studentID;
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printData(){
        System.out.printf("學號: %s, 姓名: %s",studentID,name);
    }
}
