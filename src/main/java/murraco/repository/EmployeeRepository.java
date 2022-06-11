package murraco.repository;

import murraco.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT employees.id " +
            "FROM employees " +
            "LEFT JOIN app_users " +
            "ON employees.user_id = app_users.id " +
            "WHERE app_users.username = :username",
    nativeQuery = true)
    Integer findEmployeeIdByUsername(@Param("username") String username);
}
