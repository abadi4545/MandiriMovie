package com.arkam.core.data.local.source.room.movie

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val genres: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteCount: Int,
    val voteAverage: Double,
): Parcelable
