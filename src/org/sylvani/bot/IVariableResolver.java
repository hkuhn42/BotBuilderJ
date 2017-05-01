package org.sylvani.bot;

public interface IVariableResolver {

	String resolveVariables(String text, ISession session);

}