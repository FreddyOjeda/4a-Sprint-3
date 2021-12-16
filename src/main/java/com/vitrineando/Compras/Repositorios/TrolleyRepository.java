package com.vitrineando.Compras.Repositorios;

import com.vitrineando.Compras.Modelos.Trolley;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrolleyRepository extends MongoRepository<Trolley, String> {

    @Query("{´username´ : {´$regex´ : ?0, ´$options´ : ´i´}}")
    List<Trolley> findByRegexUsername(String term);

}
