package net.minecraft.world.storage;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.mojang.datafixers.DataFixer;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.Lifecycle;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.command.TimerCallbackManager;
import net.minecraft.command.TimerCallbackSerializers;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.StringNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.UUIDCodec;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.DefaultTypeReferences;
import net.minecraft.util.datafix.codec.DatapackCodec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.WorldGenSettingsExport;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerWorldInfo implements IServerWorldInfo, IServerConfiguration
{
    private static final Logger LOGGER = LogManager.getLogger();
    private WorldSettings worldSettings;
    private final DimensionGeneratorSettings generatorSettings;
    private final Lifecycle lifecycle;
    private int spawnX;
    private int spawnY;
    private int spawnZ;
    private float field_242984_h;
    private long gameTime;
    private long dayTime;
    @Nullable
    private final DataFixer dataFixer;
    private final int version;
    private boolean dataFixed;
    @Nullable
    private CompoundNBT loadedPlayerNBT;
    private final int levelStorageVersion;
    private int clearWeatherTime;
    private boolean raining;
    private int rainTime;
    private boolean thundering;
    private int thunderTime;
    private boolean initialized;
    private boolean difficultyLocked;
    private WorldBorder.Serializer borderSerializer;
    private CompoundNBT dragonFightNBT;
    @Nullable
    private CompoundNBT customBossEventNBT;
    private int wanderingTraderSpawnDelay;
    private int wanderingTraderSpawnChance;
    @Nullable
    private UUID wanderingTraderID;
    private final Set<String> serverBrands;
    private boolean wasModded;
    private final TimerCallbackManager<MinecraftServer> schedueledEvents;

    private ServerWorldInfo(@Nullable DataFixer p_i242043_1_, int p_i242043_2_, @Nullable CompoundNBT p_i242043_3_, boolean p_i242043_4_, int p_i242043_5_, int p_i242043_6_, int p_i242043_7_, float p_i242043_8_, long p_i242043_9_, long p_i242043_11_, int p_i242043_13_, int p_i242043_14_, int p_i242043_15_, boolean p_i242043_16_, int p_i242043_17_, boolean p_i242043_18_, boolean p_i242043_19_, boolean p_i242043_20_, WorldBorder.Serializer p_i242043_21_, int p_i242043_22_, int p_i242043_23_, @Nullable UUID p_i242043_24_, LinkedHashSet<String> p_i242043_25_, TimerCallbackManager<MinecraftServer> p_i242043_26_, @Nullable CompoundNBT p_i242043_27_, CompoundNBT p_i242043_28_, WorldSettings p_i242043_29_, DimensionGeneratorSettings p_i242043_30_, Lifecycle p_i242043_31_)
    {
        this.dataFixer = p_i242043_1_;
        this.wasModded = p_i242043_4_;
        this.spawnX = p_i242043_5_;
        this.spawnY = p_i242043_6_;
        this.spawnZ = p_i242043_7_;
        this.field_242984_h = p_i242043_8_;
        this.gameTime = p_i242043_9_;
        this.dayTime = p_i242043_11_;
        this.levelStorageVersion = p_i242043_13_;
        this.clearWeatherTime = p_i242043_14_;
        this.rainTime = p_i242043_15_;
        this.raining = p_i242043_16_;
        this.thunderTime = p_i242043_17_;
        this.thundering = p_i242043_18_;
        this.initialized = p_i242043_19_;
        this.difficultyLocked = p_i242043_20_;
        this.borderSerializer = p_i242043_21_;
        this.wanderingTraderSpawnDelay = p_i242043_22_;
        this.wanderingTraderSpawnChance = p_i242043_23_;
        this.wanderingTraderID = p_i242043_24_;
        this.serverBrands = p_i242043_25_;
        this.loadedPlayerNBT = p_i242043_3_;
        this.version = p_i242043_2_;
        this.schedueledEvents = p_i242043_26_;
        this.customBossEventNBT = p_i242043_27_;
        this.dragonFightNBT = p_i242043_28_;
        this.worldSettings = p_i242043_29_;
        this.generatorSettings = p_i242043_30_;
        this.lifecycle = p_i242043_31_;
    }

    public ServerWorldInfo(WorldSettings worldSettings, DimensionGeneratorSettings generatorSettings, Lifecycle lifecycle)
    {
        this((DataFixer)null, SharedConstants.getVersion().getWorldVersion(), (CompoundNBT)null, false, 0, 0, 0, 0.0F, 0L, 0L, 19133, 0, 0, false, 0, false, false, false, WorldBorder.field_235925_b_, 0, 0, (UUID)null, Sets.newLinkedHashSet(), new TimerCallbackManager<>(TimerCallbackSerializers.field_216342_a), (CompoundNBT)null, new CompoundNBT(), worldSettings.clone(), generatorSettings, lifecycle);
    }

    public static ServerWorldInfo decodeWorldInfo(Dynamic<INBT> dynamic, DataFixer dataFixer, int version, @Nullable CompoundNBT playerNBT, WorldSettings worldSettings, VersionData versionData, DimensionGeneratorSettings generatorSettings, Lifecycle lifecycle)
    {
        long i = dynamic.get("Time").asLong(0L);
        CompoundNBT compoundnbt = (CompoundNBT)dynamic.get("DragonFight").result().map(Dynamic::getValue).orElseGet(() ->
        {
            return dynamic.get("DimensionData").get("1").get("DragonFight").orElseEmptyMap().getValue();
        });
        return new ServerWorldInfo(dataFixer, version, playerNBT, dynamic.get("WasModded").asBoolean(false), dynamic.get("SpawnX").asInt(0), dynamic.get("SpawnY").asInt(0), dynamic.get("SpawnZ").asInt(0), dynamic.get("SpawnAngle").asFloat(0.0F), i, dynamic.get("DayTime").asLong(i), versionData.getStorageVersionID(), dynamic.get("clearWeatherTime").asInt(0), dynamic.get("rainTime").asInt(0), dynamic.get("raining").asBoolean(false), dynamic.get("thunderTime").asInt(0), dynamic.get("thundering").asBoolean(false), dynamic.get("initialized").asBoolean(true), dynamic.get("DifficultyLocked").asBoolean(false), WorldBorder.Serializer.func_235938_a_(dynamic, WorldBorder.field_235925_b_), dynamic.get("WanderingTraderSpawnDelay").asInt(0), dynamic.get("WanderingTraderSpawnChance").asInt(0), dynamic.get("WanderingTraderId").read(UUIDCodec.CODEC).result().orElse((UUID)null), dynamic.get("ServerBrands").asStream().flatMap((nbt) ->
        {
            return Util.streamOptional(nbt.asString().result());
        }).collect(Collectors.toCollection(Sets::newLinkedHashSet)), new TimerCallbackManager<>(TimerCallbackSerializers.field_216342_a, dynamic.get("ScheduledEvents").asStream()), (CompoundNBT)dynamic.get("CustomBossEvents").orElseEmptyMap().getValue(), compoundnbt, worldSettings, generatorSettings, lifecycle);
    }

    public CompoundNBT serialize(DynamicRegistries registries, @Nullable CompoundNBT hostPlayerNBT)
    {
        this.updatePlayerData();

        if (hostPlayerNBT == null)
        {
            hostPlayerNBT = this.loadedPlayerNBT;
        }

        CompoundNBT compoundnbt = new CompoundNBT();
        this.serialize(registries, compoundnbt, hostPlayerNBT);
        return compoundnbt;
    }

    private void serialize(DynamicRegistries registry, CompoundNBT nbt, @Nullable CompoundNBT playerNBT)
    {
        ListNBT listnbt = new ListNBT();
        this.serverBrands.stream().map(StringNBT::valueOf).forEach(listnbt::add);
        nbt.put("ServerBrands", listnbt);
        nbt.putBoolean("WasModded", this.wasModded);
        CompoundNBT compoundnbt = new CompoundNBT();
        compoundnbt.putString("Name", SharedConstants.getVersion().getName());
        compoundnbt.putInt("Id", SharedConstants.getVersion().getWorldVersion());
        compoundnbt.putBoolean("Snapshot", !SharedConstants.getVersion().isStable());
        nbt.put("Version", compoundnbt);
        nbt.putInt("DataVersion", SharedConstants.getVersion().getWorldVersion());
        WorldGenSettingsExport<INBT> worldgensettingsexport = WorldGenSettingsExport.func_240896_a_(NBTDynamicOps.INSTANCE, registry);
        DimensionGeneratorSettings.field_236201_a_.encodeStart(worldgensettingsexport, this.generatorSettings).resultOrPartial(Util.func_240982_a_("WorldGenSettings: ", LOGGER::error)).ifPresent((worldSettingsNBT) ->
        {
            nbt.put("WorldGenSettings", worldSettingsNBT);
        });
        nbt.putInt("GameType", this.worldSettings.getGameType().getID());
        nbt.putInt("SpawnX", this.spawnX);
        nbt.putInt("SpawnY", this.spawnY);
        nbt.putInt("SpawnZ", this.spawnZ);
        nbt.putFloat("SpawnAngle", this.field_242984_h);
        nbt.putLong("Time", this.gameTime);
        nbt.putLong("DayTime", this.dayTime);
        nbt.putLong("LastPlayed", Util.millisecondsSinceEpoch());
        nbt.putString("LevelName", this.worldSettings.getWorldName());
        nbt.putInt("version", 19133);
        nbt.putInt("clearWeatherTime", this.clearWeatherTime);
        nbt.putInt("rainTime", this.rainTime);
        nbt.putBoolean("raining", this.raining);
        nbt.putInt("thunderTime", this.thunderTime);
        nbt.putBoolean("thundering", this.thundering);
        nbt.putBoolean("hardcore", this.worldSettings.isHardcoreEnabled());
        nbt.putBoolean("allowCommands", this.worldSettings.isCommandsAllowed());
        nbt.putBoolean("initialized", this.initialized);
        this.borderSerializer.func_235939_a_(nbt);
        nbt.putByte("Difficulty", (byte)this.worldSettings.getDifficulty().getId());
        nbt.putBoolean("DifficultyLocked", this.difficultyLocked);
        nbt.put("GameRules", this.worldSettings.getGameRules().write());
        nbt.put("DragonFight", this.dragonFightNBT);

        if (playerNBT != null)
        {
            nbt.put("Player", playerNBT);
        }

        DatapackCodec.field_234881_b_.encodeStart(NBTDynamicOps.INSTANCE, this.worldSettings.getDatapackCodec()).result().ifPresent((dataPacksNBT) ->
        {
            nbt.put("DataPacks", dataPacksNBT);
        });

        if (this.customBossEventNBT != null)
        {
            nbt.put("CustomBossEvents", this.customBossEventNBT);
        }

        nbt.put("ScheduledEvents", this.schedueledEvents.write());
        nbt.putInt("WanderingTraderSpawnDelay", this.wanderingTraderSpawnDelay);
        nbt.putInt("WanderingTraderSpawnChance", this.wanderingTraderSpawnChance);

        if (this.wanderingTraderID != null)
        {
            nbt.putUniqueId("WanderingTraderId", this.wanderingTraderID);
        }
    }

    public int getSpawnX()
    {
        return this.spawnX;
    }

    public int getSpawnY()
    {
        return this.spawnY;
    }

    public int getSpawnZ()
    {
        return this.spawnZ;
    }

    public float func_241860_d()
    {
        return this.field_242984_h;
    }

    public long getGameTime()
    {
        return this.gameTime;
    }

    public long getDayTime()
    {
        return this.dayTime;
    }

    private void updatePlayerData()
    {
        if (!this.dataFixed && this.loadedPlayerNBT != null)
        {
            if (this.version < SharedConstants.getVersion().getWorldVersion())
            {
                if (this.dataFixer == null)
                {
                    throw(NullPointerException)Util.pauseDevMode(new NullPointerException("Fixer Upper not set inside LevelData, and the player tag is not upgraded."));
                }

                this.loadedPlayerNBT = NBTUtil.update(this.dataFixer, DefaultTypeReferences.PLAYER, this.loadedPlayerNBT, this.version);
            }

            this.dataFixed = true;
        }
    }

    public CompoundNBT getHostPlayerNBT()
    {
        this.updatePlayerData();
        return this.loadedPlayerNBT;
    }

    public void setSpawnX(int x)
    {
        this.spawnX = x;
    }

    public void setSpawnY(int y)
    {
        this.spawnY = y;
    }

    public void setSpawnZ(int z)
    {
        this.spawnZ = z;
    }

    public void func_241859_a(float p_241859_1_)
    {
        this.field_242984_h = p_241859_1_;
    }

    public void setGameTime(long time)
    {
        this.gameTime = time;
    }

    public void setDayTime(long time)
    {
        this.dayTime = time;
    }

    public void setSpawn(BlockPos spawnPoint, float p_176143_2_)
    {
        this.spawnX = spawnPoint.getX();
        this.spawnY = spawnPoint.getY();
        this.spawnZ = spawnPoint.getZ();
        this.field_242984_h = p_176143_2_;
    }

    public String getWorldName()
    {
        return this.worldSettings.getWorldName();
    }

    public int getStorageVersionId()
    {
        return this.levelStorageVersion;
    }

    public int getClearWeatherTime()
    {
        return this.clearWeatherTime;
    }

    public void setClearWeatherTime(int time)
    {
        this.clearWeatherTime = time;
    }

    public boolean isThundering()
    {
        return this.thundering;
    }

    public void setThundering(boolean thunderingIn)
    {
        this.thundering = thunderingIn;
    }

    public int getThunderTime()
    {
        return this.thunderTime;
    }

    public void setThunderTime(int time)
    {
        this.thunderTime = time;
    }

    public boolean isRaining()
    {
        return this.raining;
    }

    public void setRaining(boolean isRaining)
    {
        this.raining = isRaining;
    }

    public int getRainTime()
    {
        return this.rainTime;
    }

    public void setRainTime(int time)
    {
        this.rainTime = time;
    }

    public GameType getGameType()
    {
        return this.worldSettings.getGameType();
    }

    public void setGameType(GameType type)
    {
        this.worldSettings = this.worldSettings.setGameType(type);
    }

    public boolean isHardcore()
    {
        return this.worldSettings.isHardcoreEnabled();
    }

    public boolean areCommandsAllowed()
    {
        return this.worldSettings.isCommandsAllowed();
    }

    public boolean isInitialized()
    {
        return this.initialized;
    }

    public void setInitialized(boolean initializedIn)
    {
        this.initialized = initializedIn;
    }

    public GameRules getGameRulesInstance()
    {
        return this.worldSettings.getGameRules();
    }

    public WorldBorder.Serializer getWorldBorderSerializer()
    {
        return this.borderSerializer;
    }

    public void setWorldBorderSerializer(WorldBorder.Serializer serializer)
    {
        this.borderSerializer = serializer;
    }

    public Difficulty getDifficulty()
    {
        return this.worldSettings.getDifficulty();
    }

    public void setDifficulty(Difficulty difficulty)
    {
        this.worldSettings = this.worldSettings.setDifficulty(difficulty);
    }

    public boolean isDifficultyLocked()
    {
        return this.difficultyLocked;
    }

    public void setDifficultyLocked(boolean locked)
    {
        this.difficultyLocked = locked;
    }

    public TimerCallbackManager<MinecraftServer> getScheduledEvents()
    {
        return this.schedueledEvents;
    }

    public void addToCrashReport(CrashReportCategory category)
    {
        IServerWorldInfo.super.addToCrashReport(category);
        IServerConfiguration.super.addToCrashReport(category);
    }

    public DimensionGeneratorSettings getDimensionGeneratorSettings()
    {
        return this.generatorSettings;
    }

    public Lifecycle getLifecycle()
    {
        return this.lifecycle;
    }

    public CompoundNBT getDragonFightData()
    {
        return this.dragonFightNBT;
    }

    public void setDragonFightData(CompoundNBT nbt)
    {
        this.dragonFightNBT = nbt;
    }

    public DatapackCodec getDatapackCodec()
    {
        return this.worldSettings.getDatapackCodec();
    }

    public void setDatapackCodec(DatapackCodec codec)
    {
        this.worldSettings = this.worldSettings.setDatapackCodec(codec);
    }

    @Nullable
    public CompoundNBT getCustomBossEventData()
    {
        return this.customBossEventNBT;
    }

    public void setCustomBossEventData(@Nullable CompoundNBT nbt)
    {
        this.customBossEventNBT = nbt;
    }

    public int getWanderingTraderSpawnDelay()
    {
        return this.wanderingTraderSpawnDelay;
    }

    public void setWanderingTraderSpawnDelay(int delay)
    {
        this.wanderingTraderSpawnDelay = delay;
    }

    public int getWanderingTraderSpawnChance()
    {
        return this.wanderingTraderSpawnChance;
    }

    public void setWanderingTraderSpawnChance(int chance)
    {
        this.wanderingTraderSpawnChance = chance;
    }

    public void setWanderingTraderID(UUID id)
    {
        this.wanderingTraderID = id;
    }

    public void addServerBranding(String name, boolean isModded)
    {
        this.serverBrands.add(name);
        this.wasModded |= isModded;
    }

    public boolean isModded()
    {
        return this.wasModded;
    }

    public Set<String> getServerBranding()
    {
        return ImmutableSet.copyOf(this.serverBrands);
    }

    public IServerWorldInfo getServerWorldInfo()
    {
        return this;
    }

    public WorldSettings getWorldSettings()
    {
        return this.worldSettings.clone();
    }
}
