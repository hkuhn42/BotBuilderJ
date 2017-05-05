/**
 * 
 */
package org.sylvani.bot;

/**
 * An interceptor / filter for incoming Activities
 * 
 * Interceptors must throw a NullPointerException if init is not called once before handle
 * 
 * @author hkuhn
 */
public interface IInterceptor extends IHandler {

	public void init(IHandler nextInChain);

}
