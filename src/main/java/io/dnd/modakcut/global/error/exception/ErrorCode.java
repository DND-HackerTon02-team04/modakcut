package io.dnd.modakcut.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum ErrorCode {

	FILE_EMPTY(400, "File is Empty"),
	FILE_UPLOAD_FAIL(400, "File upload was fail."),

	ROOM_NOT_FOUND(404, "Room not found");

	private int status;
	private String message;

}
