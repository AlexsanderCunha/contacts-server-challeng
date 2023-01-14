package br.com.contactsserver.contactsserver.repository;

import br.com.contactsserver.contactsserver.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ContactRepository extends JpaRepository<Contact, Long> {
}
