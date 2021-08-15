package com.janedales.giftmywishclone.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.janedales.giftmywishclone.data.database.converter.CommentKConverter;
import com.janedales.giftmywishclone.data.database.converter.DataConverter;
import com.janedales.giftmywishclone.data.database.converter.DonationConverter;
import com.janedales.giftmywishclone.data.database.converter.GiftConverter;
import com.janedales.giftmywishclone.data.database.converter.IntConverter;
import com.janedales.giftmywishclone.data.entity.Avatar;
import com.janedales.giftmywishclone.data.entity.Children;
import com.janedales.giftmywishclone.data.entity.Comment;
import com.janedales.giftmywishclone.data.entity.Cover;
import com.janedales.giftmywishclone.data.entity.Donation;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.entity.Gift;
import com.janedales.giftmywishclone.data.entity.ShippingAddress;
import com.janedales.giftmywishclone.data.entity.Thumb;
import com.janedales.giftmywishclone.data.entity.User;

@Database(entities = {Avatar.class, Children.class, Thumb.class, Comment.class, Cover.class,
        ShippingAddress.class, User.class, Donation.class, Gift.class, Event.class},
        version = 1)
@TypeConverters({/*Converters.class,*/ IntConverter.class, DataConverter.class, GiftConverter.class, DonationConverter.class, CommentKConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract EventDaoInterface eventDao();

}
