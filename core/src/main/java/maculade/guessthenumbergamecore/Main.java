package maculade.guessthenumbergamecore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)

        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get numberGenerator bean from application context (as blueprint in python flask)
        NumberGenerator numberGenerator
                = context.getBean("numberGenerator", NumberGenerator.class);

        // call method next()

        int number = numberGenerator.next();

        log.info("number = {}", number);

        // get game bean from application context
        Game game = context.getBean(Game.class);
        game.reset();

        // close context (container)
        context.close();
    }
}
