/**
 *    Copyright (C) 2016-2017 Harald Kuhn
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
/**
 * 
 */
package org.sylvani.bot.universal;

import java.io.FileInputStream;
import java.io.IOException;

import org.sylvani.bot.BotConfig;
import org.sylvani.bot.IKnowThisIsWrongCrypt;
import org.sylvani.bot.InMemoryActivityArchive;
import org.sylvani.bot.InMemorySessionStore;
import org.sylvani.bot.recognize.CommandRecognizer;
import org.sylvani.bot.resolver.mustache.MustacheVariableResolver;

/**
 * @author Harald Kuhn
 *
 */
public class UniversalBotConfig extends BotConfig {

	public UniversalBotConfig() throws IOException {
		try (FileInputStream stream = new FileInputStream("Bot.properties")) {
			properties.load(stream);
		}
		crypt = new IKnowThisIsWrongCrypt();
		recognizer = new CommandRecognizer();
		resolver = new MustacheVariableResolver();
		sessionStore = new InMemorySessionStore();
		archive = new InMemoryActivityArchive();
	}

}
