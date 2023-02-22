package chronosacaria.mcdar.artifacts;

import chronosacaria.mcdar.Mcdar;
import chronosacaria.mcdar.config.McdarConfig;
import chronosacaria.mcdar.enums.SummoningArtifactID;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class ArtifactSummoningItem extends Item {

    public final SummoningArtifactID id;

    public ArtifactSummoningItem(SummoningArtifactID id) {
        super(new Settings().maxCount(1).group(Mcdar.ARTEFACTS).maxDamage(McdarConfig.CONFIG.getSummoningArtifactDurability()));
        this.id = id;
    }

    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }
}