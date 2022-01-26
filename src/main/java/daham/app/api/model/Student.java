package daham.app.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name =  "ID")
    private Long  id;

    @Column(name =  "FIRST_NAME")
    private String firstName;

    @Column(name =  "LAST_NAME")
    private  String  lastName;

    @Temporal(TemporalType.DATE)
    @Column(name =  "BIRTH_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date birthDate;
}
