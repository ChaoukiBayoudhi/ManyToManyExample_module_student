package com.example.ManyToManyExample;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull //for java programming
    @Column(name = "module_name", nullable = false,length=50, unique = true)
    //<=> in sql : module_name varchar(50) NOT NULL unique
    @EqualsAndHashCode.Include
    //@Size(max=50)
    private String name;
    @Min(21)
    @Max(64)
    private int nbHours;
    @Min(1)
    private float coefficient;
    @ManyToMany(mappedBy="studiedModules")
    private Set<Student> students = new HashSet<>();

}
