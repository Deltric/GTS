package com.nickimpact.gts.entries.pixelmon;

import com.nickimpact.gts.api.exceptions.InvalidNBTException;
import com.nickimpact.gts.utils.GsonUtils;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.spongepowered.api.entity.living.player.Player;

/**
 * (Some note will go here)
 *
 * @author NickImpact
 */
public class Pokemon {

	private transient EntityPixelmon pokemon;

	private transient NBTTagCompound nbt;

	private String nbtJSON;

	public Pokemon(EntityPixelmon pokemon) {
		this.pokemon = pokemon;
		NBTTagCompound nbt = new NBTTagCompound();
		this.nbt = pokemon.writeToNBT(nbt);
		nbtJSON = GsonUtils.serialize(this.nbt);
	}

	public EntityPixelmon getPokemon(Player player) throws InvalidNBTException {
		if(this.pokemon == null) {
			try {
				this.pokemon = (EntityPixelmon) PixelmonEntityList.createEntityFromNBT(
						decode(), (World) player.getWorld()
				);
			} catch (Exception e) {
				throw new InvalidNBTException(this.nbtJSON, null);
			}
		}

		return this.pokemon;
	}

	private NBTTagCompound decode() {
		return nbt != null ? nbt : (nbt = GsonUtils.deserialize(nbtJSON));
	}
}
