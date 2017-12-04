package com.epam.preprod.roman_lutsenko.task8.long_sequence;

import java.io.File;

import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR;
import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR_SETTED;

public class Buffer {
    private File file;
    private Byte[] resultBytes;

    public Byte[] result;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        synchronized (MONITOR) {
            this.file = file;
            MONITOR.notifyAll();
        }
    }

    public Byte[] getResultBytes() {
        return resultBytes;
    }

    public void setResultBytes(Byte[] resultBytes) {
        synchronized (MONITOR_SETTED) {
            this.resultBytes = resultBytes;
            MONITOR_SETTED.notifyAll();
        }
    }
}
