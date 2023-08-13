package com.company.Input.Requests;

import java.time.LocalDate;

public interface Request {
    void setStartDate(LocalDate date);
    void setEndDate(LocalDate date);
    LocalDate getStartDate();
    LocalDate getEndDate();
}
