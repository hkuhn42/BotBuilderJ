/**
 * 
 */
package org.sylvani.bot.util;

/**
 * Enum for channels
 * 
 * @author Harald Kuhn
 *
 */
public enum Channel {

	FACEBOOK("facyebook"),

	SYKPE("skype"),

	TELEGRAM("telegram"),

	KIK("kik"),

	EMAIL("email"),

	SLACK("slack"),

	GROUPME("groupme"),

	SMS("sms"),

	EMULATOR("emulator"),

	DIRECTLINE("directline"),

	CONSOLE("console");

	private String id;

	Channel(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id;
	}

	public boolean supportsKeyboards(Channel channel) {
		return supportsKeyboards(channel, 100);
	}

	/**
	 * 
	 * case channels.facebook: return (buttonCnt <= 10); case channels.kik: return (buttonCnt <= 20); case
	 * channels.slack: case channels.telegram: case channels.emulator: return (buttonCnt <= 100); default: return false;
	 */
	public boolean supportsKeyboards(Channel channel, int buttonCnt) {
		boolean supportsKeyboards = false;
		switch (channel) {
			case FACEBOOK:
				supportsKeyboards = (buttonCnt <= 10);
				break;
			case KIK:
				supportsKeyboards = (buttonCnt <= 20);
				break;
			case TELEGRAM:
			case EMULATOR:
				supportsKeyboards = (buttonCnt <= 100);
				break;
			default:
				break;

		}
		return supportsKeyboards;
	}

	/*
	 * export function supportsCardActions(session: Session, buttonCnt = 100) { switch (getChannelId(session)) { case
	 * channels.facebook: case channels.skype: return (buttonCnt <= 3); case channels.slack: return (buttonCnt <= 100);
	 * default: return false; } }
	 * 
	 */
	public boolean supportsCardActions(Channel channel) {
		return supportsCardActions(channel, 100);
	}

	public boolean supportsCardActions(Channel channel, int cardCnt) {
		boolean supportsCardActions = false;
		switch (channel) {
			case FACEBOOK:
			case SYKPE:
				supportsCardActions = (cardCnt <= 3);
				break;
			case SLACK:
				supportsCardActions = (cardCnt <= 100);
			default:
				break;
		}
		return supportsCardActions;
	}

}
