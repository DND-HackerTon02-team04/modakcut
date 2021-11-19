package io.dnd.modakcut.domain.room.service;

import io.dnd.modakcut.domain.room.domain.Room;
import io.dnd.modakcut.domain.room.domain.repository.RoomRepository;
import io.dnd.modakcut.domain.room.presentation.dto.response.PostRoomResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostRoomService {

	private final RoomRepository roomRepository;

	public PostRoomResponse execute() {
		Room room = roomRepository
				.save(
						Room.builder()
						.build()
				);
		return new PostRoomResponse(room.getUUID());
	}

}
