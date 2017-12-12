package com.epam.preprod.roman_lutsenko.task9;

import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task9.commands.ServerCommand;
import com.epam.preprod.roman_lutsenko.task9.constants.container.ServerCommandsContainer;
import com.epam.preprod.roman_lutsenko.task9.util.ParseTcpRequest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleTcpServer implements Runnable {

    private ServerSocket serverSocket;
    private Context context;

    public SimpleTcpServer(Context context, ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.err.println("run() accepted");
                InputStream inputStream = new BufferedInputStream(socket.getInputStream());

                OutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
                System.err.println("Connection accepted");
                byte buf[] = new byte[64 * 1024];
                // читаем 64кб от клиента, результат - кол-во реально принятых данных
                int readBytes = inputStream.read(buf);


                String readData = new String(buf, 0, readBytes);

                String[] request = ParseTcpRequest.parseToRequestAndAttr(readData);

                ServerCommandsContainer serverCommandsContainer = new ServerCommandsContainer();

                ServerCommand serverCommand = serverCommandsContainer.getCommand(request[0]);
                String response = serverCommand.execute(context, readData);

                outputStream.write(response.getBytes());

                outputStream.flush();
            }
        } catch (IOException e) {
            System.err.println("init error: " + e);
        }
    }

}
