package dev.l2j.tesla.gameserver.model.zone.type;

import dev.l2j.tesla.gameserver.model.actor.Creature;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.zone.ZoneType;
import dev.l2j.tesla.gameserver.enums.ZoneId;

/**
 * A zone extending {@link ZoneType} where 'Build Headquarters' is allowed.
 */
public class HqZone extends ZoneType
{
	public HqZone(final int id)
	{
		super(id);
	}
	
	@Override
	protected void onEnter(final Creature character)
	{
		if (character instanceof Player)
			character.setInsideZone(ZoneId.HQ, true);
	}
	
	@Override
	protected void onExit(final Creature character)
	{
		if (character instanceof Player)
			character.setInsideZone(ZoneId.HQ, false);
	}
}