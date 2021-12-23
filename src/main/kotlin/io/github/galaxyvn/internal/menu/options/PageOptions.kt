package io.github.galaxyvn.internal.menu.options

import eu.decentsoftware.holograms.api.holograms.Hologram
import eu.decentsoftware.holograms.api.holograms.HologramPage
import io.github.galaxyvn.internal.menu.HologramsMenu
import org.bukkit.entity.Player
import taboolib.library.xseries.XMaterial
import taboolib.module.ui.openMenu
import taboolib.module.ui.type.Basic
import taboolib.platform.util.asLangText

object PageOptions {

    fun open(player: Player, hologram: Hologram, page: HologramPage) {
        player.openMenu<Basic>(player.asLangText("Gui-Page-Options-Title")) {
            rows(5)
            map(
                "########<",
                "",
                " 1 2 3 4",
                "",
                "#########"
            )
            set('#', XMaterial.GRAY_STAINED_GLASS_PANE) {
                name = ""
            }
            set('<', XMaterial.YELLOW_STAINED_GLASS_PANE) {
                name = "§7${player.asLangText("Gui-Back")}"
            }
            set('1', XMaterial.WRITABLE_BOOK) {
                name = "§a${player.asLangText("Gui-Page-Options-Lines")}"
            }
            onClick(lock = true) { clickEvent ->
                when (clickEvent.slot) {
                    '<' -> HologramPages.open(player, hologram)
                    '1' -> HologramLines.open(player, hologram, page)
                }
            }
        }
    }
}