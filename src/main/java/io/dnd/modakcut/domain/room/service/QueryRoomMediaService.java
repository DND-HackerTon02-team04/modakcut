package io.dnd.modakcut.domain.room.service;

import java.util.stream.Collectors;

import io.dnd.modakcut.domain.room.domain.repository.RoomRepository;
import io.dnd.modakcut.domain.room.exception.RoomNotFoundException;
import io.dnd.modakcut.domain.room.presentation.dto.response.MediaResponse;
import io.dnd.modakcut.global.utils.S3Util;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryRoomMediaService {

	private final RoomRepository roomRepository;
	private final S3Util s3Util;

	public MediaResponse execute(String roomId) {
		return new MediaResponse(roomRepository.findById(roomId)
				.orElseThrow(() -> RoomNotFoundException.EXCEPTION)
				.getMedia()
				.stream()
				.map(medium -> s3Util.getObjectUrl(medium.getId()))
				.collect(Collectors.toList())
		);
	}

}
