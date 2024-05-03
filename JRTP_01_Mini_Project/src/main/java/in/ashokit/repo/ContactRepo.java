package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.binding.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
