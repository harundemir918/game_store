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
        cover = R.drawable.zelda_cover,
        avatar = R.drawable.zelda_avatar,
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
        price = 1560.0,
        rate = 4.5,
        size = 21.0,
        images = listOf(
            R.drawable.zelda_cover,
            R.drawable.zelda_1,
            R.drawable.zelda_2,
        )
    ),
    Game(
        id = 7,
        cover = R.drawable.fortnite_cover,
        avatar = R.drawable.fortnite_avatar,
        title = "Fortnite",
        category = categoryList[4],
        description = "Fortnite is a global sensation, where you're dropped into an " +
                "ever-changing arena with 99 other players. In this intense " +
                "battle royale, you'll build structures, wield a variety of weapons, " +
                "and showcase your survival skills. Whether you're a builder, a sharpshooter, " +
                "or a strategist, Fortnite offers endless ways to outsmart and outlast " +
                "your opponents, making every match a unique and adrenaline-pumping experience.",
        price = 100.0,
        rate = 4.5,
        size = 40.0,
        images = listOf(
            R.drawable.fortnite_cover,
            R.drawable.fortnite_1,
            R.drawable.fortnite_2,
        )
    ),
    Game(
        id = 8,
        cover = R.drawable.minecraft_cover,
        avatar = R.drawable.minecraft_avatar,
        title = "Minecraft",
        category = categoryList[15],
        description = "In Minecraft, you're the architect of your own world. " +
                "Mine resources, craft tools, and build structures in a " +
                "limitless sandbox environment. Whether you're constructing grand " +
                "fortresses, exploring vast underground caverns, or fending off " +
                "hostile mobs, Minecraft fuels your creativity and survival instincts, " +
                "making it a beloved classic among gamers of all ages.",
        price = 350.0,
        rate = 4.5,
        size = 4.0,
        images = listOf(
            R.drawable.minecraft_cover,
            R.drawable.minecraft_1,
            R.drawable.minecraft_2,
        )
    ),
    Game(
        id = 9,
        cover = R.drawable.doom_cover,
        avatar = R.drawable.doom_avatar,
        title = "DOOM (2016)",
        category = categoryList[2],
        description = "DOOM (2016) is a relentless and action-packed revival of the " +
                "classic FPS franchise. As the Doom Slayer, you awaken in a research " +
                "facility on Mars overrun by demons from Hell. Armed with an arsenal " +
                "of powerful weapons, you'll engage in fast-paced, brutal combat with " +
                "hordes of relentless enemies. The game emphasizes speed, aggression, " +
                "and unapologetic violence, encouraging players to rip and tear through " +
                "demons with visceral satisfaction. With its iconic weapons, intense " +
                "multiplayer modes, and a pounding metal soundtrack, DOOM (2016) delivers " +
                "a no-holds-barred FPS experience that pays homage to the genre's " +
                "roots while pushing it into the modern era.",
        price = 180.0,
        rate = 4.5,
        size = 55.0,
        images = listOf(
            R.drawable.doom_cover,
            R.drawable.doom_1,
            R.drawable.doom_2,
        )
    ),
    Game(
        id = 10,
        cover = R.drawable.sw_cover,
        avatar = R.drawable.sw_avatar,
        title = "Stardew Valley",
        category = categoryList[9],
        description = "Escape to the idyllic countryside in Stardew Valley, where you inherit " +
                "a run-down farm and embark on a journey of growth and discovery. Plant crops, " +
                "raise animals, mine for valuable resources, and engage with the charming " +
                "residents of Pelican Town. This heartwarming simulation game captures the joys " +
                "of rural life while offering endless opportunities for creativity and " +
                "community building.",
        price = 24.0,
        rate = 4.5,
        size = 1.0,
        images = listOf(
            R.drawable.sw_cover,
            R.drawable.sw_1,
            R.drawable.sw_2,
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
        price = 1150.0,
        rate = 4.5,
        size = 150.0,
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
        cover = R.drawable.rl_cover,
        avatar = R.drawable.u4_avatar,
        title = "Rocket League",
        category = categoryList[8],
        description = "Rocket League is a high-octane blend of soccer and rocket-powered cars. " +
                "Team up with friends or go solo in this unique sports game where acrobatic " +
                "aerial maneuvers, precise ball control, and strategic teamwork are the keys " +
                "to victory. Whether you're pulling off amazing goals or making epic saves, " +
                "Rocket League offers non-stop, adrenaline-fueled fun.",
        price = 100.0,
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
    Game(
        id = 13,
        cover = R.drawable.w3_cover,
        avatar = R.drawable.w3_avatar,
        title = "The Witcher 3: Wild Hunt",
        category = categoryList[5],
        description = "Embark on a captivating journey as Geralt of Rivia, a skilled monster " +
                "hunter, in The Witcher 3: Wild Hunt. Explore a beautifully crafted open " +
                "world, where your decisions have far-reaching consequences. Slay mythical " +
                "creatures, engage in morally complex quests, and uncover a gripping " +
                "narrative filled with political intrigue and personal drama.",
        price = 540.0,
        rate = 4.5,
        size = 70.0,
        images = listOf(
            R.drawable.w3_cover,
            R.drawable.w3_1,
            R.drawable.w3_2,
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
        price = 100.0,
        rate = 4.5,
        size = 50.0,
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
        cover = R.drawable.ets2_cover,
        avatar = R.drawable.u4_avatar,
        title = "Euro Truck Simulator 2",
        category = categoryList[9],
        description = "Euro Truck Simulator 2 immerses you in the world of long-haul " +
                "trucking, allowing you to become a skilled truck driver navigating the " +
                "highways and byways of Europe. Starting as a humble driver, you work your " +
                "way up to manage your own trucking business. Haul cargo across a " +
                "meticulously recreated continent, from bustling cities to serene " +
                "countryside. Manage your deliveries, maintain your truck, and experience " +
                "the challenges and rewards of the trucking life. With realistic physics, " +
                "stunning landscapes, and a dedicated modding community, this simulator " +
                "offers a surprisingly engrossing and relaxing gameplay experience.",
        price = 300.0,
        rate = 4.5,
        size = 19.5,
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
        cover = R.drawable.cyber_cover,
        avatar = R.drawable.cyber_avatar,
        title = "Cyberpunk 2077",
        category = categoryList[5],
        description = "Cyberpunk 2077 plunges you into the dystopian future of Night City, " +
                "where you assume the role of V, a mercenary with ambitions of immortality. " +
                "Customize your character's appearance, augmentations, and playstyle as you " +
                "navigate a gritty, neon-lit metropolis filled with cyber-enhanced individuals " +
                "and corporate intrigue. Engage in high-stakes combat, hack into the city's " +
                "networks, and make choices that influence the branching narrative, all in a " +
                "visually stunning and emotionally charged RPG experience.",
        price = 900.0,
        rate = 4.5,
        size = 120.0,
        images = listOf(
            R.drawable.cyber_cover,
            R.drawable.cyber_1,
            R.drawable.cyber_2,
        )
    ),
    Game(
        id = 17,
        cover = R.drawable.mario_cover,
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
        price = 2000.0,
        rate = 4.5,
        size = 10.0,
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
        price = 900.0,
        rate = 4.5,
        size = 40.0,
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
        title = "Microsoft Flight Simulator",
        category = categoryList[9],
        description = "Microsoft Flight Simulator is the ultimate flight simulation " +
                "experience, allowing you to take to the skies and explore the " +
                "entire globe in breathtaking detail. Choose from a vast array of " +
                "aircraft, from small prop planes to jumbo jets, and fly anywhere on " +
                "Earth with realistic weather, time of day, and live traffic data. " +
                "Whether you're a seasoned pilot or a newcomer, the simulator offers " +
                "various modes, including guided tutorials and free-flight exploration. " +
                "With its cutting-edge technology, stunning visuals, and a commitment to " +
                "realism, Microsoft Flight Simulator provides an unparalleled and awe-inspiring " +
                "journey through the wonders of flight.",
        price = 1000.0,
        rate = 4.5,
        size = 150.0,
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
        price = 800.0,
        rate = 4.5,
        size = 45.0,
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
        price = 600.0,
        rate = 4.5,
        size = 50.0,
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
        price = 700.0,
        rate = 4.5,
        size = 70.0,
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
        cover = R.drawable.dbd_cover,
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
        price = 170.0,
        rate = 4.5,
        size = 30.0,
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
        price = 30.0,
        rate = 4.5,
        size = 2.0,
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
        cover = R.drawable.mp_cover,
        avatar = R.drawable.u4_avatar,
        title = "Max Payne",
        category = categoryList[16],
        description = "Max Payne is a groundbreaking third-person shooter that " +
                "introduced players to the dark and gritty world of Max Payne, a " +
                "former New York City detective seeking vengeance against those " +
                "responsible for his family's brutal murder. With its noir-inspired " +
                "storytelling, stylish graphic novel cutscenes, and innovative bullet time " +
                "gameplay mechanic, the game set a new standard for cinematic action in " +
                "video games. Navigate through a crime-ridden New York City, engage in " +
                "intense shootouts, and uncover a conspiracy that leads to a dramatic and " +
                "thrilling conclusion.",
        price = 20.0,
        rate = 4.5,
        size = 2.0,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    ),
    Game(
        id = 26,
        cover = R.drawable.u4_cover,
        avatar = R.drawable.u4_avatar,
        title = "Forza Horizon 4",
        category = categoryList[3],
        description = "Forza Horizon 4 is an exhilarating racing game that invites you to " +
                "experience the thrill of open-world racing in a stunning virtual rendition " +
                "of the United Kingdom. With a vast and dynamic map, you can choose from a " +
                "diverse array of cars, from sleek supercars to off-road vehicles, and " +
                "participate in a variety of races and challenges. The changing seasons and " +
                "realistic weather conditions add depth and challenge to your races, making " +
                "each one a unique and adrenaline-pumping experience. Whether you're competing " +
                "against AI or racing with friends in multiplayer mode, Forza Horizon 4 " +
                "delivers top-notch graphics, realistic physics, and an immersive racing " +
                "experience that appeals to both casual gamers and racing enthusiasts.",
        price = 200.0,
        rate = 4.5,
        size = 100.0,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    ),
    Game(
        id = 27,
        cover = R.drawable.portal_cover,
        avatar = R.drawable.u4_avatar,
        title = "Portal",
        category = categoryList[7],
        description = "Portal is a mind-bending first-person puzzle game that challenges " +
                "players with solving intricate spatial conundrums. Armed with a handheld " +
                "portal device, you must navigate a series of test chambers filled with " +
                "optical illusions and physics-based puzzles. With its witty AI companion, " +
                "GLaDOS, and innovative gameplay mechanics, Portal offers a unique and " +
                "thought-provoking gaming experience.",
        price = 105.0,
        rate = 4.5,
        size = 10.0,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    ),
    Game(
        id = 28,
        cover = R.drawable.aoe2_cover,
        avatar = R.drawable.u4_avatar,
        title = "Age of Empires II: Definitive Edition",
        category = categoryList[10],
        description = "Age of Empires II: Definitive Edition is a beloved real-time strategy " +
                "game that invites players to command historical civilizations and shape the " +
                "course of history. Build mighty empires, lead armies into epic battles, and " +
                "develop advanced technologies across various historical eras. With improved " +
                "graphics, new content, and a vibrant multiplayer community, this game is a " +
                "timeless classic for strategy enthusiasts.",
        price = 200.0,
        rate = 4.5,
        size = 30.0,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    ),
    Game(
        id = 29,
        cover = R.drawable.t7_cover,
        avatar = R.drawable.u4_avatar,
        title = "Tekken 7",
        category = categoryList[11],
        description = "Tekken 7 is a thrilling fighting game that pits a diverse roster of " +
                "martial artists and combatants against each other in high-stakes battles. " +
                "With its deep and complex combat system, players can master a wide array of " +
                "fighting styles and engage in intense one-on-one duels. With stunning " +
                "graphics and a compelling storyline, Tekken 7 remains a staple in the " +
                "competitive fighting game scene.",
        price = 600.0,
        rate = 4.5,
        size = 60.0,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    ),
    Game(
        id = 30,
        cover = R.drawable.h3_cover,
        avatar = R.drawable.u4_avatar,
        title = "Hitman 3",
        category = categoryList[12],
        description = "In Hitman 3, you step into the shoes of Agent 47, the world's " +
                "deadliest assassin. As you travel to various international locations, " +
                "you'll use stealth, disguise, and creative tactics to eliminate high-profile " +
                "targets with precision and finesse. With its intricate level design and a " +
                "plethora of ways to accomplish your objectives, Hitman 3 offers a thrilling " +
                "and cerebral stealth experience.",
        price = 420.0,
        rate = 4.5,
        size = 60.0,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    ),
    Game(
        id = 31,
        cover = R.drawable.tld_cover,
        avatar = R.drawable.u4_avatar,
        title = "The Long Dark",
        category = categoryList[13],
        description = "The Long Dark is a harrowing survival game set in the frigid wilderness " +
                "of Canada after a global disaster. You must scavenge for resources, manage " +
                "hunger and cold, and fend off wildlife as you navigate a desolate open " +
                "world. With its realistic survival mechanics and atmospheric storytelling, " +
                "this game tests your resourcefulness and adaptability in the face of " +
                "extreme adversity.",
        price = 60.0,
        rate = 4.5,
        size = 7.0,
        images = listOf(
            R.drawable.u4_cover,
            R.drawable.u4_1,
            R.drawable.u4_2,
            R.drawable.u4_3,
            R.drawable.u4_4,
        )
    )
)