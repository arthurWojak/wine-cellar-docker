package org.formation.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.formation.entity.Wine;

@ApplicationScoped
public class WineRepository implements PanacheRepository<Wine> {
}
