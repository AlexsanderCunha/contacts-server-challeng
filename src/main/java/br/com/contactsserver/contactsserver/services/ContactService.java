package br.com.contactsserver.contactsserver.services;
import br.com.contactsserver.contactsserver.dto.ContactDTO;
import br.com.contactsserver.contactsserver.model.Contact;
import br.com.contactsserver.contactsserver.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        repository.save(contact);
        return modelMapper.map(contact, ContactDTO.class);
    }

    public Stream<ContactDTO> getAllContacts(){
       return repository.findAll().stream().map(c -> modelMapper.map(c, ContactDTO.class));
    }

    public ContactDTO getOneContact(Long id){
        Optional<Contact> contact = repository.findById(id);
        if(contact.isPresent()){
           return  modelMapper.map(contact, ContactDTO.class);
        }
         throw new RuntimeException();
    }

    public ResponseEntity<Void> deleteContact(Long id ){
        repository.deleteById(id);
        return null;
    }

    public ContactDTO updateContact(Long id,ContactDTO contactDTO){
         Optional<Contact> contact = repository.findById(id);
        if(contact.isPresent()){
            contact.get().setName(contactDTO.getName());
            contact.get().setEmail(contactDTO.getEmail());
            contact.get().setPhone(contactDTO.getPhone());
            repository.save(contact.get());
            return modelMapper.map(contact, ContactDTO.class);
        }
           throw new RuntimeException();
    }
}
