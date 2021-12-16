package com.vitrineando.Compras.Controladores;

import com.vitrineando.Compras.Modelos.Facturas;
import com.vitrineando.Compras.Modelos.Trolley;
import com.vitrineando.Compras.Repositorios.FacturaRepository;
import com.vitrineando.Compras.Repositorios.TrolleyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class TrolleyController {

    private final FacturaRepository facturaRepository;
    private final TrolleyRepository trolleyRepository;

    public TrolleyController(FacturaRepository facturaRepository, TrolleyRepository trolleyRepository) {
        this.facturaRepository = facturaRepository;
        this.trolleyRepository = trolleyRepository;
    }

    @GetMapping("/trolley/{username}/")
    Trolley getTrolley(@PathVariable String username){
        return this.trolleyRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "mensaje de error"));
    }

    @GetMapping("/trolleys/")
    List<Trolley> getAllFacturas(@RequestParam("u") Optional<String> username){
        if (username.isPresent()){
            return this.trolleyRepository.findByRegexUsername(username.get());
        }else{
            return  this.trolleyRepository.findAll();
        }
    }

    @PostMapping("/create_trolley/")
    Trolley crearTrolley(@RequestBody Trolley trolley){
        return this.trolleyRepository.save(trolley);
    }

    @PutMapping("/update_trolley/{username}/")
    Trolley updateTrolley(@PathVariable String username, @RequestBody Trolley trolley){
        this.trolleyRepository.deleteById(username);
        this.trolleyRepository.save(trolley);
        return trolley;
    }

    @DeleteMapping("/delete_trolley/{username}/")
    void eliminarTrolley(@PathVariable String username){
        this.trolleyRepository.deleteById(username);
    }

    @PutMapping("/update_Trolley/{username}/")
    String updateTrolley(@RequestBody Trolley trolley,@PathVariable String username){
        if(this.trolleyRepository.existsById(username)){
            this.trolleyRepository.deleteById(username);
            this.trolleyRepository.save(trolley);
            return "Cambio Exitoso";
        }else{
            return "ERROR... La factura no existe.";
        }
    }

    //@DeleteMapping("/delete_factura/{username}/")
    //void eliminarFactura(@PathVariable String username){
    //    this.facturaRepository.deleteById(username);
    //}
}
