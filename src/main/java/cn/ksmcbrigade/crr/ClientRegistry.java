package cn.ksmcbrigade.crr;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Mod("crr")
public class ClientRegistry {

    private static Map<Class<? extends Entity>, ResourceLocation> entityShaderMap = new ConcurrentHashMap<>();

    public static synchronized void registerKeyBinding(KeyMapping key) {
        Minecraft.getInstance().options.keyMappings = ArrayUtils.add(Minecraft.getInstance().options.keyMappings, key);
    }

    public static void registerEntityShader(Class<? extends Entity> entityClass, ResourceLocation shader) {
        entityShaderMap.put(entityClass, shader);
    }

    public static ResourceLocation getEntityShader(Class<? extends Entity> entityClass) {
        return entityShaderMap.get(entityClass);
    }
}
