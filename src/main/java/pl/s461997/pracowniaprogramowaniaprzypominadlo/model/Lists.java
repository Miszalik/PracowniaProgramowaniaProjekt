package pl.s461997.pracowniaprogramowaniaprzypominadlo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Lists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String listname;
}
