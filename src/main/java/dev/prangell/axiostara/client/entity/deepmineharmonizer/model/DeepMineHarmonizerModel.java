package dev.prangell.axiostara.client.entity.deepmineharmonizer.model;

import dev.prangell.axiostara.Axiostara;
import dev.prangell.axiostara.entity.pulse.DeepMineHarmonizerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DeepMineHarmonizerModel extends GeoModel<DeepMineHarmonizerEntity> {
    @Override
    public Identifier getModelResource(DeepMineHarmonizerEntity animatable) {
        return new Identifier(Axiostara.MOD_ID, "geo/entity/pulse/deep_mine_harmonizer.geo.json");
    }

    @Override
    public Identifier getTextureResource(DeepMineHarmonizerEntity animatable) {
        return new Identifier(Axiostara.MOD_ID, "textures/entity/pulse/deep_mine_harmonizer.png");
    }

    @Override
    public Identifier getAnimationResource(DeepMineHarmonizerEntity animatable) {
        return new Identifier(Axiostara.MOD_ID, "animations/entity/pulse/deep_mine_harmonizer.animation.json");
    }
}