package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailAddress {

    private final String address;
    private final String label;

    @JsonCreator
    public EmailAddress(
            @JsonProperty("address") String address,
            @JsonProperty("label") String label) {
        this.address = address;
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public String getLabel() {
        return label;
    }
}
