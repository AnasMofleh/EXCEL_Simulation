package model;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.Set;
import model.Slots.Slot;

//TODO move to another package
public class XLPrintStream extends PrintStream {
    public XLPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void save(Set<Entry<String, Slot>> set) {
        for (Entry<String, Slot> entry : set) {
            print(entry.getKey());
            print('=');
            println(entry.getValue());
        }
        flush();
        close();
    }
}
