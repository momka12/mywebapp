package org.itstep.myWebApp.repository.db;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by student on 21.03.2017.
 */
@Repository
public class DbUserRepository implements UserRepository {

    private BeanPropertyRowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public DbUserRepository(DataSource dataSource) {
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM USERS", rowMapper);
    }

    @Override
    public boolean delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id) > 0;
    }

    @Override
    public User save(User user) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", user.getName());
        mapSqlParameterSource.addValue("city", user.getCity());
        mapSqlParameterSource.addValue("email", user.getEmail());
        mapSqlParameterSource.addValue("lastname", user.getLastname());
        if (user.getId() == null) {
//            jdbcInsert.execute(mapSqlParameterSource);
            int id = jdbcInsert.executeAndReturnKey(mapSqlParameterSource).intValue();
            user.setId(id);
        } else {
            mapSqlParameterSource.addValue("id", user.getId());
            namedParameterJdbcTemplate.update("UPDATE users SET name=:name, lastname=:lastname, " +
                    "city=:city, email=:email WHERE id=:id", mapSqlParameterSource);
        }
        return user;
    }

    @Override
    public User getById(Integer id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", rowMapper, id);
        } catch (Exception ex) {
            return null;
        }
    }
}
