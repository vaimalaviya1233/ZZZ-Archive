package di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.RoomDatabaseFactory
import feature.agent.data.database.AgentsListDB
import feature.bangboo.data.database.BangbooListDB
import feature.cover.data.database.CoverImagesListDB
import feature.drive.data.database.DrivesListDB
import feature.hoyolab.data.database.HoYoLabAccountDB
import feature.wengine.data.database.WEnginesListDB
import org.koin.dsl.module

val databaseModule = module {
    single {
        get<RoomDatabaseFactory>()
            .createAgentListDatabase()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single {
        get<RoomDatabaseFactory>()
            .createWEnginesListDatabase()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single {
        get<RoomDatabaseFactory>()
            .createBangbooListDatabase()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single {
        get<RoomDatabaseFactory>()
            .createDrivesListDatabase()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single {
        get<RoomDatabaseFactory>()
            .createCoverImagesListDatabase()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single {
        get<RoomDatabaseFactory>()
            .createHoYoLabAccountDatabase()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<AgentsListDB>().agentsListDao }
    single { get<WEnginesListDB>().wEnginesListDao }
    single { get<BangbooListDB>().bangbooListDao }
    single { get<DrivesListDB>().drivesListDao }
    single { get<CoverImagesListDB>().coverImagesListDao }
    single { get<HoYoLabAccountDB>().hoYoLabAccountDao }
}
