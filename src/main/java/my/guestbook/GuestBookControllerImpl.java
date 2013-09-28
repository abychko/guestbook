package my.guestbook;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nerff on 28.09.13.
 */
public class GuestBookControllerImpl implements GuestBookController {
    @Resource(name = "jdbc/guestbookDS")
    private DataSource ds;
    private Connection connection;

    public GuestBookControllerImpl(DataSource dataSource) {
        this.ds = dataSource;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addRecord(String message) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO records (MESSAGE) " + "VALUES (?)");
            ps.setString(1, message);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Record> getRecords() throws SQLException {
        List<Record> records = new ArrayList<Record>();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM records order by ID desc");
        while (resultSet.next()) {
            try {
                Record tmp = new Record(resultSet.getInt("ID"), resultSet.getTimestamp("POSTDATE"), resultSet.getString("MESSAGE"));
                records.add(tmp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resultSet.close();

        return records;
    }
}
