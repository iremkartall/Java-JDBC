import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;

        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            String sql = "update actor set first_name='Sebahat' where actor_id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,201);
            statement.executeUpdate();
            System.out.println("Kayıt güncellendi");
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            connection.close();
            statement.close();
        }
    }

    public static void selectDemo() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select first_name,last_name,actor_id from actor");
            ArrayList<Actor> actors = new ArrayList<Actor>();
            while (resultSet.next()) {
                actors.add(new Actor(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("actor_id")));
            }
            System.out.println(actors.size());
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            connection.close();
            statement.close();
        }

    }

    public static void insertData() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement("insert into actor(first_name,last_name) values ('Hatice','Kartal')");
            statement.executeUpdate();
            System.out.println("Kayıt eklendi");
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            connection.close();
        }

    }

    public static void updateData() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            String sql = "update actor set first_name='Sebahat' where actor_id=201";
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Kayıt güncellendi");
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            connection.close();
            statement.close();
        }
    }
    public static void delete() throws SQLException {
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        ResultSet resultSet;

        try{
            connection=dbHelper.getConnection();
            String sql="delete from actor where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,201);
            statement.executeUpdate();
            System.out.println("Kayıt silindi");
        }catch (SQLException exception){
             dbHelper.showErrorMessage(exception);
        }finally {
            connection.close();
            statement.close();
        }

    }
}

