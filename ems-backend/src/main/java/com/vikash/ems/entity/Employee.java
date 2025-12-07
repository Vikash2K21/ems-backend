package com.vikash.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="email_id", nullable=false,unique = true)
    private String email;

    @Column(name="mobile_no",unique = true,nullable=false)
    private String mobno;

    @Column(name="department")
    private String department;

    @Column(name="designation")
    private String designation;

    @Column(name="salary")
    private Double salary;

    @Column(name="joinDate")
    private LocalDate joinDate;
}
