/**
 * 
 */
package org.sylvani.bot.connector;

import org.sylvani.bot.IParticipant;

/**
 * @author Harald Kuhn
 *
 */
public class GenericParticipant implements IParticipant {

	private String id;
	private String name;

	public GenericParticipant() {
		super();
	}

	public GenericParticipant(String id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IParticipant#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IParticipant#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IParticipant#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IParticipant#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
}
