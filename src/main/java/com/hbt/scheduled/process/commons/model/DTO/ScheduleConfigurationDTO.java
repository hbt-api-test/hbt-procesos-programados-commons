package com.hbt.scheduled.process.commons.model.DTO;


import com.hbt.scheduled.process.commons.model.FrecuencyScheduledProcess;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.quartz.DateBuilder;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleConfigurationDTO {


    private static final int REFERENCE_WILDCARD = 99;

    private Long id;
    private FrecuencyScheduledProcess frecuency;
    private int hour;
    private int minutes;
    private int dayOfMonth;
    private List<WeekDaysDTO> daysOfWeek;
    private List<MonthsScheduledDTO> months;
    private String cronExpresion;

    public Boolean validHour(){
        try{
            DateBuilder.validateHour(this.hour);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public Boolean validMinutes(){
        try{
            DateBuilder.validateMinute(this.minutes);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public Boolean validDayOfMonth(){
        try{
            DateBuilder.validateDayOfMonth(this.dayOfMonth);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public Boolean validDaysOfWeek(){
        try{
            this.daysOfWeek.forEach(day ->
                    DateBuilder.validateDayOfWeek(
                            Integer.parseInt(
                                    String.valueOf(day.getId())
                            )
                    )
            );
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public Boolean validMonths(){
        try{
            this.months.forEach(month ->
                    DateBuilder.validateMonth(
                            Integer.parseInt(
                                    String.valueOf(month.getId())
                            )
                    )
            );
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public String getMonthName(int id, Locale locale){
        return Month.of(id).getDisplayName(TextStyle.SHORT, locale);
    }

    public String getDayOfWeekName(int id, Locale locale){
        return DayOfWeek.of(id).getDisplayName(TextStyle.SHORT, locale);
    }

    public String getValidHour(){
        if(this.hour == REFERENCE_WILDCARD){
            return "*";
        }
        return validHour() ? String.valueOf(this.hour) : "";
    }

    public String getValidMinutes(){
        if(this.minutes == REFERENCE_WILDCARD){
            return "*";
        }
        return validMinutes() ? String.valueOf(this.minutes) : "";
    }

    public String getValidDayOfMonth(){
        if(this.dayOfMonth == REFERENCE_WILDCARD){
            return "*";
        }
        return validDayOfMonth() ? String.valueOf(this.dayOfMonth) : "";
    }



}
