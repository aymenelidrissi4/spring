package com.project.students.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
//@Document(collection = "students")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
