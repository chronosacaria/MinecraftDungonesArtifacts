package chronosacaria.mcdar.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class McdarClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //SummonedEntityRenderRegistry.register();
        SummonedEntityRenderRegistry.init();
    }
}
