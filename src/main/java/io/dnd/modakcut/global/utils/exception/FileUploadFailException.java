package io.dnd.modakcut.global.utils.exception;

import io.dnd.modakcut.global.error.exception.ErrorCode;
import io.dnd.modakcut.global.error.exception.ModakcutException;

public class FileUploadFailException extends ModakcutException {

	public static final ModakcutException EXCEPTION =
			new FileUploadFailException();

	public FileUploadFailException() {
		super(ErrorCode.FILE_UPLOAD_FAIL);
	}

}
