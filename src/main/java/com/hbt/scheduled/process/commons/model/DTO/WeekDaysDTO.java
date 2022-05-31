package com.hbt.scheduled.process.commons.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeekDaysDTO {

    private Long id;
    private String descripcion;

}
