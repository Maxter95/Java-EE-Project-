package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import rhservices.MessageManagerLocal;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Message;

 
/**
 *
 * @author Anton Danshin
 */
@ManagedBean
@ViewScoped
public class MessageBean implements Serializable {
 
    @EJB
    MessageManagerLocal mm;
 
    private final List messages;
    private Date lastUpdate;
    private Message message;
 
    /**
     * Creates a new instance of MessageBean
     */
    public MessageBean() {
        messages = Collections.synchronizedList(new LinkedList());
        lastUpdate = new Date(0);
        message = new Message();
    }
 
    public Date getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
 
    public Message getMessage() {
        return message;
    }
 
    public void setMessage(Message message) {
        this.message = message;
    }
 
    public String sendMessage(ActionEvent evt) {
        mm.sendMessage(message);
        String n = "/Chat?faces-redirect=true";
		return n;
    }
 
    public void firstUnreadMessage(ActionEvent evt) {
       RequestContext ctx = RequestContext.getCurrentInstance();
 
       Message m = mm.getFirstAfter(lastUpdate);
 
       ctx.addCallbackParam("ok", m!=null);
       if(m==null)
           return;
 
       lastUpdate = m.getDateSent();
 
       ctx.addCallbackParam("user", m.getUser());
       ctx.addCallbackParam("dateSent", m.getDateSent().toString());
       ctx.addCallbackParam("text", m.getMessage());
 
    }

	public MessageManagerLocal getMm() {
		return mm;
	}

	public void setMm(MessageManagerLocal mm) {
		this.mm = mm;
	}

	public List getMessages() {
		return messages;
	}
 
}
