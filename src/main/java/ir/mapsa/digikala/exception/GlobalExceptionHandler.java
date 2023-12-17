package ir.mapsa.digikala.exception;

import ir.mapsa.digikala.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ResponseStatusException.class})
    public ResponseEntity<ExceptionDto> handleResponseStatusException(ResponseStatusException ex) {
        log.error(ex.getMessage());

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setCode(ex.getStatus().value());
        exceptionDto.setMessage(ex.getMessage());
        exceptionDto.setDate(LocalDateTime.now());

        return ResponseEntity.of(Optional.of(exceptionDto));
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionDto> handleNoSuchElementException(Exception ex) {
        log.error(ex.getMessage());

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionDto.setMessage(ex.getMessage());
        exceptionDto.setDate(LocalDateTime.now());

        return ResponseEntity.of(Optional.of(exceptionDto));
    }

}
