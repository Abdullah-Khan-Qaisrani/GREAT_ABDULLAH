package MessageApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {



    public static void main(String[] args) throws Exception {

        MessageApp app = new MessageApp();

        System.out.println("Client Started...");
        Socket s = new Socket("localhost", 4326);

        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        BufferedReader b1 = new BufferedReader(new InputStreamReader(s.getInputStream()));






        int choice;

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("--Message Application Menu--\n");
            System.out.println("1. Send a Message.");
            System.out.println("2. Recieve Message");
            System.out.println("3. Display specific Message.");
            System.out.println("4. Search Message by Id.");
            System.out.println("5. Check the Status of Message.");
            System.out.println("6. Delete message.");
            System.out.println("7. Sort the messages.");
            System.out.println("8. Display all Messages");
            System.out.println("0. exit the program.\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    String str1 = app.sendMessage();
                    if(str1!=null) {
                        pr.println(str1);
                    }
                    break;

                case 2:
                    String str = b1.readLine();
                    if(str != null){
                        app.receiveMessage(str);
                        System.out.println(str);
                        System.out.println("\nMessage Recieved.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the recieverNumber to display specific message: ");
                    String recieverNumber1 = sc.nextLine();
                    app.displaySpecificMessage(recieverNumber1);
                    break;
                case 4:
                    System.out.print("Enter the id to search message: ");
                    String searchId = sc.nextLine();
                    app.searchMessage(searchId);
                    break;
                case 5:
                    System.out.print("Enter the id to check status of message: ");
                    String statusId = sc.nextLine();
                    app.messageStatus(statusId);
                    break;
                case 6:
                    System.out.print("Enter the id to delete a message: ");
                    String deleteId = sc.nextLine();
                    app.deleteMessage(deleteId);
                    break;

                case 7:
                    app.sortMessages();
                    break;

                case 8:
                    app.displayAllMessages();
                    break;
                case 0:
                    break;

            }

        }




    }
}