package com.example.springbootthymeleaf.Repository;

import com.example.springbootthymeleaf.Entitie.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
