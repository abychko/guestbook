package my.guestbook;

import java.sql.Timestamp;

/**
 * Created by nerff on 28.09.13.
 */
public class Record {
    int id;
    Timestamp date;
    String message;

    Record(int id, Timestamp ts, String msg){
        this.id = id;
        this.date = ts;
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public int getId() {
        return this.id;
    }
}
