public class gradebooktest {
    public static void main(String[] args){
        final int NUMBER_OF_STUDENTS = 3;
        student[] students = new student[NUMBER_OF_STUDENTS];
        students[0] = new student("A111223018", "吳冠緯");
        students[1] = new student("A111223041","許嘉祥");
        students[2] = new student("A112221011","蘇恆煒");
        Gradebook gradebook = new Gradebook("Java程式設計",students, NUMBER_OF_STUDENTS);
        gradebook.processStudentsGrades();
        gradebook.displayGradeReport();
    }
}
