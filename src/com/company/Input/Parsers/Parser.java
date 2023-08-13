package com.company.Input.Parsers;

import com.company.Input.Requests.Request;

import java.util.List;

public interface Parser<T extends Request> {
    void parse(T request, List<String> validationContext);
}
