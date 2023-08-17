package org.harundemir.gamestore.data

import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.Category
import org.harundemir.gamestore.models.Game

val gameList: List<Game> = listOf(
    Game(
        id = 1,
        cover = R.drawable.mw2_cover,
        avatar = R.drawable.mw2_avatar,
        title = "Call of Duty MWII",
        category = Category(
            title = "Action",
            icon = R.drawable.baseline_home_24
        ),
        rate = 4.5,
        size = 20.0,
        images = listOf(
            R.drawable.mw2_cover,
            R.drawable.mw2_1,
            R.drawable.mw2_2,
            R.drawable.mw2_3,
            R.drawable.mw2_4,
        )
    ),
    Game(
        id = 2,
        cover = R.drawable.cs_cover,
        avatar = R.drawable.cs_avatar,
        title = "CS:GO",
        category = Category(
            title = "FPS",
            icon = R.drawable.baseline_apps_24
        ),
        rate = 4.5,
        size = 20.0,
        images = listOf(
            R.drawable.cs_cover,
            R.drawable.cs_1,
            R.drawable.cs_2,
            R.drawable.cs_3,
            R.drawable.cs_4,
        )
    ),
    Game(
        id = 3,
        cover = R.drawable.pubg_cover,
        avatar = R.drawable.pubg_avatar,
        title = "PUBG",
        category = Category(
            title = "Battle Royale",
            icon = R.drawable.baseline_apps_24
        ),
        rate = 4.5,
        size = 20.0,
        images = listOf(
            R.drawable.pubg_cover,
            R.drawable.pubg_1,
            R.drawable.pubg_2,
            R.drawable.pubg_3,
            R.drawable.pubg_4,
        )
    ),
    Game(
        id = 4,
        cover = R.drawable.nfs_cover,
        avatar = R.drawable.nfs_avatar,
        title = "NFS Most Wanted",
        category = Category(
            title = "Racing",
            icon = R.drawable.baseline_home_24
        ),
        rate = 4.5,
        size = 20.0,
        images = listOf(
            R.drawable.nfs_cover,
            R.drawable.nfs_1,
            R.drawable.nfs_2,
            R.drawable.nfs_3,
            R.drawable.nfs_4,
        )
    ),
    Game(
        id = 5,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Uncharted 4",
        category = Category(
            title = "Adventure",
            icon = R.drawable.baseline_search_24
        ),
        rate = 4.5,
        size = 20.0,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    ),
)