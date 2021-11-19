package io.dnd.modakcut.domain.room.service;

import java.util.stream.Collectors;

import io.dnd.modakcut.domain.medium.domain.Medium;
import io.dnd.modakcut.domain.room.domain.repository.RoomRepository;
import io.dnd.modakcut.domain.room.exception.RoomNotFoundException;
import io.dnd.modakcut.domain.room.presentation.dto.response.MediaResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryRoomMediaService {

	private final RoomRepository roomRepository;

	public MediaResponse execute(String roomId) {
		return new MediaResponse(roomRepository.findById(roomId)
				.orElseThrow(() -> RoomNotFoundException.EXCEPTION)
				.getMedia()
				.stream()
				.map(Medium::getId)
				.collect(Collectors.toList())
		);
	}

}
