package io.dnd.modakcut.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModakcutException extends RuntimeException {

	private final ErrorCode errorCode;

}
