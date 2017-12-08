package com.epam.preprod.roman_lutsenko.task9.run_package;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SimpleTcpClient extends Thread {
    public static void main(String args[]) {
        try {
            while(true) {
                Socket s = new Socket(InetAddress.getLocalHost(), 3000);
                SimpleTcpClient simpleTcpClient = new SimpleTcpClient();
                simpleTcpClient.showAvailableRequest();
                Scanner scanner = new Scanner(System.in);
                String request = scanner.nextLine();

                s.getOutputStream().write(request.getBytes());

                byte buf[] = new byte[64 * 1024];
                int r = s.getInputStream().read(buf);
                String data = new String(buf, 0, r);

                System.out.println(data);
            }
        } catch (Exception e) {
            System.out.println("init error: " + e);
        }
    }

    private void showAvailableRequest() {
        System.out.println("- get_count");
        System.out.println("- get_item=ID");
    }

}
