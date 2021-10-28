package StudentSystem;

public class StudentFormatting {
    public static String formatStudent(Student student) {
        return String.format("%s is %s years old. %s", student.getName(), student.getAge(), createCommentary(student));
    }

    private static String createCommentary(Student student) {
        String view = "";
        if (student.getGrade() >= 5.00) {
            view = "Excellent student.";
        } else if (student.getGrade() >= 3.50) {
            view = "Average student.";
        } else {
            view = "Very nice person.";
        }
        return view;
    }
}
