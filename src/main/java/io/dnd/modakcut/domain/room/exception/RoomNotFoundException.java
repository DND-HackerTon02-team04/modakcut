package io.dnd.modakcut.domain.room.exception;

import io.dnd.modakcut.global.error.exception.ErrorCode;
import io.dnd.modakcut.global.error.exception.ModakcutException;

public class RoomNotFoundException extends ModakcutException {

	public static final ModakcutException EXCEPTION =
			new RoomNotFoundException();

	public RoomNotFoundException() {
		super(ErrorCode.ROOM_NOT_FOUND);
	}

}
