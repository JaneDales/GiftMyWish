package com.janedales.giftmywishclone.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.janedales.giftmywishclone.data.entity.Avatar;
import com.janedales.giftmywishclone.data.entity.Cover;
import com.janedales.giftmywishclone.data.entity.ShippingAddress;
import com.janedales.giftmywishclone.data.entity.Thumb;
import com.janedales.giftmywishclone.data.entity.User;

@Database(entities = {User.class, Avatar.class, Cover.class,
        ShippingAddress.class, Thumb.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDaoInterface userDao();
}
