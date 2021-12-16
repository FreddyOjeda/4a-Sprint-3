package com.vitrineando.Compras.Controladores;

import com.vitrineando.Compras.Modelos.Facturas;
import com.vitrineando.Compras.Repositorios.FacturaRepository;
import com.vitrineando.Compras.Repositorios.TrolleyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
public class FacturaController {

    private final FacturaRepository facturaRepository;
    private final TrolleyRepository trolleyRepository;

    public FacturaController(FacturaRepository facturaRepository, TrolleyRepository trolleyRepository) {
        this.facturaRepository = facturaRepository;
        this.trolleyRepository = trolleyRepository;
    }

    @GetMapping("/factura/{username}/")
    Facturas getFactura(@PathVariable String username){
        return this.facturaRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "no funciono"));
    }

    @GetMapping("/facturas/")
    List<Facturas> getAllFacturas(@RequestParam("u") Optional<String> username){
        if (username.isPresent()){
            return this.facturaRepository.findByRegexUsername(username.get());
        }else{
            return  this.facturaRepository.findAll();
        }
    }

    @PostMapping("/factura/")
    Facturas crearFactura(@RequestBody Facturas factura){
        return this.facturaRepository.save(factura);
    }

    @DeleteMapping("/delete_factura/{username}/")
    String eliminarFactura(@PathVariable String username){
         this.facturaRepository.deleteById(username);
         return "Eliminacion completa";
    }

    @PutMapping("/update_Factura/{username}/")
    String updateFactura(@RequestBody Facturas factura,@PathVariable String username){
        if(this.facturaRepository.existsById(username)){
            this.facturaRepository.deleteById(username);
            this.facturaRepository.save(factura);
            return "Cambio Exitoso";
        }else{
            return "ERROR... La factura no existe.";
        }
    }

    /*
    @GetMapping("/factura/{username}")
    Facturas getFactura(@PathVariable String username){
        return this.facturaRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "no funciono"));
    }
     */
}
