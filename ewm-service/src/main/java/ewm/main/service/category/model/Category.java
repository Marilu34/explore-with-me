package ewm.main.service.category.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private long id;

    @Column(name = "category_name", nullable = false)
    private String name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}