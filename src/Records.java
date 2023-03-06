import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Records {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String course;
    private String email;

    public Records(String firstName, String lastName, LocalDate birthday, String course, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        setCourse(course);
        setEmail(email);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (Pattern.matches("^[a-zA-Z]+$", firstName) && firstName.length() <= 50) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (Pattern.matches("^[a-zA-Z]+$", lastName) && lastName.length() <= 50) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthday.getYear();
        if (today.getMonthValue() < birthday.getMonthValue() ||
                (today.getMonthValue() == birthday.getMonthValue() && today.getDayOfMonth() < birthday.getDayOfMonth())) {
            age--;
        }
        if (age >= 17 && age <= 25) {
            this.birthday = birthday;
        } else {
            throw new IllegalArgumentException("Invalid: Maybe You're Too Young Or Too Old.");
        }
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        if (Pattern.matches("^[^\\\\d]*$", course) && course.length() <= 50) {
            this.course = course;
        } else {
            throw new IllegalArgumentException("Invalid course");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Pattern.matches("[^@]+@[^@]+\\.[^@]+", email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    public String getStudentNumber() {
        String surnameInitial = lastName.substring(0, 1).toLowerCase();
        String year = String.valueOf(LocalDate.now().getYear());
        String bday = birthday.format(DateTimeFormatter.ofPattern("dd"));
        return year + "-" + bday + "01-" + surnameInitial;
    }

    public boolean isValidForm() {
        // check if all fields are valid
        try {
            setFirstName(firstName);
            setLastName(lastName);
            setBirthday(birthday);
            setCourse(course);
            setEmail(email);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}