package by.it_academy.VaterLord.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import by.it_academy.VasterLord.users.User;

public class Server {

	public static void main(String[] args) {
		ArrayList<User> list = listOfUsers();
		connection(list);
	}
	
	private static void connection(List<User> list) {
		int client = 0;

		try {

			System.out.println("Server created.");
			ServerSocket serverSocket = new ServerSocket(5555);
			System.out.println("Server started:");

			while (true) {
				Socket clientSocket = serverSocket.accept();

				client++;
				System.out.println("Client " + client +  " connected:");
				try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());){
					objectOutputStream.writeObject(list);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<User> listOfUsers() {
		ArrayList<User> list = new ArrayList<>();
		User user1 = new User("Лариса", "Гоц", 20);
		list.add(user1);
		User user2 = new User("Василий", "Лебедев", 22);
		list.add(user2);
		User user3 = new User("Алиса", "Петрова", 50);
		list.add(user3);
		User user4 = new User("Егор", "Иванов", 24);
		list.add(user4);
		User user5 = new User("Павел", "Горошко", 18);
		list.add(user5);
		
		return list;
	}
}
