package com.holubinka.dao;

import com.holubinka.model.Role;
import com.holubinka.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User,Long> implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User save(User user) {
       return super.save(user);
    }

    @Override
    public User getByToken(String token) {
        String query = "select u.id as u_id, " +
                "u.username, " +
                "u.password, " +
                "u.token, " +
                "u.first_name, " +
                "u.last_name, " +
                "r.id as r_id, " +
                "r.role_name " +
                "from users u " +
                "join users_to_roles utr on u.id = utr.fk_user_id " +
                "join roles r on utr.fk_role_id = r.id " +
                "where u.token = ? ";
        PreparedStatement statement;
        ResultSet resultSet;
        User result = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, token);
            resultSet = statement.executeQuery();
            result = getUserWithRolesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        String query = "select u.id as u_id, " +
                "u.username, " +
                "u.password, " +
                "u.token, " +
                "u.first_name, " +
                "u.last_name " +
                "from users u " +
                "where u.username = ? ";
        PreparedStatement statement;
        ResultSet resultSet;
        User result = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                result = getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(result);
    }

    private User getUserWithRolesFromResultSet(ResultSet rs) throws SQLException {
        List<Role> roles = new ArrayList<>();
        User result = null;
        if (rs.next()) {
            result = getUserFromResultSet(rs);
            result.setRoles(roles);
            while (!rs.isAfterLast()) {
                roles.add(getRoleFromResultSet(rs));
                rs.next();
            }
        }

        return result;
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {
        Long id = rs.getLong("u_id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String token = rs.getString("token");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new User(id, username, password, token, firstName, lastName);
    }

    private Role getRoleFromResultSet(ResultSet rs) throws SQLException {
        Long id = rs.getLong("r_id");
        String roleName = rs.getString("role_name");
        return new Role(id, Role.RoleName.valueOf(roleName));
    }
}
