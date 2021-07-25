package company.aex.SpringSecurity.service;

import company.aex.SpringSecurity.model.Depositos;
import company.aex.SpringSecurity.model.Retiros;
import company.aex.SpringSecurity.repository.DepositosRepository;
import company.aex.SpringSecurity.repository.RetirosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepositosService {

    @Autowired
    private DepositosRepository depositosRepository;

    @Autowired
    private RetirosRepository retirosRepository;

    public List<Depositos> RealizarCalculoDesaldo(){
        List<Depositos> lista = depositosRepository.findAll();
        List<Retiros> retiros = retirosRepository.findAll();
        List<Depositos> saldo =  new ArrayList<>(lista);

        for(Retiros r: retiros){
                for(Depositos d: saldo) {
                    if (d.getCliente().getDni().equals(r.getCliente().getDni())) {

                        Integer montoNuevo = (d.getMonto() - r.getMonto());

                        if(d.getMonto() >= 1000){
                            d.setMonto(montoNuevo);
                        }else {
                            if(montoNuevo < 0){
                                d.setMonto(d.getMonto());
                            }
                        }

                    } else {
                        if (!d.getCliente().getDni().equals(r.getCliente().getDni())) {
                            d.setMonto(d.getMonto());
                        }
                    }
                }
            }
        return saldo;
    }

    public String Actual(String dni){
        int saldo = 0;
        List<Depositos> saldoActual = RealizarCalculoDesaldo();
        for (Depositos d: saldoActual){
            if(d.getCliente().getDni().equals(dni)){
                saldo += d.getMonto();
            }
        }
        return "Saldo: "+ saldo;
    }
}
