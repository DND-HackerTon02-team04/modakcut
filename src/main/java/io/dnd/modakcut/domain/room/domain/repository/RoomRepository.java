package io.dnd.modakcut.domain.room.domain.repository;

import io.dnd.modakcut.domain.room.domain.Room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {
}
