package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneNumber {

    private final String number;
    private final String label;

    @JsonCreator
    public PhoneNumber(
            @JsonProperty("number") String number,
            @JsonProperty("label") String label) {
        this.number = number;
        this.label = label;
    }

    public String getNumber() {
        return number;
    }

    public String getLabel() {
        return label;
    }
}
