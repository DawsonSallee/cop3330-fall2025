import java.util.*;

public class Student {
    private String name;
    private String major;

    public Student(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return this.name;
    }

    public String getMajor() {
        return this.major;
    }

    public static Map<String, List<Student>> groupStudentsByMajor(List<Student> list) {

        Map<String, List<Student>> map = new HashMap<>();

        for(Student std : list) {
            if(map.containsKey(std.getMajor())) {
                map.get(std.getMajor()).add(std);
            } else {
                map.put(std.getMajor(), new ArrayList<>());
                map.get(std.getMajor()).add(std);
            }
        }

        return map;
    }
}
