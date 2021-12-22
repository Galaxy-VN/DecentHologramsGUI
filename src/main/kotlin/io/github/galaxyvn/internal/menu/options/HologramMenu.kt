package io.github.galaxyvn.internal.menu.options

import eu.decentsoftware.holograms.api.DHAPI
import eu.decentsoftware.holograms.api.holograms.Hologram
import io.github.galaxyvn.internal.menu.options.edit.HologramLines
import io.github.galaxyvn.internal.menu.options.edit.HologramPages
import org.bukkit.entity.Player
import taboolib.library.xseries.XMaterial
import taboolib.module.ui.openMenu
import taboolib.module.ui.type.Basic
import taboolib.platform.util.asLangText

object HologramMenu {

    fun open(player: Player, hologram: Hologram) {
        player.openMenu<Basic>(player.asLangText("Gui-Options-Title")) {
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
                name = player.asLangText("Gui-Options-Back")
            }
            set('1', XMaterial.WRITABLE_BOOK) {
                name = player.asLangText("Gui-Options-Pages")
            }
            onClick(lock = true) { clickEvent ->
                when (clickEvent.slot) {
                    '1' -> HologramPages.open(player, hologram)
                }
            }
        }
    }
}