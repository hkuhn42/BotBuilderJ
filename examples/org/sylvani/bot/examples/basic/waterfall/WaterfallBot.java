/**
 * 
 */
package org.sylvani.bot.examples.basic.waterfall;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.console.ConsoleConnector;
import org.sylvani.bot.dialogs.Choice;
import org.sylvani.bot.dialogs.Decision;
import org.sylvani.bot.dialogs.IDialog;
import org.sylvani.bot.dialogs.Interview;
import org.sylvani.bot.dialogs.Question;
import org.sylvani.bot.dialogs.Utterance;
import org.sylvani.bot.universal.UniversalBot;
import org.sylvani.bot.util.IModel;
import org.sylvani.bot.util.Model;
import org.sylvani.bot.util.SessionModel;;

/**
 * @author Harald Kuhn
 *
 */
public class WaterfallBot extends UniversalBot {

	public WaterfallBot(IConnector connector) {
		super(connector);
	}

	public static void main(String[] args) {
		BasicConfigurator.configure();
		WaterfallBot bot = new WaterfallBot(new ConsoleConnector());

		List<Choice<String>> choices = new ArrayList<>();
		choices.add(new Choice<String>("Java", "Java"));
		choices.add(new Choice<String>("Groovy", "Groovy"));
		choices.add(new Choice<String>("Scala", "Scala"));

		// String[] choices = new String[] { "Java", "Groovy", "Scala" };

		bot.setWelcomeDialog(new Interview(new IDialog[] {

		        new Question<String>(new SessionModel<>("name")) {
			        @Override
			        public org.sylvani.bot.util.IModel<String> getText(IActivity request, ISession session) {
				        return new Model<String>(session.getResolvedResource("hello"));
			        };
		        },

		        new Question<Integer>(new SessionModel<>("experience")) {
			        @Override
			        public IModel<String> getText(IActivity request, ISession session) {
				        return new Model<String>(session.getResolvedResource("yearsCoding"));
			        };
		        },

		        new Decision<String>(new SessionModel<>("language"), choices) {
			        @Override
			        public IModel<String> getText(IActivity request, ISession session) {
				        return new Model<String>(session.getResolvedResource("whatLanguage"));
			        };
		        },
		        //
		        // new IDialog() {
		        //
		        // @Override
		        // public void handle(ISession session, IActivity activity) {
		        // IActivity reply = session.getConnector().newReplyTo(activity);
		        // String experience = activity.getText();
		        // session.setAttribute("experience", experience);
		        // StringBuilder text = new StringBuilder("What language do you code Java in?");
		        // String[] choices = new String[] { "Java", "Groovy", "Scala" };
		        // for (int i = 0; i < choices.length; i++) {
		        // text.append("\n" + (i + 1) + "." + choices[i]);
		        // }
		        // reply.setText(text.toString());
		        // session.send(reply);
		        // }
		        //
		        // },

		        new Utterance() {
			        @Override
			        public IModel<String> getText(IActivity request, ISession session) {
				        return new Model<String>(session.getResolvedResource("gotIt"));
			        };
		        }

		}));

	}

}
