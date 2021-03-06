package com.epam.preprod.roman_lutsenko.task9;

import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task9.commands.ServerCommand;
import com.epam.preprod.roman_lutsenko.task9.constants.container.ServerCommandsContainer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import static com.epam.preprod.roman_lutsenko.task9.util.ParseHttpRequest.getPath;


/**
 * Thread class for implementation HTTP server on port that sets in ServerSocket variable our local machine
 */
public class SimpleHttpServer implements Runnable {
    private static final String NOT_FOUND_RESPONSE_404 = "%s Content-Type: text/plain\nConnection: close\nServer: SimpleHTTPServer\nPragma: no-cache\n\n";
    private static final String BAD_REQUEST_RESPONSE_400 = "%sConnection: close\nServer: SimpleHttpServer\nPragma: no-cache\n\n";

    private ServerSocket serverSocket;
    private Context context;


    /**
     * Initiating common context in server and shop.
     *
     * @param context      context of our shop
     * @param serverSocket opened socked for server.
     */
    public SimpleHttpServer(Context context, ServerSocket serverSocket) {
        this.context = context;
        this.serverSocket = serverSocket;
    }

    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.err.println("HTTPServer run()");

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                byte buf[] = new byte[64 * 1024];
                int readBytes = inputStream.read(buf);

                String readData = new String(buf, 0, readBytes);

                String path = getPath(readData);

                if (path == null) {
                    // 400
                    outputStream.write(badRequestResponse().getBytes());
                    socket.close();
                    continue;
                }
                ServerCommand serverCommand = new ServerCommandsContainer().getCommand(path);
                String response = serverCommand.execute(context, readData);

                if (Objects.nonNull(response)) {
                    outputStream.write(response.getBytes());
                    socket.close();
                    continue;
                }

                // 404
                outputStream.write(notFountResponse(path).getBytes());
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String badRequestResponse() {
        String response = "HTTP/1.1 400 Bad Request\n";

        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        response = response + "Date: " + df.format(new Date()) + "\n";

        return String.format(BAD_REQUEST_RESPONSE_400, response);

    }

    private String notFountResponse(String path) {
        String response = "HTTP/1.1 404 Not Found\n";

        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        response = response + "Date: " + df.format(new Date()) + "\n";

        response = String.format(NOT_FOUND_RESPONSE_404, response);

        return response + "File " + path + " not found!";
    }
}
