package uy.edu.ucu.repository;

import uy.edu.ucu.dto.AgendaDiscountDTO;
import uy.edu.ucu.dto.DTO;
import uy.edu.ucu.model.PO.PO;
import uy.edu.ucu.repository.DO.DO;
import uy.edu.ucu.service.BO.BO;

import java.util.List;

@org.springframework.stereotype.Repository
public interface IRepository<DAO, DTO, BO, PO, DO, ID>   {

    BO create(BO entity);

    BO read(ID id);

    List<BO> read();

    BO update(BO entity);

    BO delete(BO entity);
}
