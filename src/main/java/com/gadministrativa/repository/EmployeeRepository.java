package com.gadministrativa.repository;

import com.gadministrativa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query ---
    @Query("SELECT e FROM Employee e WHERE e.id = :employeeId")
    Employee findEmployeeById(@Param("employeeId") Long employeeId);
}
