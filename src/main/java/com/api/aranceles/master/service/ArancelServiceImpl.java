package com.api.aranceles.master.service;

import com.api.aranceles.master.entity.TblArancel;
import com.api.aranceles.master.repository.IArancelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ArancelServiceImpl implements IArancelService{

    private final IArancelRepository arancelRepository;

    public ArancelServiceImpl(IArancelRepository arancelRepository) {
        this.arancelRepository = arancelRepository;
    }

    @Override
    public Page<TblArancel> findAll(Pageable pageable) throws ServiceException {
       try {
            return arancelRepository.findAllByEstado(pageable);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Page<TblArancel> findLikeObject(Pageable pageable, String nombre) throws ServiceException {
        try {
            return arancelRepository.findByLikeNombre(pageable, "%" +nombre+ "%");
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public TblArancel save(TblArancel tblArancel) throws ServiceException {
        try {
            return arancelRepository.save(tblArancel);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public TblArancel update(TblArancel tblArancel) throws ServiceException {
       try {
            //Validar si existe el registro
            Optional<TblArancel> arancel = arancelRepository.findById(tblArancel.getId());
            if (arancel.isPresent()) {
                //Actualizar el registro
                TblArancel arancelUpdate = arancel.get();
                BeanUtils.copyProperties(tblArancel, arancelUpdate);
                return arancelRepository.save(arancelUpdate);
            } else {
                throw new ServiceException("El registro no existe");
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Boolean delete(TblArancel tblArancel) throws ServiceException {
        try {
            //Validar si existe el registro
            Optional<TblArancel> arancel = arancelRepository.findById(tblArancel.getId());
            if (arancel.isPresent()) {
                //Eliminar el registro
                arancelRepository.delete(tblArancel);
                return true;
            } else {
                throw new ServiceException("El registro no existe");
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
