package io.github.sh0inx.skyblockhelper.config;

import com.iridium.iridiumskyblock.dependencies.iridiumcore.Item;
import com.iridium.iridiumskyblock.dependencies.iridiumcore.dependencies.xseries.XMaterial;
import io.github.sh0inx.skyblockhelper.bankItems.BlockBankItem;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
public class BankItems extends com.iridium.iridiumteams.configs.BankItems {

    public BlockBankItem coalBankItem = new BlockBankItem(100, new Item(XMaterial.COAL_BLOCK, 0, 1, "&9&lCoal Blocks", Arrays.asList(
            "&7%amount% Coal Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Coal", XMaterial.COAL_BLOCK);

    public BlockBankItem ironBankItem = new BlockBankItem(100, new Item(XMaterial.IRON_BLOCK, 1, 1, "&9&lIron Blocks", Arrays.asList(
            "&7%amount% Iron Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Iron", XMaterial.IRON_BLOCK);

    public BlockBankItem lapisBankItem = new BlockBankItem(100, new Item(XMaterial.LAPIS_BLOCK, 2, 1, "&9&lLapis Blocks", Arrays.asList(
            "&7%amount% Lapis Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Lapis", XMaterial.LAPIS_BLOCK);

    public BlockBankItem copperBankItem = new BlockBankItem(100, new Item(XMaterial.COPPER_BLOCK, 3, 1, "&9&lCopper Blocks", Arrays.asList(
            "&7%amount% Copper Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Copper", XMaterial.COPPER_BLOCK);

    public BlockBankItem goldBankItem = new BlockBankItem(100, new Item(XMaterial.GOLD_BLOCK, 4, 1, "&9&lGold Blocks", Arrays.asList(
            "&7%amount% Gold Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Gold", XMaterial.GOLD_BLOCK);

    public BlockBankItem redstoneBankItem = new BlockBankItem(100, new Item(XMaterial.REDSTONE_BLOCK, 5, 1, "&9&lRedstone Blocks", Arrays.asList(
            "&7%amount% Redstone Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Redstone", XMaterial.REDSTONE_BLOCK);

    public BlockBankItem emeraldBankItem = new BlockBankItem(100, new Item(XMaterial.EMERALD_BLOCK, 6, 1, "&9&lEmerald Blocks", Arrays.asList(
            "&7%amount% Emerald Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Emerald", XMaterial.EMERALD_BLOCK);

    public BlockBankItem diamondBankItem = new BlockBankItem(100, new Item(XMaterial.DIAMOND_BLOCK, 7, 1, "&9&lDiamond Blocks", Arrays.asList(
            "&7%amount% Diamond Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Diamond", XMaterial.DIAMOND_BLOCK);

    public BlockBankItem netheriteBankItem = new BlockBankItem(100, new Item(XMaterial.NETHERITE_BLOCK, 8, 1, "&9&lNetherite Blocks", Arrays.asList(
            "&7%amount% Netherite Blocks",
            "&9&l[!] &9Left click to withdraw",
            "&9&l[!] &9Right click to deposit")
    ), "Netherite", XMaterial.NETHERITE_BLOCK);
}