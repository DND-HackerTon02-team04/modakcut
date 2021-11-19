package io.dnd.modakcut.domain.result.domain.repository;

import io.dnd.modakcut.domain.result.domain.Result;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<Result, String> {
}
