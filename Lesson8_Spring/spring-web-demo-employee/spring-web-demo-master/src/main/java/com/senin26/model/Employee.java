package com.senin26.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Rewritten by <a href="mailto:sergey.ionin.7@gmail.com">Sergey Ionin</a><br/>
 * based on the project of
 * <a href="mailto:izebit@gmail.com">Artem Konovalov</a> at <a href=https://github.com/izebit/spring-web-demo></a><br/>
 * Creation date: 1/7/18.
 * @since 1.0
 */
@Entity
public class Employee implements Serializable, Comparable<Employee> {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private String salary;
    @Column
    private long creationTimestamp;

    public Employee() {
        this.creationTimestamp = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Employee that) {
        return Long.compare(this.creationTimestamp, that.creationTimestamp);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
