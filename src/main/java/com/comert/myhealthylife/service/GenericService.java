package com.comert.myhealthylife.service;

import com.comert.myhealthylife.exception.EntityNotFoundException;

public interface GenericService<E, I extends Number> {

    void save(E entity);

    E findById(I id) throws EntityNotFoundException;

    E update(E entity);

    void deleteById(I id);

}
