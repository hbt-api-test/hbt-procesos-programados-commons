package com.hbt.scheduled.process.commons.model.DTO;



import com.hbt.scheduled.process.commons.model.StatusScheduledProcess;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduledProcessDTO {

    private Long idProcesoProgramado;
    private String nombreProcesoProgramado;
    private Integer numeroReintentos;
    private StatusScheduledProcess statusScheduledProcess;
    private String clases;
    private List<ProcessPropertyDTO> processProperty;
    private ScheduleConfigurationDTO scheduledConfiguration;


}
