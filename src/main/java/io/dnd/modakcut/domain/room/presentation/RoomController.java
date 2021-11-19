package io.dnd.modakcut.domain.room.presentation;

import io.dnd.modakcut.domain.room.presentation.dto.response.PostRoomResponse;
import io.dnd.modakcut.domain.room.service.PostRoomService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

	private final PostRoomService postRoomService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PostRoomResponse postRoom() {
		return postRoomService.execute();
	}

}
