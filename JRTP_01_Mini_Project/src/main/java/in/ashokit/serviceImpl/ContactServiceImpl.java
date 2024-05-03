package in.ashokit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Contact;
import in.ashokit.repo.ContactRepo;
import in.ashokit.service.contactService;

@Service
public class ContactServiceImpl implements contactService {

	@Autowired
	private ContactRepo repo;

	@Override
	public String saveContact(Contact contact) {
		 contact = repo.save(contact);
		if (contact.getContactId() != null) {
			return "Contact saved....!";
		} else {
			return "Contact faild to save..";
		}

	}

	@Override
	public List<Contact> getAllContact() {
		return repo.findAll();

	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> findById = repo.findById(contactId);
		if (findById.isPresent()) {
			System.out.println(findById.get());
		}
		return null;

	}

	// polymarphic method
	@Override
	public String updateContact(Contact contact) {
		if (repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "update success";
		} else {
			return "No record found";
		}

	}

	@Override
	public String deleteContactById(Integer contactId) {

		if (repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "Record deleted Succesfully......";
		} else {
			return "No record found";
		}

	}

}
