package org.sunny.pojo;

public class User {
    private String name;
    private Integer newAge;

    private Integer id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", newAge=" + newAge +
                ", id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNewAge() {
        return newAge;
    }

    public void setNewAge(Integer newAge) {
        this.newAge = newAge;
    }

}
