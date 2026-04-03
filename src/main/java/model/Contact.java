package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contact {

    private final String firstName;
    private final String lastName;
    private final String company;
    private final String jobTitle;
    private final List<PhoneNumber> phoneNumbers;
    private final List<EmailAddress> emailAddresses;

    @JsonCreator
    public Contact(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("company") String company,
            @JsonProperty("jobTitle") String jobTitle,
            @JsonProperty("phoneNumbers") List<PhoneNumber> phoneNumbers,
            @JsonProperty("emailAddresses") List<EmailAddress> emailAddresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
        this.phoneNumbers = phoneNumbers != null
                ? new ArrayList<>(phoneNumbers)
                : new ArrayList<>();
        this.emailAddresses = emailAddresses != null
                ? new ArrayList<>(emailAddresses)
                : new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return Collections.unmodifiableList(phoneNumbers);
    }

    public List<EmailAddress> getEmailAddresses() {
        return Collections.unmodifiableList(emailAddresses);
    }
}
