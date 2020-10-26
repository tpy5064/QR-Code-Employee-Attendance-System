/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Sarxos
 * This library is created by Sarxos, and the following code is referenced from
 * his example code page found at:
 * https://github.com/sarxos/webcam-capture/tree/master/webcam-capture-examples/webcam-capture-qrcode
 */

package employeelogin;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.util.concurrent.Exchanger;

import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


public class QRScannerMain extends JFrame implements Closeable {

	private static final long serialVersionUID = 1L;

	private Webcam webcam = null;
	private BufferedImage image = null;
	private Result result = null;
	private Exchanger<String> exchanger = new Exchanger<String>();

	public QRScannerMain() {

		super();

		setLayout(new FlowLayout());
		setTitle("Scanner");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});

		webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.QVGA.getSize());
		webcam.open();

		add(new WebcamPanel(webcam));

		pack();
		setVisible(true);

		final Thread daemon = new Thread(new Runnable() {

			@Override
			public void run() {
				while (isVisible()) {
					read();
				}
			}
		});
		daemon.setDaemon(true);
		daemon.start();
	}

	private static BinaryBitmap toBinaryBitmap(BufferedImage image) {
		return new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
	}

	private void read() {

		if (!webcam.isOpen()) {
			return;
		}
		if ((image = webcam.getImage()) == null) {
			return;
		}

		try {
			result = new MultiFormatReader().decode(toBinaryBitmap(image));
		} catch (NotFoundException e) {
			return; //Return to loop, which means there is no visible QR Code
		}

		if (result != null) {
			try {
				exchanger.exchange(result.getText());
			} catch (InterruptedException e) {
				return;
			} finally {
				dispose();
                                webcam.close();
			}
		}
	}

	public String getResult() throws InterruptedException {
		return exchanger.exchange(null);
	}

	@Override
	public void close() {
		webcam.close();
	}
}