package br.com.contactsserver.contactsserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;

}
