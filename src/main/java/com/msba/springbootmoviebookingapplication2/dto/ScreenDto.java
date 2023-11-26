package com.msba.springbootmoviebookingapplication2.dto;

import com.msba.springbootmoviebookingapplication2.entity.Screening;
import lombok.Data;

@Data
public class ScreenDto {
    private Long screenId;
    private Long theatreId;
    private Long seatsNumber;
    private Screening screening;
}
