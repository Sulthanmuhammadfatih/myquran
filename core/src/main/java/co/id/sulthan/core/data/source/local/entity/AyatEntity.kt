package co.id.sulthan.core.data.source.local.entity

import androidx.annotation.NonNull

@SurahEntity.Entity(tableName = "ayat")

data class AyatEntity(
    @SurahEntity.ColumnInfo(name = "ar")
    val ar: String,

    @SurahEntity.ColumnInfo(name = "id")
    val id: String,

    @SurahEntity.PrimaryKey
    @NonNull
    @SurahEntity.ColumnInfo(name = "nomor")
    val nomor: String,

    @SurahEntity.ColumnInfo(name = "tr")
    val tr: String
)