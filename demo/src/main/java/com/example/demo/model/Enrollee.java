package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "enrollees")
public class Enrollee {

    @Id                                                      // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)      // To automatically generate value for that field
    @Column(name = "enrollee_id", columnDefinition = "serial")
    private Integer id;

    @Column(name = "name")
    @NotNull(message = "Name should not be Null.")
    @NotEmpty(message = "Please enter the name.")
    private String name;

    @NotNull(message = "Status should not be Null.")
    @Column(name = "activation_status")
    private boolean activation_status;

    @NotNull(message = "Date should not be Null.")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "birth_date")
    private Date birth_date;

    public Enrollee()  {

    }

    public Enrollee(@NotNull(message = "Name should not be Null.") @NotEmpty(message = "Please enter the name.") String name, @NotNull(message = "Status should not be Null.") boolean activation_status, @NotNull(message = "Date should not be Null.") Date birth_date) {
        this.name = name;
        this.activation_status = activation_status;
        this.birth_date = birth_date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActivation_status() {
        return activation_status;
    }

    public void setActivation_status(boolean activation_status) {
        this.activation_status = activation_status;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

}
