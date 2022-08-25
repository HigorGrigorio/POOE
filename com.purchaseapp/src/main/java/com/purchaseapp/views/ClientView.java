package com.purchaseapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.purchaseapp.models.Client;
import com.purchaseapp.models.User;
import com.purchaseapp.services.ClientService;
import com.purchaseapp.services.UserService;

public class ClientView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientView frame = new ClientView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void connectBank() {
		UserService userService = new UserService();
		userService.showConnectionBank();
	}
	
	public void insertUser() {
		User user = new User();
		user.setUsername("HigorGrigorio");
		user.setEmail("example@teste.com");
		user.setPassword("123456");
		user.setConfirm("123456");
		user.setActive(true);
		
		UserService userService = new UserService();
		userService.add(user);
	}
	
	/**
	 * Create the frame.
	 */
	public ClientView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		connectBank();
		insertUser();
		saveClient();
		updateClient();
	}

	public void saveClient() {
		ClientService service = new ClientService();
		Client client = new Client();	
		
		client.setName("Higor");
		client.setAddress("Sitio Nossa Senhora Aparecida");
		client.setAge(20);
		client.setDistrict("Rural");
		client.setCep("16-265.000");
		client.setEmail("higorgrigorio@gmail.com");
		client.setTelephone("(18)99999-9999");
		
		service.add(client);
	}
	
	public void updateClient() {
		ClientService service = new ClientService();
		Client client = service.getById(1L);
		
		if(client == null) {
			System.out.println("Undefined Client!");
			return;
		}
		
		System.out.println(client.toString());
		
		client.setName("Higor Grigorio");
		service.update(client);
	 }
}
