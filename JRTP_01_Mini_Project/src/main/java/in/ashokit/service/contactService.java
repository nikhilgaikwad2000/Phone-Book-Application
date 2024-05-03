package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.Contact;

public interface contactService {
  public String saveContact(Contact contact);
  public List<Contact> getAllContact();
  public Contact getContactById(Integer contactId);
  public String updateContact(Contact contact);
  public String deleteContactById(Integer contactId);
  
}
