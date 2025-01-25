package dev.aman.job_portal_userservice.ControllerAdvice;

import dev.aman.job_portal_userservice.Utilities.ErrorInfo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    //this is for all exception i.e if no particular exception has occurred then this will occur
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(exception.getMessage());
        errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorInfo.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //these exceptions are for validation i.e when we encounter @NotNull, @NotBlank etc
    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorInfo> validatorExceptionHandler(Exception exception) {
        String errorMessage = "";
        //here we are checking if instance is of type MethodArgumentNotValidException
        if (exception instanceof MethodArgumentNotValidException) {
            //Casts the exception to MethodArgumentNotValidException.
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) exception;
            // Extracting error messages from MethodArgumentNotValidException using Streams
            errorMessage = methodArgumentNotValidException.getAllErrors().stream()
                    //map each validation error to its default error message
                    .map(ObjectError::getDefaultMessage)
                    //Joins the error messages into a single string separated by commas
                    .collect(Collectors.joining(","));
        } else if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) exception;
            // Extracting error messages from ConstraintViolationException
            Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
            errorMessage = violations.stream()
                    .map(ConstraintViolation::getMessage) // Get the message from each violation
                    .collect(Collectors.joining(","));
        }

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage(errorMessage);
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorInfo.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}