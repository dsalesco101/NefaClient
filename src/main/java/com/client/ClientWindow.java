package com.client;

import java.io.IOException;
import java.net.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ClientWindow extends Client implements ActionListener, WindowListener {

	private static final long serialVersionUID = -6978617783576386732L;

	public void initUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			frame = new JFrame(Configuration.clientTitle);
			frame.setLayout(new BorderLayout());
			setFocusTraversalKeysEnabled(false);
			frame.setResizable(false);
			try {
				frame.setIconImage(ImageIO.read(new URL ("https://i.imgur.com/1FS8t8X.png")));
			} catch (IOException e) {
				System.err.println("Cannot get icon image from url.");
			}
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel gamePanel = new JPanel();
			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(this);
			gamePanel.setPreferredSize(new Dimension(765, 503));
			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			frame.pack();
			insets = frame.getInsets();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ClientWindow(String args[]) {
		super();
		try {
			com.client.sign.Signlink.startpriv(InetAddress.getByName(server));
			initUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public URL getCodeBase() {
		try {
			return new URL("http://" + server + "/overlays");
		} catch (Exception e) {
			return super.getCodeBase();
		}
	}

	@Override
	public URL getDocumentBase() {
		return getCodeBase();
	}

	public void loadError(String s) {
		System.out.println("loadError: " + s);
	}

	@Override
	public String getParameter(String key) {
		return "";
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
	
	public static JFrame frame;
	
	public static JFrame getFrame() {
		return frame;
	}
	
	private static Insets insets;
	
	public static Insets getInset() {
		return insets;
	}

}