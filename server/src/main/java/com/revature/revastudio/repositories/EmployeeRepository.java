package com.revature.revastudio.repositories;

import com.revature.revastudio.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
