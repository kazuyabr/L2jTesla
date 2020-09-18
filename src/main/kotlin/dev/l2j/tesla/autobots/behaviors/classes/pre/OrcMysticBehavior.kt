package dev.l2j.tesla.autobots.behaviors.classes.pre

import dev.l2j.tesla.autobots.behaviors.CombatBehavior
import dev.l2j.tesla.autobots.behaviors.attributes.SecretManaRegen
import dev.l2j.tesla.autobots.behaviors.preferences.CombatPreferences
import dev.l2j.tesla.autobots.behaviors.preferences.SkillPreferences
import dev.l2j.tesla.autobots.skills.BotSkill
import dev.l2j.tesla.gameserver.enums.items.ShotType
import dev.l2j.tesla.gameserver.model.actor.Player


internal class OrcMysticBehavior(player: Player, combatPreferences: CombatPreferences) : CombatBehavior(player, combatPreferences),
    SecretManaRegen {
    override var skillPreferences: SkillPreferences =
        SkillPreferences(player.level >= 7)

    override fun getShotType(): ShotType {
        return ShotType.BLESSED_SPIRITSHOT
    }

    override val getOffensiveSkills: List<BotSkill> = listOf(
            BotSkill(1090))

    override fun onLevelUp(oldLevel: Int, newLevel: Int) {
        if(player.level >= 7) {
            skillPreferences.isSkillsOnly = true
        }
    }

    override val conditionalSkills: List<Int> = emptyList()
}