import java.time.LocalDateTime;

public class Message{

	String messageContent;
	String senderNumber;
	String recieverNumber;
	boolean status;
	String messageId;
	LocalDateTime dateTime;
	static int counter;

	public Message(String messageContent, String senderNumber, String recieverNumber, boolean status){
		this.messageId = String.format("%03d", ++counter);
		this.messageContent = messageContent;
		this.senderNumber = senderNumber;
		this.recieverNumber = recieverNumber;
		this.status = status;
		this.dateTime = LocalDateTime.now();
	}

	public void setMessage(String messageContent){
		this.messageContent = messageContent;
	}

	public String getMessage() {
		return messageContent;
	}

	public void setSender(String senderNumber) {
		this.senderNumber = senderNumber;
	}

	public String getSender() {
		return senderNumber;
	}

	public void setReciever(String recieverNumber) {
		this.recieverNumber = recieverNumber;
	}

	public String getReciever() {
		return recieverNumber;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageId() {
		return messageId;
	}

	public String getId() {
    		return messageId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	 public String toString() {
        		return "Message Details: \n" +
               		"Message Content: " + messageContent + "\n" +
               		"Sender Number: " + senderNumber + "\n" +
               		"Receiver Number: " + recieverNumber + "\n" +
              	 	"Status: " + (status ? "Sent" : "Not Sent") + "\n" +
              	 	"Message ID: " + messageId + "\n" +
               		"Date and Time: " + dateTime + "\n";
   	 }

}