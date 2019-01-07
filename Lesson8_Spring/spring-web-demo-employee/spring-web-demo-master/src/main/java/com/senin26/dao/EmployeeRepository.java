package com.senin26.dao;

import com.senin26.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Rewritten by <a href="mailto:sergey.ionin.7@gmail.com">Sergey Ionin</a><br/>
 * based on the project of
 * <a href="mailto:izebit@gmail.com">Artem Konovalov</a> at <a href=https://github.com/izebit/spring-web-demo></a><br/>
 * Creation date: 1/7/18.
 * @since 1.0
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
