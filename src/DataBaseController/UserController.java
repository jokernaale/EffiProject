package DataBaseController;

import Configs.Const;
import DataBase.DBConnection;
import model.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserController {

    public void signUpUser(Profile profile) {
        String insert = "INSERT INTO " + Const.USERS_TABLE + "("
                + Const.USERS_ID + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_FIRSTNAME +
                "," + Const.USERS_LASTNAME + "," + Const.USERS_GENDER + ")" +
                "VALUES(?,?,?,?,?,?)";


        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, profile.getId());
            preparedStatement.setString(2, profile.getUserName());
            preparedStatement.setString(3, profile.getPassword());
            preparedStatement.setString(4, profile.getFirstName());
            preparedStatement.setString(5, profile.getLastName());
            preparedStatement.setString(6, profile.getGender());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public ResultSet getProfile(Profile profile) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " +
                Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1, profile.getUserName());
            preparedStatement.setString(2, profile.getPassword());
            resSet = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resSet;
    }
}
