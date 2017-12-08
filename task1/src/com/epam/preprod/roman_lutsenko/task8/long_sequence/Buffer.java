package com.epam.preprod.roman_lutsenko.task8.long_sequence;

import java.io.File;

import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR;
import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR_END;
import static com.epam.preprod.roman_lutsenko.task8.long_sequence.Producer.MONITOR_SETTED;

/**
 * Instance for containing and cooperate two threads Producer and Consumer.
 */
public class Buffer {
    private File file;
    private Byte[] result = new Byte[]{};

    private int firstIndexInjection;
    private int secondIndexInjection;

    private boolean end;

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Byte[] getResult() {
        return result;
    }

    /**
     * Set result of finding sequence with synchronizing.
     * @param result our longest sequence.
     * @param firstIndexInjection index of first finding.
     * @param secondIndexInjection index of secnd finding.
     */
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

    /**
     * Set file to buffer and produce work of LongSequence searching sequence.
     * @param file file in wich to search.
     */
    public void setFile(File file) {
        synchronized (MONITOR) {
            this.file = file;
            MONITOR.notifyAll();
        }
    }

    public int getFirstIndexInjection() {
        return firstIndexInjection;
    }


    public int getSecondIndexInjection() {
        return secondIndexInjection;
    }

    /**
     * Clearing our buffer for next file to search and using searcher.
     * Waiting until outputin result of search not ends.
     */
    public void clear() {
        synchronized (MONITOR_END) {
            try {
                MONITOR_END.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            file = null;
            result = new Byte[]{};
            end = false;
        }
    }
}
