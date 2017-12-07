package com.epam.preprod.roman_lutsenko.task9;

import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleTcpServer extends Thread {

    private ServerSocket serverSocket;
    private Context context;

    public SimpleTcpServer(Context context, ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.context = context;
       // setDaemon(true); блять. просто надо было не расчитывать сразу на полноценную работу я же думал что потоки будут жить пока магазин работает, а вешать магазин забыл
    }

    @Override
    public void run() {
        System.err.println("run() start"); //всё, по ф8 офнулась
        try {
            while (true) {
                Socket socket = serverSocket.accept(); // вот тут идет закрытие потока без единой ошибки и вообще ничего
                System.err.println("run() accepted");
                InputStream inputStream = new BufferedInputStream(socket.getInputStream());

                OutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
                System.err.println("Connection accepted");
                byte buf[] = new byte[64 * 1024];
                // читаем 64кб от клиента, результат - кол-во реально принятых данных
                int readBytes = inputStream.read(buf);

                // создаём строку, содержащую полученную от клиента информацию

                String readData = new String(buf, 0, readBytes);
                if (readData.equalsIgnoreCase("get count")) {
                    outputStream.write(("" + context.getLocalProductService().getAllItems().size()).getBytes());
                }
                outputStream.flush();
            }
            //socket.close();
        } catch (IOException e) {
            System.err.println("init error: " + e);
        }
    }

}
