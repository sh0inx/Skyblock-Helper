package io.github.sh0inx.skyblockhelper.bankItems;

import com.iridium.iridiumskyblock.database.Island;
import com.iridium.iridiumskyblock.dependencies.iridiumcore.Item;
import com.iridium.iridiumskyblock.dependencies.iridiumcore.dependencies.xseries.XMaterial;
import com.iridium.iridiumteams.database.TeamBlock;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumteams.IridiumTeams;
import com.iridium.iridiumteams.bank.BankItem;
import com.iridium.iridiumteams.bank.BankResponse;
import com.iridium.iridiumteams.database.TeamBank;
import io.github.sh0inx.skyblockhelper.SkyblockHelper;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Optional;

public class BlockBankItem extends BankItem {

    @Getter
    private String bankItemName;
    @Getter
    private XMaterial xMaterial;

    public BlockBankItem(double defaultAmount, Item item, String name, XMaterial xMaterial) {
        super(name, item, defaultAmount, true);
        bankItemName = name;
        this.xMaterial = xMaterial;
    }

    @Override
    public BankResponse withdraw(Player player, Number amount, TeamBank teamBank, IridiumTeams<?, ?> iridiumTeams) {
        int blocks = Math.min(amount.intValue(), (int) teamBank.getNumber());
        if (blocks > 0) {
            player.getInventory().addItem(new ItemStack(xMaterial.parseMaterial())).values().forEach(itemStack ->
                    player.getWorld().dropItem(player.getLocation(), itemStack)
            );
            teamBank.setNumber(teamBank.getNumber() - blocks);
            commitValueTransaction(player, blocks, true);
            return new BankResponse(blocks, true);
        }
        return new BankResponse(blocks, false);
    }

    @Override
    public BankResponse deposit(Player player, Number amount, TeamBank teamBank, IridiumTeams<?, ?> iridiumTeams) {
        int blocks = removeBlocks(player.getInventory());
        if (blocks > 0) {
            teamBank.setNumber(teamBank.getNumber() + blocks);
            commitValueTransaction(player, blocks, false);
            return new BankResponse(blocks, true);
        }
        return new BankResponse(blocks, false);
    }

    private int removeBlocks(Inventory inventory) {
        int removedBlocks = 0;

        for (int slot = 0; slot < inventory.getContents().length; slot++) {
            ItemStack itemStack = inventory.getContents()[slot];
            if (itemStack == null || itemStack.getType() != xMaterial.parseMaterial()) continue;
            int itemStackAmount = itemStack.getAmount();
            inventory.setItem(slot, null);
            removedBlocks += itemStackAmount;
        }

        return removedBlocks;
    }

    private void commitValueTransaction(Player player, int amount, boolean isWithdraw) {
        Optional<Island> island = SkyblockHelper.getInstance().getISapi().getIslandViaPlayer(player);
        if (island.isEmpty()) return;

        double value = IridiumSkyblock.getInstance().getBlockValues().blockValues.get(xMaterial).value;

        List<TeamBlock> teamBlockList = IridiumSkyblock.getInstance().getDatabaseManager().getTeamBlockTableManager().getEntries(island.get());
        for (TeamBlock teamBlock : teamBlockList) {
            if (teamBlock.getXMaterial() != xMaterial) continue;
            if (isWithdraw) teamBlock.setAmount(teamBlock.getAmount() - amount);
            else teamBlock.setAmount(teamBlock.getAmount() + amount);
            teamBlock.setChanged(true);
        }
    }
}
