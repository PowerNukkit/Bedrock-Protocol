package com.nukkitx.protocol.bedrock.v313.serializer;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.data.SoundEvent;
import com.nukkitx.protocol.bedrock.packet.LevelSoundEvent2Packet;
import com.nukkitx.protocol.bedrock.v313.BedrockUtils;
import com.nukkitx.protocol.serializer.PacketSerializer;
import com.nukkitx.protocol.util.TIntHashBiMap;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LevelSoundEvent2Serializer_v313 implements PacketSerializer<LevelSoundEvent2Packet> {
    public static final LevelSoundEvent2Serializer_v313 INSTANCE = new LevelSoundEvent2Serializer_v313();

    private static final TIntHashBiMap<SoundEvent> sounds = new TIntHashBiMap<>();

    static {
        sounds.put(0, SoundEvent.ITEM_USE_ON);
        sounds.put(1, SoundEvent.HIT);
        sounds.put(2, SoundEvent.STEP);
        sounds.put(3, SoundEvent.FLY);
        sounds.put(4, SoundEvent.JUMP);
        sounds.put(5, SoundEvent.BREAK);
        sounds.put(6, SoundEvent.PLACE);
        sounds.put(7, SoundEvent.HEAVY_STEP);
        sounds.put(8, SoundEvent.GALLOP);
        sounds.put(9, SoundEvent.FALL);
        sounds.put(10, SoundEvent.AMBIENT);
        sounds.put(11, SoundEvent.AMBIENT_BABY);
        sounds.put(12, SoundEvent.AMBIENT_IN_WATER);
        sounds.put(13, SoundEvent.BREATHE);
        sounds.put(14, SoundEvent.DEATH);
        sounds.put(15, SoundEvent.DEATH_IN_WATER);
        sounds.put(16, SoundEvent.DEATH_TO_ZOMBIE);
        sounds.put(17, SoundEvent.HURT);
        sounds.put(18, SoundEvent.HURT_IN_WATER);
        sounds.put(19, SoundEvent.MAD);
        sounds.put(20, SoundEvent.BOOST);
        sounds.put(21, SoundEvent.BOW);
        sounds.put(22, SoundEvent.SQUISH_BIG);
        sounds.put(23, SoundEvent.SQUISH_SMALL);
        sounds.put(24, SoundEvent.FALL_BIG);
        sounds.put(25, SoundEvent.FALL_SMALL);
        sounds.put(26, SoundEvent.SPLASH);
        sounds.put(27, SoundEvent.FIZZ);
        sounds.put(28, SoundEvent.FLAP);
        sounds.put(29, SoundEvent.SWIM);
        sounds.put(30, SoundEvent.DRINK);
        sounds.put(31, SoundEvent.EAT);
        sounds.put(32, SoundEvent.TAKEOFF);
        sounds.put(33, SoundEvent.SHAKE);
        sounds.put(34, SoundEvent.PLOP);
        sounds.put(35, SoundEvent.LAND);
        sounds.put(36, SoundEvent.SADDLE);
        sounds.put(37, SoundEvent.ARMOR);
        sounds.put(38, SoundEvent.MOB_ARMOR_STAND_PLACE);
        sounds.put(39, SoundEvent.ADD_CHEST);
        sounds.put(40, SoundEvent.THROW);
        sounds.put(41, SoundEvent.ATTACK);
        sounds.put(42, SoundEvent.ATTACK_NODAMAGE);
        sounds.put(43, SoundEvent.ATTACK_STRONG);
        sounds.put(44, SoundEvent.WARN);
        sounds.put(45, SoundEvent.SHEAR);
        sounds.put(46, SoundEvent.MILK);
        sounds.put(47, SoundEvent.THUNDER);
        sounds.put(48, SoundEvent.EXPLODE);
        sounds.put(49, SoundEvent.FIRE);
        sounds.put(50, SoundEvent.IGNITE);
        sounds.put(51, SoundEvent.FUSE);
        sounds.put(52, SoundEvent.STARE);
        sounds.put(53, SoundEvent.SPAWN);
        sounds.put(54, SoundEvent.SHOOT);
        sounds.put(55, SoundEvent.BREAK_BLOCK);
        sounds.put(56, SoundEvent.LAUNCH);
        sounds.put(57, SoundEvent.BLAST);
        sounds.put(58, SoundEvent.LARGE_BLAST);
        sounds.put(59, SoundEvent.TWINKLE);
        sounds.put(60, SoundEvent.REMEDY);
        sounds.put(61, SoundEvent.UNFECT);
        sounds.put(62, SoundEvent.LEVELUP);
        sounds.put(63, SoundEvent.BOW_HIT);
        sounds.put(64, SoundEvent.BULLET_HIT);
        sounds.put(65, SoundEvent.EXTINGUISH_FIRE);
        sounds.put(66, SoundEvent.ITEM_FIZZ);
        sounds.put(67, SoundEvent.CHEST_OPEN);
        sounds.put(68, SoundEvent.CHEST_CLOSED);
        sounds.put(69, SoundEvent.SHULKERBOX_OPEN);
        sounds.put(70, SoundEvent.SHULKERBOX_CLOSED);
        sounds.put(71, SoundEvent.ENDERCHEST_OPEN);
        sounds.put(72, SoundEvent.ENDERCHEST_CLOSED);
        sounds.put(73, SoundEvent.POWER_ON);
        sounds.put(74, SoundEvent.POWER_OFF);
        sounds.put(75, SoundEvent.ATTACH);
        sounds.put(76, SoundEvent.DETACH);
        sounds.put(77, SoundEvent.DENY);
        sounds.put(78, SoundEvent.TRIPOD);
        sounds.put(79, SoundEvent.POP);
        sounds.put(80, SoundEvent.DROP_SLOT);
        sounds.put(81, SoundEvent.NOTE);
        sounds.put(82, SoundEvent.THORNS);
        sounds.put(83, SoundEvent.PISTON_IN);
        sounds.put(84, SoundEvent.PISTON_OUT);
        sounds.put(85, SoundEvent.PORTAL);
        sounds.put(86, SoundEvent.WATER);
        sounds.put(87, SoundEvent.LAVA_POP);
        sounds.put(88, SoundEvent.LAVA);
        sounds.put(89, SoundEvent.BURP);
        sounds.put(90, SoundEvent.BUCKET_FILL_WATER);
        sounds.put(91, SoundEvent.BUCKET_FILL_LAVA);
        sounds.put(92, SoundEvent.BUCKET_EMPTY_WATER);
        sounds.put(93, SoundEvent.BUCKET_EMPTY_LAVA);
        sounds.put(94, SoundEvent.ARMOR_EQUIP_CHAIN);
        sounds.put(95, SoundEvent.ARMOR_EQUIP_DIAMOND);
        sounds.put(96, SoundEvent.ARMOR_EQUIP_GENERIC);
        sounds.put(97, SoundEvent.ARMOR_EQUIP_GOLD);
        sounds.put(98, SoundEvent.ARMOR_EQUIP_IRON);
        sounds.put(99, SoundEvent.ARMOR_EQUIP_LEATHER);
        sounds.put(100, SoundEvent.ARMOR_EQUIP_ELYTRA);
        sounds.put(101, SoundEvent.RECORD_13);
        sounds.put(102, SoundEvent.RECORD_CAT);
        sounds.put(103, SoundEvent.RECORD_BLOCKS);
        sounds.put(104, SoundEvent.RECORD_CHIRP);
        sounds.put(105, SoundEvent.RECORD_FAR);
        sounds.put(106, SoundEvent.RECORD_MALL);
        sounds.put(107, SoundEvent.RECORD_MELLOHI);
        sounds.put(108, SoundEvent.RECORD_STAL);
        sounds.put(109, SoundEvent.RECORD_STRAD);
        sounds.put(110, SoundEvent.RECORD_WARD);
        sounds.put(111, SoundEvent.RECORD_11);
        sounds.put(112, SoundEvent.RECORD_WAIT);
        sounds.put(113, SoundEvent.STOP_RECORD); //Not really a sound
        sounds.put(114, SoundEvent.FLOP);
        sounds.put(115, SoundEvent.ELDERGUARDIAN_CURSE);
        sounds.put(116, SoundEvent.MOB_WARNING);
        sounds.put(117, SoundEvent.MOB_WARNING_BABY);
        sounds.put(118, SoundEvent.TELEPORT);
        sounds.put(119, SoundEvent.SHULKER_OPEN);
        sounds.put(120, SoundEvent.SHULKER_CLOSE);
        sounds.put(121, SoundEvent.HAGGLE);
        sounds.put(122, SoundEvent.HAGGLE_YES);
        sounds.put(123, SoundEvent.HAGGLE_NO);
        sounds.put(124, SoundEvent.HAGGLE_IDLE);
        sounds.put(125, SoundEvent.CHORUSGROW);
        sounds.put(126, SoundEvent.CHORUSDEATH);
        sounds.put(127, SoundEvent.GLASS);
        sounds.put(128, SoundEvent.POTION_BREWED);
        sounds.put(129, SoundEvent.CAST_SPELL);
        sounds.put(130, SoundEvent.PREPARE_ATTACK);
        sounds.put(131, SoundEvent.PREPARE_SUMMON);
        sounds.put(132, SoundEvent.PREPARE_WOLOLO);
        sounds.put(133, SoundEvent.FANG);
        sounds.put(134, SoundEvent.CHARGE);
        sounds.put(135, SoundEvent.CAMERA_TAKE_PICTURE);
        sounds.put(136, SoundEvent.LEASHKNOT_PLACE);
        sounds.put(137, SoundEvent.LEASHKNOT_BREAK);
        sounds.put(138, SoundEvent.GROWL);
        sounds.put(139, SoundEvent.WHINE);
        sounds.put(140, SoundEvent.PANT);
        sounds.put(141, SoundEvent.PURR);
        sounds.put(142, SoundEvent.PURREOW);
        sounds.put(143, SoundEvent.DEATH_MIN_VOLUME);
        sounds.put(144, SoundEvent.DEATH_MID_VOLUME);
        sounds.put(145, SoundEvent.IMITATE_BLAZE);
        sounds.put(146, SoundEvent.IMITATE_CAVE_SPIDER);
        sounds.put(147, SoundEvent.IMITATE_CREEPER);
        sounds.put(148, SoundEvent.IMITATE_ELDER_GUARDIAN);
        sounds.put(149, SoundEvent.IMITATE_ENDER_DRAGON);
        sounds.put(150, SoundEvent.IMITATE_ENDERMAN);
        sounds.put(152, SoundEvent.IMITATE_EVOCATION_ILLAGER);
        sounds.put(153, SoundEvent.IMITATE_GHAST);
        sounds.put(154, SoundEvent.IMITATE_HUSK);
        sounds.put(155, SoundEvent.IMITATE_ILLUSION_ILLAGER);
        sounds.put(156, SoundEvent.IMITATE_MAGMA_CUBE);
        sounds.put(157, SoundEvent.IMITATE_POLAR_BEAR);
        sounds.put(158, SoundEvent.IMITATE_SHULKER);
        sounds.put(159, SoundEvent.IMITATE_SILVERFISH);
        sounds.put(160, SoundEvent.IMITATE_SKELETON);
        sounds.put(161, SoundEvent.IMITATE_SLIME);
        sounds.put(162, SoundEvent.IMITATE_SPIDER);
        sounds.put(163, SoundEvent.IMITATE_STRAY);
        sounds.put(164, SoundEvent.IMITATE_VEX);
        sounds.put(165, SoundEvent.IMITATE_VINDICATION_ILLAGER);
        sounds.put(166, SoundEvent.IMITATE_WITCH);
        sounds.put(167, SoundEvent.IMITATE_WITHER);
        sounds.put(168, SoundEvent.IMITATE_WITHER_SKELETON);
        sounds.put(169, SoundEvent.IMITATE_WOLF);
        sounds.put(170, SoundEvent.IMITATE_ZOMBIE);
        sounds.put(171, SoundEvent.IMITATE_ZOMBIE_PIGMAN);
        sounds.put(172, SoundEvent.IMITATE_ZOMBIE_VILLAGER);
        sounds.put(173, SoundEvent.BLOCK_END_PORTAL_FRAME_FILL);
        sounds.put(174, SoundEvent.BLOCK_END_PORTAL_SPAWN);
        sounds.put(175, SoundEvent.RANDOM_ANVIL_USE);
        sounds.put(176, SoundEvent.BOTTLE_DRAGONBREATH);
        sounds.put(177, SoundEvent.PORTAL_TRAVEL);
        sounds.put(178, SoundEvent.ITEM_TRIDENT_HIT);
        sounds.put(179, SoundEvent.ITEM_TRIDENT_RETURN);
        sounds.put(180, SoundEvent.ITEM_TRIDENT_RIPTIDE_1);
        sounds.put(181, SoundEvent.ITEM_TRIDENT_RIPTIDE_2);
        sounds.put(182, SoundEvent.ITEM_TRIDENT_RIPTIDE_3);
        sounds.put(183, SoundEvent.ITEM_TRIDENT_THROW);
        sounds.put(184, SoundEvent.ITEM_TRIDENT_THUNDER);
        sounds.put(185, SoundEvent.ITEM_TRIDENT_HIT_GROUND);
        sounds.put(186, SoundEvent.DEFAULT);
        sounds.put(188, SoundEvent.ELEMCONSTRUCT_OPEN);
        sounds.put(189, SoundEvent.ICEBOMB_HIT);
        sounds.put(190, SoundEvent.BALLOONPOP);
        sounds.put(191, SoundEvent.LT_REACTION_ICEBOMB);
        sounds.put(192, SoundEvent.LT_REACTION_BLEACH);
        sounds.put(193, SoundEvent.LT_REACTION_EPASTE);
        sounds.put(194, SoundEvent.LT_REACTION_EPASTE2);
        sounds.put(199, SoundEvent.LT_REACTION_FERTILIZER);
        sounds.put(200, SoundEvent.LT_REACTION_FIREBALL);
        sounds.put(201, SoundEvent.LT_REACTION_MGSALT);
        sounds.put(202, SoundEvent.LT_REACTION_MISCFIRE);
        sounds.put(203, SoundEvent.LT_REACTION_FIRE);
        sounds.put(204, SoundEvent.LT_REACTION_MISCEXPLOSION);
        sounds.put(205, SoundEvent.LT_REACTION_MISCMYSTICAL);
        sounds.put(206, SoundEvent.LT_REACTION_MISCMYSTICAL2);
        sounds.put(207, SoundEvent.LT_REACTION_PRODUCT);
        sounds.put(208, SoundEvent.SPARKLER_USE);
        sounds.put(209, SoundEvent.GLOWSTICK_USE);
        sounds.put(210, SoundEvent.SPARKLER_ACTIVE);
        sounds.put(211, SoundEvent.CONVERT_TO_DROWNED);
        sounds.put(212, SoundEvent.BUCKET_FILL_FISH);
        sounds.put(213, SoundEvent.BUCKET_EMPTY_FISH);
        sounds.put(214, SoundEvent.UNDEFINED);
    }

    @Override
    public void serialize(ByteBuf buffer, LevelSoundEvent2Packet packet) {
        buffer.writeByte(sounds.get(packet.getSound()));
        BedrockUtils.writeVector3f(buffer, packet.getPosition());
        VarInts.writeInt(buffer, packet.getExtraData());
        BedrockUtils.writeString(buffer, packet.getIdentifier());
        buffer.writeBoolean(packet.isBabySound());
        buffer.writeBoolean(packet.isRelativeVolumeDisabled());
    }

    @Override
    public void deserialize(ByteBuf buffer, LevelSoundEvent2Packet packet) {
        packet.setSound(sounds.get(buffer.readUnsignedByte()));
        packet.setPosition(BedrockUtils.readVector3f(buffer));
        packet.setExtraData(VarInts.readInt(buffer));
        packet.setIdentifier(BedrockUtils.readString(buffer));
        packet.setBabySound(buffer.readBoolean());
        packet.setRelativeVolumeDisabled(buffer.readBoolean());
    }
}
