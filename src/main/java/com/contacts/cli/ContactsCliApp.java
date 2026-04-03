package com.contacts.cli;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Contact;
import model.EmailAddress;
import model.PhoneNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class ContactsCliApp {

    private ContactsCliApp() {
    }

    public static void main(String[] args) throws Exception {
        Contact[] contacts = buildSampleContacts();

        Arrays.sort(contacts, Comparator.comparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER));

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        System.out.println(mapper.writer(printer).writeValueAsString(contacts));
    }

    private static Contact[] buildSampleContacts() {
        Contact david = new Contact(
                "David",
                "Sanger",
                "Argos LLC",
                "Sales Manager",
                List.of(
                        new PhoneNumber("240-133-0011", "Home"),
                        new PhoneNumber("240-112-0123", "Mobile")),
                List.of(
                        new EmailAddress("dave.sang@gmail.com", "Home"),
                        new EmailAddress("dsanger@argos.com", "Work")));

        Contact carlos = new Contact(
                "Carlos",
                "Jimenez",
                "Zappos",
                "Director",
                List.of(),
                List.of());

        Contact ali = new Contact(
                "Ali",
                "Gafar",
                "BMI Services",
                "HR Manager",
                List.of(new PhoneNumber("412-116-9988", "Work")),
                List.of(new EmailAddress("ali@bmi.com", "Work")));

        return new Contact[] { david, carlos, ali };
    }
}
