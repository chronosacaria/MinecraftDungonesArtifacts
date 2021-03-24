package mcdar.chronosacaria;

import mcdar.chronosacaria.init.ArtefactsInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Mcdar implements ModInitializer {
    public static final String MOD_ID = "mcdar";

    public static final ItemGroup ARTEFACTS = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "artefacts"),
            () -> new ItemStack(ArtefactsInit.BOOTS_OF_SWIFTNESS));

    @Override
    public void onInitialize() {
        ArtefactsInit.init();
    }
}
