package io.github.galaxyvn.internal.command

import io.github.galaxyvn.internal.menu.HologramsMenu
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.mainCommand

@CommandHeader(name = "decenthologramsgui", aliases = ["dhg", "dhgui"], permission = "decenthologramsgui.admin")
internal object Command {

    @CommandBody
    val main = mainCommand {
        execute<Player> { sender, _, _, ->
            HologramsMenu.open(sender)
        }
    }
}