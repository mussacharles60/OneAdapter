package com.android.one_adapter_example.persistence

import androidx.room.Dao
import androidx.room.Query
import com.android.one_adapter_example.models.MessageModel
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class MessageDao : BaseDao<MessageModel>() {

    @Query("SELECT * FROM messages")
    abstract fun observeTable(): Flowable<List<MessageModel>>

    @Query("SELECT * FROM messages WHERE headerId == :headerId")
    abstract fun getMessageWithHeaderId(headerId: Int): Single<List<MessageModel>>

    @Query("DELETE FROM messages")
    abstract fun deleteAll()

    @Query("DELETE FROM messages WHERE id % 2 == 0")
    abstract fun deleteEvenIds()
}