package model.Documents;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@DiscriminatorValue("DVD")
public class DVD extends Document{
    public final static int BORROW_TIME_IN_WEEK = 2;
}
