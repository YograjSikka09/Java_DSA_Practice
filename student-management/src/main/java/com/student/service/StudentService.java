package com.student.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service 

public class StudentService {


    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student>getallStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id, Student student){
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student student){
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if(existingStudent==null){
            return null;
        }

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setAge(student.getAge());
        return studentRepository.save(existingStudent);

    }

    public boolean deleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }


}
