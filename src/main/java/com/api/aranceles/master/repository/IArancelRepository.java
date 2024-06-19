package com.api.aranceles.master.repository;

import com.api.aranceles.master.entity.TblArancel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IArancelRepository extends JpaRepository<TblArancel, Long> {

    // JPQL(Java Persistence Query Language)
    //Paginado
    @Query("select a from TblArancel a where upper(a.nombre) like upper(:nombre) and a.estado= 10 ORDER BY ?#{#pageable}")
    Page<TblArancel> findByLikeNombre(Pageable pageable, @Param("nombre") String nombre);

    @Query("select a from TblArancel a where a.estado= 10 ORDER BY ?#{#pageable}")
    Page<TblArancel> findAllByEstado(Pageable pageable);
}
