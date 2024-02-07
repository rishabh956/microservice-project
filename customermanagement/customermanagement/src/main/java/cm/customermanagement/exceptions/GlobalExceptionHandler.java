package cm.customermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cm.customermanagement.output.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFound.class)
	ResponseEntity<ApiResponse> customerNotFoundExceptionHandler(CustomerNotFound ex)
	{
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerExistException.class)
	ResponseEntity<ApiResponse> customerExistExceptionHandler(CustomerExistException ex)
	{
		String messageString = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(messageString, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.CONFLICT);
	}
}
