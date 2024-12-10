package com.adeindra6.domain;

public class Author {
    private Long id;
    private String name;
    private Long birthDate;

    public Author() {
        super();
    }

    public Author(Long id, String name, Long birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Author(Long id, Long birthDate, String name) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Author(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", getId()=" + getId()
                + ", getName()=" + getName() + ", getBirthDate()=" + getBirthDate() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}
