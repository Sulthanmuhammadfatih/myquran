package co.id.sulthan.core.data.source.local.room

import androidx.room.RoomDatabase
import co.id.sulthan.core.data.source.local.entity.AyatEntity
import co.id.sulthan.core.data.source.local.entity.SurahEntity
import kotlin.reflect.KClass

@QuranDatabase.Database(
    entities = [
        SurahEntity::class,
        AyatEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class QuranDatabase : RoomDatabase() {
    annotation class Database(
        val entities: Array<KClass<out Any>>,
        val version: Int,
        val exportSchema: Boolean
    )

    abstract fun quranDao(): QuranDao

}