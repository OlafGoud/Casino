package git.olafgoud.casino.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateItem {
	private ItemStack item;
	
	//constructers
	public CreateItem(Material mat) {
		this.item = new ItemStack(mat);
	}
	
	
	public CreateItem(Material mat, int bit) {
		this.item = new ItemStack(mat, 1 , (byte) bit);
	}
	
	
	public CreateItem(ItemStack stack) {
		this.item = stack;
	}
	

	//name
	public CreateItem setName(String name) {
		ItemMeta meta = this.item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		this.item.setItemMeta(meta);
		return this;
	}
	
	
	//type of material
	public CreateItem setType(Material mat) {
		item.setType(mat);
		return this;
	}
	
	//lore
	public CreateItem setLore(String... lore) {
		ItemMeta meta = this.item.getItemMeta();
		List<String> lores = new ArrayList<>();
		for (String s : lore) {
			lores.add(ChatColor.translateAlternateColorCodes('&', s));
		}
		meta.setLore(lores);
		
		this.item.setItemMeta(meta);
		return this;

	}
	
	public CreateItem setLore(ArrayList<String> lore) {
		ItemMeta meta = this.item.getItemMeta();
		meta.setLore(lore);
		
		this.item.setItemMeta(meta);
		return this;

	}
	
	//nbt
	public String getStringValue(String key) {
		if(!NBTEditor.contains(this.item, key)) {
			return "";
		}
		return NBTEditor.getString(key, this.item);
	}
	
	
	public CreateItem setKey(String key, String value) {
		this.item = NBTEditor.set(this.item, value, key);
		return this;

	}
	
	public CreateItem setUnbreakable(boolean unbreakable) {
		this.item = NBTEditor.set(this.item, unbreakable, "Unbreakable");
		return this;

	}
	
	public CreateItem setAmount(Integer amount) {
		this.item.setAmount(amount);
		return this;
	}
	
	public CreateItem setDurability(Integer amount) {
		this.item.setDurability(amount.shortValue());
		return this;
	}
	
	public ItemStack getItem() { 
		return this.item;
	}
	
	
	
}

