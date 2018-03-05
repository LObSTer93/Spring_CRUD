package Data;

import Exceptions.InfoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepoImpl implements Repo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Info getById(long infoId) {
        try {
            return jdbcTemplate.queryForObject("select id, name, email from info where id=?", new InfoRowMapper(), infoId);
        }catch (EmptyResultDataAccessException e){
            throw new InfoNotFoundException(infoId);
        }
    }

    @Override
    public List<Info> getAll() {
        return jdbcTemplate.query("select id, name, email from info", new InfoRowMapper());
    }

    @Override
    public void save(Info info) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("info");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<>();
        args.put("name", info.getName());
        args.put("email", info.getEMail());
        jdbcInsert.execute(args);
    }

    @Override
    public void delete(long infoId) {
        jdbcTemplate.update("delete from info where id=?", infoId);
    }

    @Override
    public void edit(Info info) {
        jdbcTemplate.update("update info set name=?, email=? where id=?", info.getName(), info.getEMail(), info.getId());
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
