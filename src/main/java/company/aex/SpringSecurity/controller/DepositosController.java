package company.aex.SpringSecurity.controller;

import company.aex.SpringSecurity.service.DepositosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposito")
public class DepositosController {

    @Autowired
    private DepositosService depositosService;

    @GetMapping("/calcular")
    public ResponseEntity<?> Calcular(){
        return ResponseEntity.status(HttpStatus.OK).body(depositosService.RealizarCalculoDesaldo());
    }

    @GetMapping("/actual/{dni}")
    public ResponseEntity<?> BuscarCliente(@PathVariable String dni){
        return ResponseEntity.status(HttpStatus.OK).body(depositosService.Actual(dni));
    }

}
