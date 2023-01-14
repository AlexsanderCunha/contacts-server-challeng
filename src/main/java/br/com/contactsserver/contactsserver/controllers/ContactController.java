package br.com.contactsserver.contactsserver.controllers;

import br.com.contactsserver.contactsserver.dto.ContactDTO;
import br.com.contactsserver.contactsserver.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.stream.Stream;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService service;


    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@RequestBody @Valid ContactDTO contactDTO, UriComponentsBuilder uriComponentsBuilder) {
        ContactDTO contactDTO1 = service.createContact(contactDTO);
        URI address = uriComponentsBuilder.path("/contacts/{id}").buildAndExpand(contactDTO1.getId()).toUri();
        return ResponseEntity.created(address).body(contactDTO1);
    }

    @GetMapping()
    public Stream<ContactDTO> getAllContacts() {
        return service.getAllContacts();
    }
    @GetMapping("/{id}")
    public ContactDTO getOneContact(@PathVariable @NotNull Long id){
        return service.getOneContact(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContactById(@PathVariable @NotNull Long id, @RequestBody @Valid ContactDTO contactDTO){
        ContactDTO contactDTO1 = service.updateContact(id,contactDTO);
        return ResponseEntity.ok(contactDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneContactbyID(@PathVariable @NotNull long id){
       return service.deleteContact(id);
    }

}
