package com.hbt.scheduled.process.commons.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessPropertyDTO {

    private Long idParametroProceso;
    private String nombreParametroProceso;
    private String valorParametroProceso;
    private Boolean requerido;

}
