package com.epam.preprod.roman_lutsenko.task9;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.services.impl.LocalProductService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import static com.epam.preprod.roman_lutsenko.task9.constants.ServerCommandConstants.SEPARATOR_FOR_THING_PRICE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private static Context contextMock = mock(Context.class);

    @BeforeClass
    public static void setContext() {
        LocalProductService localProductService = mock(LocalProductService.class);
        Laptop laptop = new Laptop();
        laptop.setNameModel("laptop1");
        laptop.setPrice(1);

        when(contextMock.getLocalProductService()).thenReturn(localProductService);
        when(localProductService.getAllItems()).thenReturn(fill());
        when(localProductService.get(1)).thenReturn(laptop);

        ServerSocket serverTCP;
        Runnable threadTCP = null;
        try {
            serverTCP = new ServerSocket(3000);
            threadTCP = new SimpleTcpServer(contextMock, serverTCP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread tcp = new Thread(threadTCP);
        tcp.start();
    }

    @Test
    public void tcpServerReturnCount5() {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 3000);
            String request = "get_count";
            s.getOutputStream().write(request.getBytes());

            byte buf[] = new byte[64 * 1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            assertEquals("Number of elements in shop = 5", data);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tcpServerGetItem1() {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 3000);
            String request = "get_item=1";
            s.getOutputStream().write(request.getBytes());

            byte buf[] = new byte[64 * 1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            assertEquals("laptop1" + SEPARATOR_FOR_THING_PRICE + "1", data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<Integer, Thing> fill() {
        Laptop laptop;
        Map<Integer, Thing> productList = new HashMap<>();
        for (int index = 1; index < 6; index++) {
            laptop = new Laptop();
            laptop.setId(index);
            laptop.setPrice(index);
            laptop.setNameModel("laptop" + index);
            productList.put(laptop.getId(), laptop);
        }
        return productList;
    }
}
