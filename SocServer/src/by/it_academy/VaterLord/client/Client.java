package by.it_academy.VaterLord.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import by.it_academy.VasterLord.users.User;


public class Client {
	private static BufferedReader read;
	static {
		read = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("Хотите получить список пользователей ? 1 - да, 2 - нет");
			int check = input();
			if(check == 1) {connection();}
			else break;
		}
	}

	private static void connection() {
		try {
			Socket clientSocket = new Socket("localhost", 5555);
			ArrayList<User> arrayList = new ArrayList<>();
			ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
	        try {
	            Object object = objectInputStream.readObject();
	            arrayList =  (ArrayList<User>) object;
	            print(arrayList);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int input() {
		int num = 0;
		try {
			num = Integer.parseInt(read.readLine());
		}catch(IOException e) {e.printStackTrace();}
		return num;
	}
	
	private static void print(ArrayList<User> arrayList) {
		for(User l : arrayList) {
        	System.out.println();
        	System.out.println("Имя " + l.getName());
        	System.out.println("Фамилия " + l.getSurname());
        	System.out.println("Возраст " + l.getAge());
        }
		System.out.println();
	}
}
