package com.client.utilities;

import java.io.File;

import com.client.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeeOutputStreamTest {

    @Test
    public void test() {
        File exceptionLog = new File(Client.getExceptionLogLocation());
        if (exceptionLog.exists()) {
            assertTrue(exceptionLog.delete());
        }

        Client.enableExceptionLogging();
        try {
            throw new NullPointerException("test null");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        assertTrue(exceptionLog.exists());
    }

}