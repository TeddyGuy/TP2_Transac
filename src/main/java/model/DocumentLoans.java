package model;

import jakarta.persistence.*;
import lombok.*;
import model.Documents.Document;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentLoans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "document_id")
    @ToString.Exclude
    private Document document;
    private LocalDate lendingDate;
    private LocalDate expectedReturnDate;
}
