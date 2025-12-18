package com.easybytes.controller;

import com.easybytes.model.Contact;
import com.easybytes.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepository contactRepository;

    @PostMapping("/contact")
    public Contact saveContactDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    private String getServiceReqNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(999990000) + 9999;
        return "SR" + randomNumber;
    }

}
