package pl.s461997.pracowniaProgramowaniaPzypominadlo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Lists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Listowners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "Users_id"")
    private int userId;
    @ManyToOne
    private int listId;
}
