package com.epam.preprod.roman_lutsenko.task8.long_sequence;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR;
import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR_SETTED;

public class Buffer {
    private File file;
    private Byte[] resultBytes;
    public  Byte[] result;


    private int firstIndexInjection;
    private int secondIndexInjection;

    public Byte[] getResult() {
        return result;
    }

    public void setResult(Byte[] result, int firstIndexInjection, int secondIndexInjection) {
        synchronized (MONITOR_SETTED) {
            this.result = result;
            this.firstIndexInjection = firstIndexInjection;
            this.secondIndexInjection = secondIndexInjection;
            MONITOR_SETTED.notifyAll();
        }
    }

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

    public int getFirstIndexInjection() {
        return firstIndexInjection;
    }


    public int getSecondIndexInjection() {
        return secondIndexInjection;
    }

    public void clear() {
        file = null;
        resultBytes = null;
        result = null;
    }
}
