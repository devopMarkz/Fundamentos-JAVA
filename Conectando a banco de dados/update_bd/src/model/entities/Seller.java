package model.entities;

import java.time.LocalDateTime;

public class Seller {

    private final Long id;
    private String name;
    private String email;
    private LocalDateTime birthDate;
    private Double baseSalary;
    private Department department;

    private Seller(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.birthDate = builder.birthDate;
        this.baseSalary = builder.baseSalary;
        this.department = builder.department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                '}';
    }

    public static class Builder{

        private Long id;
        private String name;
        private String email;
        private LocalDateTime birthDate;
        private Double baseSalary;
        private Department department;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder birthDate(LocalDateTime birthDate){
            this.birthDate = birthDate;
            return this;
        }

        public Builder baseSalary(Double baseSalary){
            this.baseSalary = baseSalary;
            return this;
        }

        public Builder department(Department department){
            this.department = department;
            return this;
        }

        public Seller build(){
            return new Seller(this);
        }

    }
}
