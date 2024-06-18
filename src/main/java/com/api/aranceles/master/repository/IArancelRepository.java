package com.api.aranceles.master.repository;

import com.api.aranceles.master.entity.TblArancel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArancelRepository extends JpaRepository<TblArancel, Long> {
}
