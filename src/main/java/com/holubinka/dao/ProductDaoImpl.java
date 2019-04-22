package com.holubinka.dao;

import com.holubinka.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    Connection connection;

    public ProductDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Product getProductById(Long id) {
        String query = "SELECT P.ID AS P_ID, " +
                "P.PRODUCTS_NAME AS P_NAME, " +
                "P.PRODUCTS_DESCRIPTION AS P_DESC, " +
                "P.PRICE AS P_PRICE FROM PRODUCTS P " +
                "WHERE P.ID = ?";

        PreparedStatement statement;
        ResultSet resultSet;
        Product result = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                while (!resultSet.isAfterLast()) {
                    result = getProductFromResultSet(resultSet);
                    resultSet.next();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    private Product getProductFromResultSet(ResultSet rs) throws SQLException {
        Long id = rs.getLong("P_ID");
        String productName = rs.getString("P_NAME");
        String productDesc = rs.getString("P_DESC");
        double price = rs.getDouble("P_PRICE");
        return new Product(id, productName, productDesc, price);
    }
}
