package com.extendedclip.papi.expansion.daddy.daddyexpansion;

import com.google.common.collect.Lists;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;

public final class DaddyExpansion extends PlaceholderExpansion {

  private final String VERSION = getClass().getPackage().getImplementationVersion();

  @Override
  public String getIdentifier() {
    return "daddy";
  }

  @Override
  public String getAuthor() {
    return "clip";
  }

  @Override
  public String getVersion() {
    return VERSION;
  }

  @Override
  public boolean register() {
    CommandMap map = null;
    try {
      final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
      f.setAccessible(true);
      map = (CommandMap) f.get(Bukkit.getServer());
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (map == null) return false;
    Command c = map.getCommand("placeholderapi");
    if (c == null) return false;
    c.unregister(map);
    c.setAliases(Lists.newArrayList("daddy", "papi"));
    map.register("placeholderapi", "father", c);
    getPlaceholderAPI().getLogger().info("Daddy is back!");
    return super.register();
  }

  @Override
  public String onRequest(OfflinePlayer p, String identifier) {
    return null;
  }

}
