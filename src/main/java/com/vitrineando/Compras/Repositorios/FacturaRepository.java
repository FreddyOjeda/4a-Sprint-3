package com.vitrineando.Compras.Repositorios;

import com.vitrineando.Compras.Modelos.Facturas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FacturaRepository extends MongoRepository<Facturas, String> {

    @Query("{´username´ : {´$regex´ : ?0, ´$options´ : ´i´}}")
    List<Facturas> findByRegexUsername(String term);
}
