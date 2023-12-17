package ir.mapsa.digikala.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDto {
    private int code;
    private String message;
    private LocalDateTime date;
}
