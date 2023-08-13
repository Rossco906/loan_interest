package com.company.Input.Parsers;

import com.company.DateUtil;
import com.company.Input.Requests.Request;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class EndDateParser implements Parser<Request> {
    private final String[] payload;
    private final int inputOrder;

    public EndDateParser(String[] payload, int inputOrder){
        this.payload = payload;
        this.inputOrder = inputOrder;
    }

    @Override
    public void parse(Request request, List<String> validationContext) {
        LocalDate validatedDate = null;
        LocalDate startDate = request.getStartDate();
        try{
            LocalDate convertedDate = DateUtil.stringToLocalDate(payload[inputOrder]);
            if (startDate != null && convertedDate.isBefore(startDate)){
                validationContext.add("EndDate parameter must be after start date");
            }else {
                validatedDate = convertedDate;
            }

        }catch(DateTimeParseException e){
            validationContext.add("EndDate parameter was not in yyyy-mm-dd format");
        }
        request.setEndDate(validatedDate);
    }
}
