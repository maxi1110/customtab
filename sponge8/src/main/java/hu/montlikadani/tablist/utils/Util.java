package hu.montlikadani.tablist.utils;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.scoreboard.Scoreboard;

public final class Util {

	public static final Scoreboard GLOBAL_SCORE_BOARD = getNewScoreboard();

	private Util() {
	}

	public static Scoreboard getNewScoreboard() {
		return Sponge.game().server().serverScoreboard()
				.orElseThrow(() -> new IllegalStateException("Server does not have a valid scoreboard"));
	}
}
