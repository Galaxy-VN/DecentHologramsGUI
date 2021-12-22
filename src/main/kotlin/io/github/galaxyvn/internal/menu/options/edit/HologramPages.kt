package io.github.galaxyvn.internal.menu.options.edit

import eu.decentsoftware.holograms.api.DHAPI
import eu.decentsoftware.holograms.api.holograms.Hologram
import eu.decentsoftware.holograms.api.holograms.HologramPage
import io.github.galaxyvn.internal.menu.options.HologramMenu
import org.bukkit.entity.Player
import taboolib.library.xseries.XMaterial
import taboolib.module.ui.openMenu
import taboolib.module.ui.type.Linked
import taboolib.platform.util.asLangText
import taboolib.platform.util.buildItem

object HologramPages {

    fun open(player: Player, hologram: Hologram) {
        player.openMenu<Linked<HologramPage>>(player.asLangText("Gui-Pages-Title")) {
            rows(6)
            slots(listOf(
                9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44
            ))
            elements { DHAPI.getHologram(hologram.name)!!.pages.map { it } }
            onGenerate { _, element, _, _ ->
                buildItem(XMaterial.WRITABLE_BOOK) {
                    name = "§7Hologram§a ${element.index + 1}"
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
            set(8, buildItem(XMaterial.YELLOW_STAINED_GLASS_PANE) {
                name = "§7Go Back"
            }) {
                HologramMenu.open(player, hologram)
            }
            setPreviousPage(47) { _, hasPreviousPage ->
                if (hasPreviousPage) {
                    buildItem(XMaterial.PLAYER_HEAD) {
                        name = "§f${player.asLangText("Gui-Main-Previous-Button-Name")}"
                        skullOwner = "MHF_ArrowLeft"
                    }
                } else {
                    buildItem(XMaterial.GRAY_STAINED_GLASS_PANE) {
                        name = "§r"
                    }
                }
            }
            setNextPage(51) { _, hasNextPage ->
                if (hasNextPage) {
                    buildItem(XMaterial.PLAYER_HEAD) {
                        name = "§f${player.asLangText("Gui-Main-Next-Button-Name")}"
                        skullOwner = "MHF_ArrowRight"
                    }
                } else {
                    buildItem(XMaterial.GRAY_STAINED_GLASS_PANE) {
                        name = "§r"
                    }
                }
            }
            onClick { event, element ->
                HologramLines.open(player, hologram, element)
            }
        }
    }

}