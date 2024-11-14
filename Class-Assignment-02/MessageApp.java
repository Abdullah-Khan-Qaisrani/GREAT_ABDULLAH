package MessageApp;
import java.util.Scanner;
public class MessageApp {
    Message sms[][];
    static int messageCount = 0;
    static int messageCounter =0;
    Message sms2[][];

    {
        sms = new Message[10][6];
    }

    {
        messageSent(null, "03455672", "03354721717", true);
        messageSent(null, "03455672", "03336481616", false);
        messageSent(null, "03455672", "03543447820", true);
        messageSent(null, "03455672", "03547847821", false);
        messageSent(null, "03455672", "03544717821", true);
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

    public String sendMessage() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter receiver number: ");
        String receiverNumber = sc.nextLine();

        System.out.print("Enter message content: ");
        String messageContent = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < messageCount; i++) {
            for (int j = 0; j < sms[i].length; j++) {
                if (sms[i][j] != null && sms[i][j].getReciever().equals(receiverNumber)) {
//                    System.out.println("Receiver found Successfully:\n");
                    System.out.println(sms[i][j].toString());
                    found = true;
                    if (sms[i][j].getMessage() == null) {
                        sms[i][j].setMessage(messageContent);
                        return sms[i][j].getMessage();
                    }
                }
            }
        }
        if (!found) {
            System.out.println("No Reciever found.");
        }
        return null;
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
        for (int i = 0; i < messageCount; i++) {
            for (int j = 0; j < sms[i].length; j++) {
                if (sms[i][j] != null && sms[i][j].getId().equals(id)) {
                    System.out.println("Message found Successfully:\n");
                    System.out.println(sms[i][j].toString());
                    found = true;
                    return;
                }
            }
        }
        if (!found) {
            System.out.println("No message found.");
        }
    }


    public void messageStatus(String id) {
        boolean found = false;
        for (int i = 0; i < messageCount; i++) {
            for (int j = 0; j < sms[i].length; j++) {
                if (sms[i][j] != null && sms[i][j].getId().equals(id)) {
                    found = true;
                    System.out.println(sms[i][j].toString());
                    if (sms[i][j].getStatus() == true) {
                        System.out.println("Ststus: Delievered\n");
                    } else {
                        System.out.println("Status: Not Delievered\n");
                    }
                    return;
                }
            }
        }
        if (!found) {
            System.out.println("No message found with id: \n" + id);
        }
    }


    public void deleteMessage(String id) {
        boolean found = false;
        for (int i = 0; i < messageCount; i++) {
            for (int j = 0; j < sms[i].length; j++) {
                if (sms[i][j] != null && sms[i][j].getId().equals(id)) {
                    found = true;
                    sms[i][j] = null;
                    System.out.println("Message with id: " + id + " has been deleted successfully.\n");
                    return;
                }
            }
        }
        if (!found) {
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





    {
        sms2 = new Message[10][5];
    }

    {
        messageReceived(null, "03445672", true);
        messageReceived(null, "03005672",  false);
        messageReceived(null, "03455665",  true);
        messageReceived(null, "03454562",  false);
        messageReceived(null, "03234692",  true);
    }

    public void messageReceived(String messageContent, String senderNumber, boolean status) {
        if (messageCounter < sms2.length) {
            for (int i = 0; i < sms2[messageCount].length; i++) {
                if (sms2[messageCounter][i] == null) {
                    sms2[messageCounter][i] = new Message(messageContent, senderNumber, status);
                    messageCounter++;
                    return;
                }
            }
        }
    }

    public void receiveMessage(String message) {
        for(int i = 0; i < sms2.length; i++) {
            for(int j = 0; j < sms2[i].length; j++) {
                if(sms2[i][j] != null && sms2[i][j].getMessage() == null) {
                    sms2[i][j].setMessage(message);
                }
            }
        }
    }


}
