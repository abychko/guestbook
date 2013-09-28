package my.guestbook;

import java.sql.Timestamp;

/**
 * Created by nerff on 28.09.13.
 */
public class Record {
    int id;
    Timestamp ts;
    String message;

    Record(int id, Timestamp ts, String msg){
        this.id = id;
        this.ts = ts;
        this.message = msg;
    }
}
