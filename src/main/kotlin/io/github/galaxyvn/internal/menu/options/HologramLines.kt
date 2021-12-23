package io.github.galaxyvn.internal.menu.options

import eu.decentsoftware.holograms.api.holograms.Hologram
import eu.decentsoftware.holograms.api.holograms.HologramLine
import eu.decentsoftware.holograms.api.holograms.HologramPage
import org.bukkit.entity.Player
import taboolib.library.xseries.XMaterial
import taboolib.module.ui.openMenu
import taboolib.module.ui.type.Linked
import taboolib.platform.util.asLangText
import taboolib.platform.util.buildItem

object HologramLines {
    
    fun open(player: Player, hologram: Hologram, page: HologramPage) {
        player.openMenu<Linked<HologramLine>>(player.asLangText("Gui-Lines-Title")) {
            rows(6)
            slots(listOf(
                9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44
            ))
            elements { page.lines }
            onGenerate { _, element, _, _ ->
                buildItem(XMaterial.WRITABLE_BOOK) {
                    name = "§7Line:§a ${element.text}"
                    lore += listOf(
                        "",
                    )
                }
            }
            for (i in 0..7) {
                set(i, buildItem(XMaterial.GRAY_STAINED_GLASS_PANE) {
                    name = "§r"
                })
            }
            for (i in 45..53) {
                if (i == 47 || i == 49 || i == 51) continue
                set(i, buildItem(XMaterial.GRAY_STAINED_GLASS_PANE) {
                    name = "§r"
                })
            }
        }
    }
}