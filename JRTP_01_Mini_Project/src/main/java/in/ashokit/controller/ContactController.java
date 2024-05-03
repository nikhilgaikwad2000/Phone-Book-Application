package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Contact;
import in.ashokit.serviceImpl.ContactServiceImpl;

@RestController
public class ContactController {
	@Autowired
	private ContactServiceImpl service;

	@PostMapping(value = "/contact")
	public String createContact(@RequestBody Contact contact) {

		String status = service.saveContact(contact);
		return status;

	}

	@GetMapping(value = "/contacts")
	public List<Contact> getAllContacts() {
		return service.getAllContact();

	}

	@GetMapping(value = "/contact/{contactId}")
	public Contact getContactById(@PathVariable("contactId") Integer contactId) {
		Contact contact = service.getContactById(contactId);

		return contact;

	}

	@PutMapping(value = "/contact")
	public String updateContact(@RequestBody Contact contact) {
		String updateContact = service.updateContact(contact);
		return updateContact;

	}

	@DeleteMapping(value = "/contact/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {
		return service.deleteContactById(contactId);

	}
}
