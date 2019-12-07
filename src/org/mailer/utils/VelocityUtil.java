package org.mailer.utils;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * @author 
 * 
 */
public class VelocityUtil {

	/**
	 * This function evaluates a given velocity expression using the velocity
	 * engine.
	 * 
	 * @param template
	 *            the velocity template string that is to be evaluated
	 * @param parameters
	 *            the parameters to be used in the templates.
	 * @return the evaluated string.
	 */
	@SuppressWarnings("unchecked")
	public static String velocityEval(String template, Map parameters)
			throws Exception {
		VelocityContext context = new VelocityContext();
		Set keySet = parameters.keySet();
		Iterator iter = keySet.iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			Object value = parameters.get(key);
			context.put(key.toString(), value);
		}
		StringWriter writer = new StringWriter();

		Velocity.init();
		Velocity.evaluate(context, writer, "LOG", template);
		return writer.getBuffer().toString();
	}

}
