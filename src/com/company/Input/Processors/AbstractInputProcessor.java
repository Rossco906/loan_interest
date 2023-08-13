package com.company.Input.Processors;

import com.company.Input.Parsers.Parser;
import com.company.Input.Requests.Request;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInputProcessor<T extends Request> {
    private List<Parser> parsers = new ArrayList<>();

    public T process(){
        T outputResponse = createResponse();
        List<String> validationContext = new ArrayList<>();
        for (Parser parser : parsers){
            parser.parse(outputResponse, validationContext);
        }

        if (validationContext.size() > 0){
            String formattedValidation = String.join("\n", validationContext);
            System.err.printf("Validation failed with the following messages %s", formattedValidation);
            System.exit(1);
        }
        return outputResponse;
    }

    void addValidator(Parser parser){
        parsers.add(parser);
    }

    public abstract void registerParsers();
    abstract T createResponse();
}
