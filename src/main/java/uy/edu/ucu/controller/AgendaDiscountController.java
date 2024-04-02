package uy.edu.ucu.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy.edu.ucu.dto.AgendaDiscountDTO;
import uy.edu.ucu.service.AgendaDiscountService;

import java.util.UUID;

@RestController
@RequestMapping("/agenda/discount")
@AllArgsConstructor(onConstructor_={@Autowired})
public class AgendaDiscountController {

    private final AgendaDiscountService agendaDiscountService;

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDiscountDTO> obtenerPedidoPorId(@PathVariable final UUID id) {
        return new ResponseEntity<>(agendaDiscountService.getAgendaDiscount(id).convertToDTO(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<AgendaDiscountDTO> createAgendaDiscount(@RequestBody AgendaDiscountDTO agendaDiscountDTO) {
        return new ResponseEntity<>(agendaDiscountService.createAgendaDiscount(agendaDiscountDTO).convertToDTO(), HttpStatus.OK);
    }
}