package dev.timefall.mcdar.statuseffect;

import dev.timefall.mcdar.ModConstants;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShieldingStatusEffect extends StatusEffect {

    public ShieldingStatusEffect(StatusEffectCategory type, int color, String id) {
        super(type, color);
        Registry.register(Registries.STATUS_EFFECT, Identifier.of(ModConstants.MOD_ID, id), this);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }
}