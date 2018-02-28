package Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoImpl implements Repo {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Info> getInfo() {
        return jdbcOperations.query("select id, name, email from info", new InfoRowMapper());
    }

    private static final class InfoRowMapper implements RowMapper<Info> {
        public Info mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            return new Info(id, name, email);
        }
    }
}
