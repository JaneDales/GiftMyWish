package com.janedales.giftmywishclone.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;

@Dao
public interface EventDaoInterface {

    @Query("SELECT * FROM event WHERE isMyEvent = :isMyEvent")
    List<Event> getAll(boolean isMyEvent);

    @Query("SELECT * FROM event WHERE id = :id")
    Event getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Event employee);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Event> events);

    @Update
    void update(Event event);

    @Delete
    void delete(Event event);

    @Query("DELETE FROM event")
    void deleteAll();
}
