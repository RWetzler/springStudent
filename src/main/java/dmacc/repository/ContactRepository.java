package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Student;

public interface ContactRepository extends JpaRepository<Student, Long>{

}
