package dev.l2j.tesla.gameserver.handler.chathandlers;

import dev.l2j.tesla.gameserver.handler.IChatHandler;
import dev.l2j.tesla.gameserver.network.serverpackets.CreatureSay;
import dev.l2j.tesla.gameserver.model.actor.Player;

public class ChatClan implements IChatHandler
{
	private static final int[] COMMAND_IDS =
	{
		4
	};
	
	@Override
	public void handleChat(int type, Player activeChar, String target, String text)
	{
		if (activeChar.getClan() == null)
			return;
		
		activeChar.getClan().broadcastToOnlineMembers(new CreatureSay(activeChar.getObjectId(), type, activeChar.getName(), text));
	}
	
	@Override
	public int[] getChatTypeList()
	{
		return COMMAND_IDS;
	}
}