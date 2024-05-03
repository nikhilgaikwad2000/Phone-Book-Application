package in.ashokit.binding;


import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import lombok.Data;
@javax.persistence.Entity
@Data
@javax.persistence.Table(name = "CONTACT_DTLS")
public class Contact {
	@Id
    @GeneratedValue
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNum;
}
