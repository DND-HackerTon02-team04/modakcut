package io.dnd.modakcut.domain.room.service;

import io.dnd.modakcut.domain.medium.domain.Medium;
import io.dnd.modakcut.domain.medium.domain.repository.MediumRepository;
import io.dnd.modakcut.domain.room.domain.Room;
import io.dnd.modakcut.domain.room.domain.repository.RoomRepository;
import io.dnd.modakcut.domain.room.exception.RoomNotFoundException;
import io.dnd.modakcut.domain.room.presentation.dto.response.MediumUrlResponse;
import io.dnd.modakcut.global.utils.S3Util;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PostMediumService {

	private final RoomRepository roomRepository;
	private final MediumRepository mediumRepository;
	private final S3Util s3Util;

	public MediumUrlResponse execute(String roomId, MultipartFile file) {
		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> RoomNotFoundException.EXCEPTION);
		String fileName = s3Util.upload(file);
		mediumRepository.save(
				Medium.builder()
						.id(fileName)
						.room(room)
						.build()
		);

		return new MediumUrlResponse(fileName);
	}

}