package io.github.galaxyvn.internal.menu.options

import eu.decentsoftware.holograms.api.DHAPI
import eu.decentsoftware.holograms.api.holograms.Hologram
import eu.decentsoftware.holograms.api.holograms.HologramPage
import org.bukkit.entity.Player
import taboolib.library.xseries.XMaterial
import taboolib.module.ui.openMenu
import taboolib.module.ui.type.Linked
import taboolib.platform.util.*

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
            elements { DHAPI.getHologram(hologram.name)!!.pages }
            onGenerate { _, element, _, _ ->
                buildItem(XMaterial.WRITABLE_BOOK) {
                    name = "§7${player.asLangText("Gui-Pages-Page")}§a ${element.index + 1}"
                    lore += listOf(
                        "",
                        "§6 ● §8${player.asLangText("Gui-Info")}:",
                        "   §7 ${player.asLangText("Gui-Pages-Page")}: ${element.index + 1}",
                        "   §7 ${player.asLangText("Gui-Pages-Lines")}: ${element.lines.size}",
                        "",
                        "§8➥ §e${player.asLangText("Gui-Click-Edit")}",
                        ""
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
                name = "§7${player.asLangText("Gui-Back")}"
            }) {
                HologramMenu.open(player, hologram)
            }
            set(49, buildItem(XMaterial.PLAYER_HEAD) {
                name = "§a${player.asLangText("Gui-Pages-Add")}"
                skullTexture = ItemBuilder.SkullTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjA1NmJjMTI0NGZjZmY5OTM0NGYxMmFiYTQyYWMyM2ZlZTZlZjZlMzM1MWQyN2QyNzNjMTU3MjUzMWYifX19")
            }) {
                DHAPI.addHologramPage(hologram)
                player.sendLang("Success")
                open(player, hologram)
            }
            setPreviousPage(47) { _, hasPreviousPage ->
                if (hasPreviousPage) {
                    buildItem(XMaterial.PLAYER_HEAD) {
                        name = "§f${player.asLangText("Gui-Previous-Button")}"
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
                        name = "§f${player.asLangText("Gui-Next-Button")}"
                        skullOwner = "MHF_ArrowRight"
                    }
                } else {
                    buildItem(XMaterial.GRAY_STAINED_GLASS_PANE) {
                        name = "§r"
                    }
                }
            }
            onClick { event, element ->
                PageOptions.open(player, hologram, element)
            }
        }
    }

}