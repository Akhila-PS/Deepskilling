public class Main {
    public static void main(String[] args) {
        Student student = new Student("Akhila", "S101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentGrade("A+");
        controller.updateView();
    }
}