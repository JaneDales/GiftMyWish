package com.janedales.giftmywishclone.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.janedales.giftmywishclone.data.entity.User;

import java.util.List;

@Dao
public interface UserDaoInterface {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE user_id = :id")
    User getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User employee);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user")
    void deleteAll();
}
