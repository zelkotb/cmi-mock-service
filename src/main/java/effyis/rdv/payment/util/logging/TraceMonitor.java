package effyis.rdv.payment.util.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Configuration
public class TraceMonitor {

	private static final Logger LOGGER = LoggerFactory.getLogger(TraceMonitor.class);

	@Before(value = "execution(* effyis.rdv.payment.controller.*.*(..))")
	public void traceRequest(final JoinPoint jointPoint) {

		final Object[] args = jointPoint.getArgs();
		final StringBuilder sb = new StringBuilder();
		final CodeSignature signature = (CodeSignature) jointPoint.getSignature();
		sb.append("\n Method: ").append(jointPoint.getSignature().getName()).append("\n Request: { ");
		for (int i = 0; i < args.length; i++) {
			if (args[i] != null) {
				sb.append("\n");
				sb.append("   ");
				sb.append(signature.getParameterNames()[i]);
				sb.append(" : ");
				sb.append(args[i].toString());
			}
		}
		sb.append("\n }");
		TraceMonitor.LOGGER.info(sb.toString());
	}
}
