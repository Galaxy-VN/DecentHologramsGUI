package io.github.galaxyvn.internal.menu

import eu.decentsoftware.holograms.api.DHAPI
import eu.decentsoftware.holograms.api.holograms.Hologram
import io.github.galaxyvn.internal.menu.options.HologramMenu
import org.bukkit.entity.Player
import taboolib.common5.Coerce
import taboolib.library.xseries.XMaterial
import taboolib.module.ui.openMenu
import taboolib.module.ui.type.Linked
import taboolib.platform.util.*

object HologramsMenu {



    fun open(player: Player) {
        player.openMenu<Linked<Hologram>>(player.asLangText("Gui-Main-Title")) {
            rows(6)
            slots(listOf(
                9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44
            ))
            elements { Hologram.getCachedHolograms().map { it } }
            onGenerate { _, element, _, _ ->
                buildItem(XMaterial.WRITABLE_BOOK) {
                    name = "§7Hologram§a ${element.name}"
                    lore += listOf(
                        "",
                        "§6 ● §8${player.asLangText("Gui-Main-Hologram-Info-Info")}:",
                        "   §7 Id: ${element.id}",
                        "   §7 ${player.asLangText("Gui-Main-Hologram-Info-Enabled")}: ${element.isEnabled}",
                        "   §7 ${player.asLangText("Gui-Main-Hologram-Info-Pages")}: ${element.size()}",
                        "",
                        "§8➥ §e${player.asLangText("Gui-Main-Hologram-Info-Click-Edit")}",
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
            set(8, buildItem(XMaterial.RED_STAINED_GLASS_PANE) {
                name = "§c${player.asLangText("Gui-Main-Close")}"
            }) {
                player.closeInventory()
            }
            set(49, buildItem(XMaterial.PLAYER_HEAD) {
                name = "§a${player.asLangText("Gui-Main-Hologram-Create-Name")}"
                skullTexture = ItemBuilder.SkullTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjA1NmJjMTI0NGZjZmY5OTM0NGYxMmFiYTQyYWMyM2ZlZTZlZjZlMzM1MWQyN2QyNzNjMTU3MjUzMWYifX19")
            }) {
                player.closeInventory()
                player.sendLang("Create-Hologram")
                player.nextChat {
                    DHAPI.createHologram(Coerce.toString(it), player.location, true)
                    player.sendLang("Success")
                }
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
                HologramMenu.open(player, element)
            }
        }
    }

}