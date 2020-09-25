package com.example.absencemanager;

public class StudentClass {
    private int id;
    private String cne;
    private String firstName;
    private String lastName;
    private int idClass;

    public StudentClass(int id, String cne, String firstName, String lastName, int idClass) {
        this.id = id;
        this.cne = cne;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idClass = idClass;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

}
