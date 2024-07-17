package io.github.sh0inx.skyblockhelper.managers;

import io.github.sh0inx.skyblockhelper.SkyblockHelper;
import io.github.sh0inx.skyblockhelper.config.BankItems;
import lombok.Getter;

@Getter
public class ConfigManager {

    @Getter
    private BankItems bankItems;

    public ConfigManager() {
        this.bankItems = new BankItems();
    }

    public void loadConfigs() {
        this.bankItems = SkyblockHelper.getInstance().getPersist().load(BankItems.class);
    }

    public void saveConfigs() {
        SkyblockHelper.getInstance().getPersist().save(bankItems);
    }

    public void initializeConfigs() {
        loadConfigs();
        saveConfigs();
    }
}