package com.EnvironmentDashboardModule1.services.Event;

import java.util.List;
/**
* This is a generic interface for the entity classes which will provide CRUD methods, such as getById.
 * We used one interface per persistent entity, with a super interface for common CRUD functionality.
 * Further, this interface will be extended by other interfaces, each of them will have a class for the implementation
 * of the methods.
 */
public interface CrudService<T> {
    T save(T entity);
    List<T> getAll();
    T getById(Long id);
    void delete(Long id);
    T update(T entity, Long id);
}
