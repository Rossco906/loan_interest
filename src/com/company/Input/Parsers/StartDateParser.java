package com.company.Input.Parsers;

import com.company.DateUtil;
import com.company.Input.Requests.Request;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class StartDateParser implements Parser<Request> {
    private final String[] payload;
    private final int inputOrder;

    public StartDateParser(String[] payload, int inputOrder){
        this.payload = payload;
        this.inputOrder = inputOrder;
    }

    @Override
    public void parse(Request request, List<String> validationContext) {
        LocalDate validatedDate = null;
        try{
            LocalDate convertedDate = DateUtil.stringToLocalDate(payload[inputOrder]);
            if (convertedDate.isBefore(LocalDate.now())) {
                validationContext.add("StartDate parameter must not be before current date");
            }else{
                validatedDate = convertedDate;
            }
        }catch(DateTimeParseException e){
            validationContext.add("StartDate parameter was not in yyyy-mm-dd format");
        }
        request.setStartDate(validatedDate);
    }
}
