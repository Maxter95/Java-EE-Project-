package rhservices;

import java.sql.Date;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Message;


@Local
public interface MessageManagerLocal {

	Message getFirstAfter(java.util.Date lastUpdate);

	void sendMessage(Message message);

	
 
}