package com.example.ManyToManyExample;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull //for java programming
    @Column(name = "student_name", nullable = false)
    //<=> in sql : student_name NOT NULL
    @EqualsAndHashCode.Include
    private String name;
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDate birthday;
    @Column(columnDefinition = "float default 0")// the mark has 0 as default value
    private float mark;
    @ManyToMany
    //create the association table ("study")
    @JoinTable(name = "study",
                joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),//the first foreign key
                inverseJoinColumns = @JoinColumn(name = "module_id",referencedColumnName = "id") //the second foreign key
        )
    private Set<Module> studiedModules = new HashSet<>();
}
