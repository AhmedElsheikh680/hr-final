package com.hr.repo;

import com.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    // This is Native Query ex @Query("select * from hr_employees, nativeQuery=true)
    // and JPQL Query nativeQuery=false ex @Query(select * from Employee, nativeQuery=false)

    //
    Employee findByFirstNameAndLastNameOrderById(String firstName, String lastName); // This is custom query
}
