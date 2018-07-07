package com.w00tmast3r.skquery.elements.conditions;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Checker;
import ch.njol.util.Kleenean;
import com.w00tmast3r.skquery.api.Patterns;
import org.bukkit.event.Event;

@Patterns("%boolean%")
public class CondBoolean extends Condition {

	private Expression<Boolean> condition;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
		condition = (Expression<Boolean>) exprs[0];
		return true;
	}
	
	@Override
	public boolean check(Event event) {
		return condition.check(event, new Checker<Boolean>() {
			@Override
			public boolean check(Boolean o) {
				return o;
			}
		});
	}
	
	@Override
	public String toString(Event e, boolean debug) {
		return "Boolean condition";
	}
}
