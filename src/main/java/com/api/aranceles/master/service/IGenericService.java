package com.api.aranceles.master.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IGenericService<T> {

    Page<T> findAll(Pageable pageable) throws ServiceException;

    Page<T> findLikeObject(Pageable pageable, String nombre) throws ServiceException;

    T save(T t) throws ServiceException;

    T update(T t) throws ServiceException;

    Boolean delete(T t) throws ServiceException;
}
