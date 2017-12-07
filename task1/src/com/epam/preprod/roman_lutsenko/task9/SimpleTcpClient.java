package com.epam.preprod.roman_lutsenko.task9;

import java.net.InetAddress;
import java.net.Socket;

public class SimpleTcpClient extends Thread {
    public static void main(String args[]) {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 3000);

          //  int integer = s.getInputStream().read();
            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
            String qwe = "get count";
            s.getOutputStream().write(qwe.getBytes());

            // читаем ответ
            byte buf[] = new byte[64 * 1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            System.out.println(data);
        } catch (Exception e) {
            System.out.println("init error: " + e);
        }
    }
}
