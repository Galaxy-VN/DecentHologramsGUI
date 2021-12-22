package io.github.galaxyvn

import org.bukkit.Bukkit
import taboolib.common.env.Repository.downloadToFile
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.console
import taboolib.common.platform.function.info
import taboolib.common.platform.function.pluginVersion
import taboolib.module.lang.sendLang
import taboolib.platform.BukkitPlugin
import java.io.File
import java.io.IOException
import java.net.URL

object DecentHologramsGUI : Plugin() {

    val plugin by lazy { BukkitPlugin.getInstance() }

    override fun onLoad() {
        console().sendLang("Plugin-Loaded", Bukkit.getVersion())

        if (!hookHolograms()) {
            return
        }
    }

    override fun onEnable() {
        console().sendLang("Plugin-Enabled", pluginVersion)
    }

    override fun onDisable() {
        console().sendLang("Plugin-Disabled")
    }
    /*
    * Detection front DecentHolograms
    * And automatically download and restart the server
    */
    private fun hookHolograms(): Boolean {
        val plugin = Bukkit.getPluginManager().getPlugin("DecentHolograms")
        val jarFile = File("plugins/DecentHolograms.jar")
        val url = URL("https://api.spiget.org/v2/resources/96927/download")

        if (plugin == null) {
            jarFile.delete()
            console().sendLang("Plugin-Depend-Download", "DecentHolograms")
            try {
                downloadToFile(url, jarFile)
            } catch (e: IOException) {
                e.printStackTrace()
                console().sendLang("Plugin-Depend-Install-Failed", "DecentHolograms")
                Bukkit.shutdown()
                return false
            }
            console().sendLang("Plugin-Depend-Installed", "DecentHolograms")
            Bukkit.shutdown()
            return false
        }
        return true
    }
}