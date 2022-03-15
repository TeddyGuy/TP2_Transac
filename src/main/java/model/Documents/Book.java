package model.Documents;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Book")
public class Book extends Document{
    public final static int BORROW_TIME_IN_WEEKS = 3;
    private String publisher;
    private int pages;
}
