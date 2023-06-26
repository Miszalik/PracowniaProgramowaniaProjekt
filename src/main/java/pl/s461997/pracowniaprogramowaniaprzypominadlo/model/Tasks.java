package pl.s461997.pracowniaprogramowaniaprzypominadlo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String taskname;
    @Column(nullable = false)
    private String description;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @ManyToOne
    private Lists listname;
}
