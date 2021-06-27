package com.bancodebogota.interview.programmingskills.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "function")
    private String function;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Employee boss;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "boss")
    private List<Employee> employees;

}
