package com.dugsolutions.coroutinesmvc.titleDisplay.repo.dao

import android.content.Context
import androidx.room.*
import com.dugsolutions.coroutinesmvc.titleDisplay.data.Title

class TitlesDatabaseImpl(
    private val context: Context
) : TitlesDatabase {

    // region TitlesDatabase

    override suspend fun insertTitle(title: Title) = database.titleDao.insertTitle(convert(title))

    override val title: Title?
        get() = convert(database.titleDao.titleData)

    // endregion TitlesDatabase

    private fun convert(title: Title): TitleData = TitleData(
        title = title.title,
        id = title.id
    )

    private fun convert(titleData: TitleData?): Title? = titleData?.let {
        Title(
            title = titleData.title,
            id = titleData.id
        )
    }

    /**
     * Title represents the title fetched from the network
     */
    @Entity
    private data class TitleData constructor(val title: String, @PrimaryKey val id: Int = 0)

    @Dao
    private interface TitleDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertTitle(titleData: TitleData)

        @get:Query("select * from TitleData where id = 0")
        val titleData: TitleData?
    }

    /**
     * TitleDatabase provides a reference to the dao to repositories
     */
    @Database(entities = [Title::class], version = 1, exportSchema = false)
    private abstract class TitleDatabase : RoomDatabase() {
        abstract val titleDao: TitleDao
    }

    private lateinit var instance: TitleDatabase

    private val database: TitleDatabase
        get() {
            synchronized(TitleDatabase::class) {
                if (!::instance.isInitialized) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            TitleDatabase::class.java,
                            "titles_db"
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }

}