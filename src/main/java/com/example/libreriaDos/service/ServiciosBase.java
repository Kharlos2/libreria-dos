package com.example.libreriaDos.service;

import java.util.List;
import java.util.Optional;

public interface ServiciosBase<E,T> {
   E save(T datos) throws Exception;
   List<E> getAll() throws Exception;
//    public E getId(Integer id) throws Exception;
//    public E update (Integer id, E datosNuevos) throws Exception;
//    public boolean delete(Integer id) throws Exception;
}
