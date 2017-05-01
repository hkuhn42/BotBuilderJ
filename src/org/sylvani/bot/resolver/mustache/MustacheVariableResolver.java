/**
 * 
 */
package org.sylvani.bot.resolver.mustache;

import java.io.StringReader;
import java.io.StringWriter;

import org.sylvani.bot.ISession;
import org.sylvani.bot.IVariableResolver;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

/**
 * A see https://github.com/spullara/mustache.java
 * 
 * @author Harald Kuhn
 *
 */
public class MustacheVariableResolver implements IVariableResolver {

	/* (non-Javadoc)
	 * @see org.sylvani.bot.resolver.twig.IVariableResolver#resolveVariables(java.lang.String, org.sylvani.bot.ISession)
	 */
	@Override
	public String resolveVariables(String text, ISession session) {

		StringWriter writer = new StringWriter();
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile(new StringReader(text), text);
		mustache.execute(writer, session.asAttributeMap());
		writer.flush();
		return writer.toString();
	}

}
