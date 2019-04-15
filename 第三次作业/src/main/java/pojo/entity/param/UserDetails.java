package pojo.entity.param;

import java.util.List;

public class UserDetails {

    private String name;

    private String id;

    private String schoolName;

    private String professior;

    private List<String> technology;


    public String getName() {
        return name;
    }

    public UserDetails setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public UserDetails setId(String id) {
        this.id = id;
        return this;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public UserDetails setSchoolName(String schoolName) {
        this.schoolName = schoolName;
        return this;
    }

    public String getProfessior() {
        return professior;
    }

    public UserDetails setProfessior(String professior) {
        this.professior = professior;
        return this;
    }

    public List<String> getTechnology() {
        return technology;
    }

    public UserDetails setTechnology(List<String> technology) {
        this.technology = technology;
        return this;
    }
}
