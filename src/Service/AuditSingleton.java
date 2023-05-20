package Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditSingleton {
    private static AuditSingleton instance = null;
    private AuditSingleton() {
    }
    public static AuditSingleton getInstance() {
        if (instance == null) {
            instance = new AuditSingleton();
        }
        return instance;
    }
    private List<Pair<String, Date>> audit = new ArrayList<>();

    public void add(String action) {
        audit.add(new Pair<>(action, new Date()));
    }
    public List<Pair<String, Date>> getAudit() {
        return audit;
    }
    public void setAudit(List<Pair<String, Date>> audit) {
        this.audit = audit;
    }

    public void dumpToCSV() {
        try {
            var writer = new FileWriter("data/audit.csv");
            for (Pair<String, Date> pair : audit) {
                writer.write(pair.toCSV());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
