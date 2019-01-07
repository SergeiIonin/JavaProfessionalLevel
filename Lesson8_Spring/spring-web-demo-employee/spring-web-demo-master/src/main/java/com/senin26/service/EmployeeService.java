package com.senin26.service;

import com.senin26.dao.EmployeeRepository;
import com.senin26.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Rewritten by <a href="mailto:sergey.ionin.7@gmail.com">Sergey Ionin</a><br/>
 * based on the project of
 * <a href="mailto:izebit@gmail.com">Artem Konovalov</a> at <a href=https://github.com/izebit/spring-web-demo></a><br/>
 * Creation date: 1/7/18.
 * @since 1.0
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public void save(Employee employee) {
        Employee savedEmployee = repository.save(employee);
        System.out.println(savedEmployee.getId());
    }

    public List<Employee> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public List<Employee> delete(Integer articleId) {
        repository.delete(articleId);
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
