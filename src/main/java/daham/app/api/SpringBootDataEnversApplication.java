package daham.app.api;

import daham.app.api.dto.StudentRepository;
import daham.app.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class SpringBootDataEnversApplication {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PostMapping("/update/{id},{firstName}")
    public String updateFirstName(@PathVariable int id,@PathVariable String firstName){
        Student student= studentRepository.findById(id).get();
        student.setFirstName(firstName);
        studentRepository.save(student);
       return  "First name Updatde ....";
    }

    @DeleteMapping("/{id}")
    public String deletStudent(@PathVariable int id){
        studentRepository.deleteById(id);
        return "Student deleted ";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataEnversApplication.class, args);
    }

}
