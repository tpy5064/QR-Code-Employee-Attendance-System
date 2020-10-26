/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeelogin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This code is written by Sarxos in his QR Code scanner example. This is found at:
 * https://github.com/sarxos/webcam-capture/tree/master/webcam-capture-examples/webcam-capture-qrcode
 * @author Sarxos
 */
@SuppressWarnings("serial")
public class QRScanner extends JFrame {

	public QRScanner() {

		setTitle("Main frame");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JButton(new AbstractAction("CAPTURE QR") {

			@Override
			public void actionPerformed(ActionEvent e) {
				final Thread thread = new Thread(new Runnable() {

							@Override
					public void run() {
						try (QRScannerMain qr = new QRScannerMain()) {
							showMessage("QR code text is:\n" + qr.getResult() + "");
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					};
				});
				thread.setDaemon(true);
				thread.start();
			}
		}));

		pack();
		setVisible(true);
	}
        
       

	public void showMessage(String text) {
		JOptionPane.showMessageDialog(null, text);
	}

}