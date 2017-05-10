package com.citraining.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pcha21 on 3/27/2017.
 */
public class CITrainingException extends Exception {

	
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CITrainingException.class);

	public CITrainingException() {
		super();
		LOGGER.error(CITrainingException.class.toString());
	}

	public CITrainingException(String message) {
		super(message);
		LOGGER.error(CITrainingException.class.toString(), message);
	}

	public CITrainingException(Throwable message) {
		super(message);
		LOGGER.error(CITrainingException.class.toString(), message);
	}

	public CITrainingException(Exception message) {
		super(message);
		LOGGER.error(CITrainingException.class.toString(), message);
	}

	public String getFullMessage() {
		return super.getMessage();
	}
}
