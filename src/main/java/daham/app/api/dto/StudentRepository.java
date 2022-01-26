package daham.app.api.dto;

import daham.app.api.model.Student;
import lombok.extern.java.Log;
import org.hibernate.envers.RevisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface StudentRepository  extends RevisionRepository<Student,Integer,Integer>, JpaRepository<Student, Integer> {
}
