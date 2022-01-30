package pl.s461997.pracowniaprogramowaniaprzypominadlo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //???
    private Long id;
    @Column(nullable = false)
    private String username;
    @ManyToMany
    @JoinTable(name = "Users_Lists", joinColumns = @JoinColumn(name = "Users_id"), inverseJoinColumns = @JoinColumn(name = "Lists_id"))
    private Set<Lists> listname = new HashSet<>();
}
