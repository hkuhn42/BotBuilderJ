package org.sylvani.bot.interceptors;

import org.sylvani.bot.IHandler;
import org.sylvani.bot.IInterceptor;

/**
 * Base class for interceptors which handles the chain
 * 
 * @author Harald Kuhn
 *
 */
public abstract class InterceptorBase implements IInterceptor {

	protected IHandler nextInChain;

	public InterceptorBase() {
		super();
	}

	@Override
	public void init(IHandler nextInChain) {
		this.nextInChain = nextInChain;
	}

}