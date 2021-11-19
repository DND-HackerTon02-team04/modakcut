package io.dnd.modakcut.global.utils.exception;

import io.dnd.modakcut.global.error.exception.ErrorCode;
import io.dnd.modakcut.global.error.exception.ModakcutException;

public class FileIsEmptyException extends ModakcutException {

	public static final ModakcutException EXCEPTION =
			new FileIsEmptyException();

	public FileIsEmptyException() {
		super(ErrorCode.FILE_EMPTY);
	}

}
