package io.dnd.modakcut.domain.medium.domain.repository;

import io.dnd.modakcut.domain.medium.domain.Medium;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediumRepository extends CrudRepository<Medium, String> {
}
