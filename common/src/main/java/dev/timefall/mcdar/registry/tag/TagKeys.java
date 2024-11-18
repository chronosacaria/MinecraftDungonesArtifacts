package dev.timefall.mcdar.registry.tag;

import dev.timefall.mcdar.ModConstants;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class TagKeys {
    public static final TagKey<Item> VILLAGER_ARTIFACT = TagKey.of(RegistryKeys.ITEM, ModConstants.ID("villager_artifacts"));
    public static final TagKey<Item> ILLAGER_ARTIFACT = TagKey.of(RegistryKeys.ITEM, ModConstants.ID("illager_artifacts"));
    public static final TagKey<Item> ALL_ARTIFACT = TagKey.of(RegistryKeys.ITEM, ModConstants.ID("all_artifacts"));

}