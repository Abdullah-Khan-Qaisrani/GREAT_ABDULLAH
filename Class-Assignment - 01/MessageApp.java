import java.util.Scanner;

public class MessageApp {

    Message sms[][];
    static int messageCount;
	int choice;

    {
        sms = new Message[100][6];
        messageCount = 0;
    }

	{
        	messageSent("Hello", "03455672", "03432487654", true);
        	messageSent("Hi", "03455672", "0354474820", false);
        	messageSent("There", "03455672", "03543447820", true);
        	messageSent("How are you?", "03455672", "03547847821", false);
        	messageSent("Good Morning", "03455672", "03544717821", true);
        	messageSent("Are you coming?", "03455672", "03543447821", true);
        	messageSent("See you soon", "03455672", "0354847822", false);
        	messageSent("Let's meet", "03455672", "03544707822", false);
        	messageSent("What's up?", "03455672", "03543447822", true);
        	messageSent("Take care", "03455672", "0354847823", true);
        	messageSent("Stay safe", "03455672", "03544717823", true);
        	messageSent("Talk later", "03455672", "03543447823", false);
        	messageSent("Miss you", "03455672", "03548147824", true);
        	messageSent("See you next week", "03455672", "03544787824", true);
        	messageSent("Let's go out", "03455672", "03543447824", false);
        	messageSent("Good Night", "03455672", "03548247825", true);
    }

    public void messageSent(String messageContent, String senderNumber, String receiverNumber, boolean status) {
        if (messageCount < sms.length) {
            for (int i = 0; i < sms[messageCount].length; i++) {
                if (sms[messageCount][i] == null) {
                    sms[messageCount][i] = new Message(messageContent, senderNumber, receiverNumber, status);
                    messageCount++;
			return; 
                }
            }
            
        }

	
    }

	public void sendMessage() {
		Scanner sc = new Scanner(System.in);
		 System.out.print("Enter sender number: ");
		String senderNumber = sc.nextLine();

		System.out.print("Enter receiver number: ");
                String receiverNumber = sc.nextLine();

        	System.out.print("Enter message content: ");
        	String messageContent = sc.nextLine();

        	System.out.print("Is the message sent? (true/false): ");
        	boolean status = sc.nextBoolean();

		messageSent(messageContent, senderNumber, receiverNumber, status);
		System.out.println("Message sent successfully!");

	}

	public void displayAllMessages() {
    		System.out.println("All Message details:\n");
    		for (int i = 0; i <= messageCount; i++) {
       		 for (int j = 0; j < sms[i].length; j++) {
            		if (sms[i][j] != null) {
                		System.out.println(sms[i][j].toString());
            		}
        	}
    		}
	}

    public void displaySpecificMessage(String recieverNumber) {
		System.out.println("---Messages sent to " + recieverNumber + "is given below---");
        for (int i = 0; i < messageCount; i++) {
            for (int j = 0; j < sms[i].length; j++) {
                if (sms[i][j] != null && sms[i][j].getReciever().equals(recieverNumber)) {
                    System.out.println(sms[i][j].toString());
                }
            }
        }
    }

	public void searchMessage(String id) {
		boolean found = false;
		for(int i = 0; i < messageCount; i++) {
			for(int j = 0; j < sms[i].length; j++) {
			  	if (sms[i][j] != null && sms[i][j].getId().equals(id)) {
                		System.out.println("Message found Successfully:\n");
                		System.out.println(sms[i][j].toString());
                		found = true;
                		return;
            			}
			}
		}
			if(!found) {
				System.out.println("No message found.");
			}
	}


		public void messageStatus(String id) {
			boolean found = false;
			for(int i = 0; i < messageCount; i++) {
				for(int j = 0; j < sms[i].length; j++) {
					if(sms[i][j] != null && sms[i][j].getId().equals(id)) {
						found = true;
						System.out.println(sms[i][j].toString());
						if(sms[i][j].getStatus() == true) {
							System.out.println("Ststus: Delievered\n");
						}
						else {
							System.out.println("Status: Not Delievered\n");
						} return;
					}
				}
			}
				if(!found) {
					System.out.println("No message found with id: \n" + id);
				}
		}

	
	public void deleteMessage(String id) {
		boolean found = false;
		 for (int i = 0; i < messageCount; i++) {
			for(int j = 0; j < sms[i].length; j++) {
				if(sms[i][j] != null && sms[i][j].getId().equals(id)) {
					found = true;
					sms[i][j] = null;
					System.out.println("Message with id: " + id + " has been deleted successfully.\n");
					return;
				}
			}
		}
			if(!found) {
				System.out.println("No message found with id: " + id);
			}

	}


	public void sortMessages() {
    		if (messageCount <= 1) {
       		 	System.out.println("No need to sort, as there are one or zero messages.");
        		return;
    		}

    		Message[] sortedMessages = new Message[messageCount];

    		for (int i = 0; i < messageCount; i++) {
        		sortedMessages[i] = sms[i][0];
    		}

    		for (int i = 0; i < messageCount; i++) {
        		sms[i][0] = sortedMessages[messageCount - 1 - i];
    		}

    		System.out.println("Messages sorted successfully!\n");
	}



		public void choiceFunction() {
			Scanner sc = new Scanner(System.in);

			System.out.println("--Message Application Menu--\n");
			System.out.println("1. Send a Message.");
			System.out.println("2. Display all Messages.");
			System.out.println("3. Display specific Message.");
			System.out.println("4. Search Message by Id.");
			System.out.println("5. Check the Status of Message.");
			System.out.println("6. Delete message.");
			System.out.println("7. Sort the messages.");
			System.out.println("0. exit the program.\n");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				sendMessage();
				choiceFunction();
				break;
			case 2:
				displayAllMessages();
				choiceFunction();
				break;
			case 3:
				System.out.print("Enter the recieverNumber to display specific message: ");
				String recieverNumber1 = sc.nextLine();
				displaySpecificMessage(recieverNumber1);
				choiceFunction();
				break;
			case 4:
				System.out.print("Enter the id to search message: ");
				String searchId = sc.nextLine();
				searchMessage(searchId);
				choiceFunction();
				break;
			case 5:
				System.out.print("Enter the id to check status of message: ");
				String statusId = sc.nextLine();
				messageStatus(statusId);
				choiceFunction();
				break;
			case 6:
				System.out.print("Enter the id to delete a message: ");
				String deleteId = sc.nextLine();
				deleteMessage(deleteId);
				choiceFunction();
				break;
			case 7:
				sortMessages();
				choiceFunction();
				break;
			case 0:
				break;
				
			}

		}




}



















