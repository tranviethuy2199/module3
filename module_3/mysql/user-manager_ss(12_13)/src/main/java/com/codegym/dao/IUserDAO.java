package com.codegym.dao;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    List<User> findByCountry(String country) throws SQLException;

    public List<User> sort(String sortByName) throws SQLException;

    User getUserById(int id);

    void editUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

    void deleteUserPro (int id);

    public List<User> selectAllUsersPro();






}
