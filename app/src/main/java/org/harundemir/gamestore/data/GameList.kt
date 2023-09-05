package org.harundemir.gamestore.data

import org.harundemir.gamestore.R
import org.harundemir.gamestore.models.Game

val gameList: List<Game> = listOf(
    Game(
        id = 1,
        cover = R.drawable.mw2_cover,
        avatar = R.drawable.mw2_avatar,
        title = "Call of Duty MWII",
        category = categoryList[0],
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
        category = categoryList[2],
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
        category = categoryList[4],
        description = "PUBG: Battlegrounds (previously known as PlayerUnknown's Battlegrounds) " +
                "is a battle royale game developed by PUBG Studios and published by Krafton. " +
                "The game, which was inspired by the Japanese film Battle Royale (2000), " +
                "is based on previous mods created by Brendan PlayerUnknown Greene for other " +
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
        category = categoryList[3],
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
        category = categoryList[1],
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
    Game(
        id = 6,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "The Legend of Zelda: Breath of the Wild",
        category = categoryList[1],
        description = "Embark on an epic journey as Link, the hero of Hyrule, in the sprawling, " +
                "immersive world of The Legend of Zelda: Breath of the Wild. " +
                "Set in the kingdom of Hyrule, this game invites you to solve intricate puzzles, " +
                "battle formidable monsters, and explore a breathtaking open world filled with " +
                "diverse landscapes, from lush forests to treacherous mountains. " +
                "With its stunning artistry and innovative gameplay, this critically " +
                "acclaimed action-adventure game redefines the genre and sets a " +
                "new standard for open-world gaming.",
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
    Game(
        id = 7,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Fortnite",
        category = categoryList[4],
        description = "Fortnite is a global sensation, where you're dropped into an " +
                "ever-changing arena with 99 other players. In this intense " +
                "battle royale, you'll build structures, wield a variety of weapons, " +
                "and showcase your survival skills. Whether you're a builder, a sharpshooter, " +
                "or a strategist, Fortnite offers endless ways to outsmart and outlast " +
                "your opponents, making every match a unique and adrenaline-pumping experience.",
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
    Game(
        id = 8,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Minecraft",
        category = categoryList[15],
        description = "In Minecraft, you're the architect of your own world. " +
                "Mine resources, craft tools, and build structures in a " +
                "limitless sandbox environment. Whether you're constructing grand " +
                "fortresses, exploring vast underground caverns, or fending off " +
                "hostile mobs, Minecraft fuels your creativity and survival instincts, " +
                "making it a beloved classic among gamers of all ages.",
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
    Game(
        id = 9,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Overwatch",
        category = categoryList[2],
        description = "Overwatch invites you to join a diverse cast of heroes, each with their " +
                "own unique abilities, in fast-paced team-based battles. " +
                "Whether you're healing teammates, laying down suppressing fire, or " +
                "unleashing powerful ultimates, teamwork is key to victory. With its " +
                "colorful characters and dynamic gameplay, Overwatch offers an " +
                "exhilarating FPS experience like no other.",
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
    Game(
        id = 10,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Stardew Valley",
        category = categoryList[9],
        description = "Escape to the idyllic countryside in Stardew Valley, where you inherit " +
                "a run-down farm and embark on a journey of growth and discovery. Plant crops, " +
                "raise animals, mine for valuable resources, and engage with the charming " +
                "residents of Pelican Town. This heartwarming simulation game captures the joys " +
                "of rural life while offering endless opportunities for creativity and " +
                "community building.",
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
    Game(
        id = 11,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Red Dead Redemption 2",
        category = categoryList[1],
        description = "Set in the American Wild West, Red Dead Redemption 2 places you in " +
                "the boots of Arthur Morgan, an outlaw on the run. Immerse yourself in a " +
                "richly detailed open world, where gunfights, wildlife encounters, and moral " +
                "choices shape your destiny. With its cinematic storytelling and breathtaking " +
                "landscapes, this game offers a gripping and unforgettable journey through " +
                "a bygone era.",
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
    Game(
        id = 12,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Rocket League",
        category = categoryList[8],
        description = "Rocket League is a high-octane blend of soccer and rocket-powered cars. " +
                "Team up with friends or go solo in this unique sports game where acrobatic " +
                "aerial maneuvers, precise ball control, and strategic teamwork are the keys " +
                "to victory. Whether you're pulling off amazing goals or making epic saves, " +
                "Rocket League offers non-stop, adrenaline-fueled fun.",
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
    Game(
        id = 13,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "The Witcher 3: Wild Hunt",
        category = categoryList[5],
        description = "Embark on a captivating journey as Geralt of Rivia, a skilled monster " +
                "hunter, in The Witcher 3: Wild Hunt. Explore a beautifully crafted open " +
                "world, where your decisions have far-reaching consequences. Slay mythical " +
                "creatures, engage in morally complex quests, and uncover a gripping " +
                "narrative filled with political intrigue and personal drama.",
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
    Game(
        id = 14,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Apex Legends",
        category = categoryList[4],
        description = "Form a squad of legendary characters known as Legends in Apex Legends " +
                "and compete in the Apex Games, a brutal battle royale set in the Titanfall " +
                "universe. Master the unique abilities of each Legend, coordinate with your " +
                "teammates, and rise to the top in intense, fast-paced battles. Apex Legends " +
                "delivers a thrilling and strategic take on the battle royale genre.",
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
    Game(
        id = 15,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Animal Crossing: New Horizons",
        category = categoryList[9],
        description = " Animal Crossing: New Horizons whisks you away to a serene island " +
                "paradise. Create your dream getaway, design your perfect home, and build " +
                "relationships with charming anthropomorphic animal villagers. With its " +
                "laid-back gameplay and endless customization options, this life simulation " +
                "game is a delightful escape into a world of creativity and relaxation.",
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
    Game(
        id = 16,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Cyberpunk 2077",
        category = categoryList[5],
        description = "Cyberpunk 2077 plunges you into the dystopian future of Night City, " +
                "where you assume the role of V, a mercenary with ambitions of immortality. " +
                "Customize your character's appearance, augmentations, and playstyle as you " +
                "navigate a gritty, neon-lit metropolis filled with cyber-enhanced individuals " +
                "and corporate intrigue. Engage in high-stakes combat, hack into the city's " +
                "networks, and make choices that influence the branching narrative, all in a " +
                "visually stunning and emotionally charged RPG experience.",
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
    Game(
        id = 17,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Super Mario Odyssey",
        category = categoryList[6],
        description = "Join gaming's most iconic plumber, Mario, on a globe-trotting " +
                "adventure in Super Mario Odyssey. Bowser has kidnapped Princess Peach, " +
                "and it's up to Mario to save her once again. Explore vibrant and diverse " +
                "kingdoms, from the bustling streets of New Donk City to the sandy deserts " +
                "of Tostarena. With the help of his sentient hat, Cappy, Mario can possess " +
                "objects and creatures, adding a fresh twist to classic platforming gameplay. " +
                "Super Mario Odyssey is a celebration of creativity, nostalgia, and pure fun.",
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
    Game(
        id = 18,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Dark Souls III",
        category = categoryList[5],
        description = "Prepare to test your mettle in the dark and unforgiving world of " +
                "Dark Souls III. As the Ashen One, you'll confront grotesque creatures, " +
                "legendary bosses, and a decaying kingdom plagued by the undead. In this " +
                "action RPG, every move and decision matters, and you'll need both skill " +
                "and strategy to overcome the challenges that await. The game's rich lore, " +
                "atmospheric world, and challenging gameplay have made it a favorite " +
                "among fans of hardcore action RPGs.",
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
    Game(
        id = 19,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "The Sims 4",
        category = categoryList[9],
        description = "The Sims 4 allows you to create and control virtual lives in an " +
                "endlessly entertaining simulation. Build and customize homes, shape " +
                "relationships, and guide the destinies of your Sims as they pursue careers, " +
                "hobbies, and love interests. With its vast array of expansion packs and " +
                "creative possibilities, The Sims 4 empowers players to craft unique " +
                "stories and experiences within the charming, quirky world of Simsville.",
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
    Game(
        id = 20,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Resident Evil Village",
        category = categoryList[14],
        description = "Step into the chilling world of Resident Evil Village, where you'll " +
                "face gruesome horrors and unearth dark secrets. As Ethan Winters, you'll " +
                "navigate a nightmarish village filled with grotesque creatures and confront a " +
                "towering, enigmatic figure known as Lady Dimitrescu. Solve intricate " +
                "puzzles, conserve precious resources, and uncover the mysteries lurking in " +
                "this survival horror masterpiece that combines intense action and " +
                "psychological terror.",
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
    Game(
        id = 21,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Halo: Infinite",
        category = categoryList[2],
        description = "Master Chief returns in Halo: Infinite to face a formidable new " +
                "threat on a mysterious ringworld. Engage in pulse-pounding FPS combat, " +
                "wielding iconic weapons and vehicles from the Halo series. Explore a " +
                "visually stunning, open-world environment filled with secrets to uncover " +
                "and enemies to defeat. With a focus on epic storytelling and thrilling " +
                "multiplayer action, Halo: Infinite promises an unforgettable journey for " +
                "fans and newcomers alike.",
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
    Game(
        id = 22,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Assassin's Creed Valhalla",
        category = categoryList[1],
        description = "Become Eivor, a fierce Viking warrior, in Assassin's Creed Valhalla, " +
                "and lead your clan to conquer the lush landscapes of England during the " +
                "Viking Age. Engage in epic battles, siege fortified castles, and forge" +
                " alliances as you shape the destiny of your people. The game seamlessly" +
                " blends the series' signature stealth and parkour mechanics with visceral " +
                "combat, offering a sprawling and historically rich adventure.",
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
    Game(
        id = 23,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Dead by Daylight",
        category = categoryList[14],
        description = "Dead by Daylight delivers asymmetric multiplayer horror, where one " +
                "player assumes the role of a ruthless killer while the rest try to escape " +
                "their clutches. Whether you're evading the relentless killer's pursuit or " +
                "hunting down survivors as the villain, the game offers heart-pounding " +
                "suspense and intense cat-and-mouse gameplay. With a diverse roster of " +
                "killers and survivors, each with their own abilities, Dead by Daylight " +
                "ensures no two matches are alike.",
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
    Game(
        id = 24,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Celeste",
        category = categoryList[6],
        description = "Celeste is a heartfelt platformer that follows the journey of " +
                "Madeline, a young woman striving to climb the titular mountain. As " +
                "Madeline, you'll navigate treacherous levels filled with challenging " +
                "platforming sequences and environmental puzzles. Beyond its tight " +
                "gameplay, Celeste delivers a touching narrative exploring themes of " +
                "mental health, perseverance, and self-discovery, making it a deeply emotional " +
                "and rewarding gaming experience.",
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
    Game(
        id = 25,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Max Payne 2: The Fall of Max Payne",
        category = categoryList[16],
        description = "Max Payne 2: The Fall of Max Payne continues the gripping noir " +
                "tale of Max Payne, a troubled former detective with a penchant for diving " +
                "headfirst into danger. In this intense third-person shooter, Max finds " +
                "himself embroiled in a web of conspiracy and betrayal as he investigates " +
                "a series of gruesome murders.\n" +
                "\n" +
                "Set in a dark and rain-soaked cityscape, the game masterfully combines " +
                "gritty storytelling with exhilarating gunplay. Max's iconic Bullet Time ability " +
                "returns, allowing players to slow down time during combat, creating cinematic " +
                "moments of bullet-dodging and precision shooting.\n" +
                "\n" +
                "The game also introduces enhanced physics and ragdoll effects, adding a " +
                "layer of realism to the intense action sequences. As Max, you'll navigate " +
                "through a deeply atmospheric world filled with seedy characters and moral " +
                "ambiguity, all while unraveling a complex narrative that keeps you on the " +
                "edge of your seat.\n" +
                "\n" +
                "With its film-noir-inspired visuals, emotionally charged narrative, and " +
                "tight gameplay mechanics, Max Payne 2 is a timeless classic that immerses " +
                "players in a dark and gritty underworld where justice comes at a heavy price." +
                " Whether you're a fan of intense gunfights, gripping storytelling, " +
                "or atmospheric settings, this game delivers an unforgettable experience that " +
                "solidifies Max Payne's status as one of gaming's most iconic anti-heroes.",
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