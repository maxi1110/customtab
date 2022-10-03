package hu.montlikadani.tablist.utils.variables;
package com.sn1cko.tablist.methods;

import java.time.Instant;
import java.util.function.BiConsumer;
import com.sn1cko.tablist.tablist;
import com.sn1cko.tablist.vars;
import java.text.DecimalFormat;
import java.util.Calendar;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

final class Variable {

	public final String name, fullName;
	public final transient BiConsumer<Variable, String> consumer;

	private final int refreshSeconds;

	private transient Instant rateInstant;

	private String remainingValue;

	public Variable(String name, int refreshSeconds, BiConsumer<Variable, String> consumer) {
		this.name = name;
		this.consumer = consumer;
		this.refreshSeconds = refreshSeconds;

		fullName = '%' + name + '%';
	}

	public String getRemainingValue() {
		return remainingValue;
	}

	public String remainingValue(String remainingValue) {
		return this.remainingValue = remainingValue;
	}

	public boolean canReplace(String str) {
		if (rateInstant != null && rateInstant.isAfter(Instant.now())) {
			return false;
		}

		if (str.indexOf(fullName) != -1) {
			rateInstant = Instant.now().plusSeconds(refreshSeconds);
			return true;
		}

		return false;
	}
}
