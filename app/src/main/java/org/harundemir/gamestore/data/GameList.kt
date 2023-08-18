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
        description = "Call of Duty: Modern Warfare II is a 2022 first-person shooter video game " +
                "developed by Infinity Ward and published by Activision. It is a sequel to the " +
                "2019 reboot, and serves as the nineteenth installment in the overall " +
                "Call of Duty series. It was released on October 28, 2022, for PlayStation 4, " +
                "PlayStation 5, Windows, Xbox One, and Xbox Series X/S.",
        price = 1000.0,
        rate = 4.5,
        size = 80.5,
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
        description = "Counter-Strike: Global Offensive (CS:GO) is a 2012 multiplayer " +
                "tactical first-person shooter developed by Valve and Hidden Path Entertainment. " +
                "It is the fourth game in the Counter-Strike series. Developed for over " +
                "two years, Global Offensive was released for OS X, PlayStation 3, Windows, " +
                "and Xbox 360 in August 2012, and for Linux in 2014. Valve continues to " +
                "regularly update the game, both with smaller balancing patches and larger " +
                "content additions.",
        price = 280.0,
        rate = 4.6,
        size = 31.2,
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
        description = "PUBG: Battlegrounds (previously known as PlayerUnknown's Battlegrounds) " +
                "is a battle royale game developed by PUBG Studios and published by Krafton. " +
                "The game, which was inspired by the Japanese film Battle Royale (2000), " +
                "is based on previous mods created by Brendan \"PlayerUnknown\" Greene for other " +
                "games, and expanded into a standalone game under Greene's creative direction. " +
                "It is the first game in the PUBG Universe series.",
        price = 300.0,
        rate = 4.4,
        size = 40.6,
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
        description = "Need for Speed: Most Wanted is a 2005 open-world racing video game, " +
                "and the ninth installment in the Need for Speed series. Developed by EA " +
                "Canada and EA Black Box and published by Electronic Arts, it was released " +
                "in November 2005 for PlayStation 2, Xbox, GameCube, Nintendo DS, Microsoft " +
                "Windows, Game Boy Advance and Xbox 360. An additional version, " +
                "Need for Speed: Most Wanted 5-1-0, was released in the same year for " +
                "PlayStation Portable. The game focuses on street racing-oriented gameplay " +
                "involving a selection of events and racing circuits found within the " +
                "fictional city of Rockport, with the game's main story involving players " +
                "taking on the role of a street racer who must compete against 15 of the " +
                "city's most elite street racers to become the most wanted racer of the " +
                "group, in the process seeking revenge against one of the groups who took " +
                "their car and developing a feud with the city's police department.",
        price = 200.0,
        rate = 4.8,
        size = 3.0,
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
        description = "Uncharted 4: A Thief's End is a 2016 action-adventure game developed by " +
                "Naughty Dog and published by Sony Computer Entertainment. It is the fourth " +
                "main entry in the Uncharted series. Set several years after the events of " +
                "Uncharted 3: Drake's Deception, players control Nathan Drake, a former " +
                "treasure hunter coaxed out of retirement by his presumed-dead brother Samuel." +
                " With Nathan's longtime partner, Victor Sullivan, they search for clues " +
                "to the location of Henry Avery's long-lost treasure. A Thief's End is played " +
                "from a third-person perspective, and incorporates platformer elements. Players " +
                "solve puzzles and use firearms, melee combat, and stealth to combat enemies. " +
                "In the online multiplayer mode, up to ten players engage in co-operative " +
                "and competitive modes.",
        price = 450.0,
        rate = 4.5,
        size = 126.3,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    ),
)