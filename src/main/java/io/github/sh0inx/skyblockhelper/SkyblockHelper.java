package io.github.sh0inx.skyblockhelper;

import com.iridium.iridiumskyblock.api.IridiumSkyblockAPI;
import io.github.sh0inx.skyblockhelper.managers.ConfigManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyblockHelper extends JavaPlugin {

    @Getter
    private static SkyblockHelper instance;
    @Getter
    private Persist persist;

    @Getter
    private IridiumSkyblockAPI ISapi;
    @Getter
    private ConfigManager configManager;


    public SkyblockHelper() { instance = this; }

    @Override
    public void onEnable() {
        instance = this;
        persist = new Persist(Persist.PersistType.YAML, this);
        getDataFolder().mkdir();
        this.configManager = new ConfigManager();
        configManager.initializeConfigs();

        ISapi = IridiumSkyblockAPI.getInstance();
        if(ISapi == null) {
            Bukkit.getPluginManager().disablePlugin(this);
        }

        registerBlockBankItems();
    }

    @Override
    public void onDisable() {
    }

    public void registerBlockBankItems() {

        int registeredBlockBankItems = 0;

        try {
            ISapi.addBankItem(configManager.getBankItems().coalBankItem);
            registeredBlockBankItems++;
            ISapi.addBankItem(configManager.getBankItems().ironBankItem);
            registeredBlockBankItems++;
            ISapi.addBankItem(configManager.getBankItems().lapisBankItem);
            registeredBlockBankItems++;
            ISapi.addBankItem(configManager.getBankItems().copperBankItem);
            registeredBlockBankItems++;
            ISapi.addBankItem(configManager.getBankItems().goldBankItem);
            registeredBlockBankItems++;
            ISapi.addBankItem(configManager.getBankItems().redstoneBankItem);
            registeredBlockBankItems++;
            ISapi.addBankItem(configManager.getBankItems().emeraldBankItem);
            registeredBlockBankItems++;
            ISapi.addBankItem(configManager.getBankItems().diamondBankItem);
            registeredBlockBankItems++;
            ISapi.addBankItem(configManager.getBankItems().netheriteBankItem);
            registeredBlockBankItems++;
            getLogger().info("Successfully registered (" + registeredBlockBankItems + ") block bank items!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
