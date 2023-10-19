package doomaykacheckstylecriticplugin;

import java.util.Arrays;
import java.util.List;

import org.gradle.api.Project;

public class App {
    public static void start(Project project, DoomaykaCheckStyleCriticPluginExtension extension) {
        // User script variables
        String XMLpath = extension.getXMLpath();
        String XMLname = extension.getXMLname();

        List<String> errorMessages = Arrays.asList(extension.getErrorMessages());
        List<String> warningMessages = Arrays.asList(extension.getWarningMessages());
        List<String> refactorMessages = Arrays.asList(extension.getRefactorMessages());
        List<String> conventionMessages = Arrays.asList(extension.getConventionMessages());

        int errorMultiplier = extension.getErrorMultiplier();
        int warningMultiplier = extension.getWarningMultiplier();
        int refactorMultiplier = extension.getRefactorMultiplier();
        int conventionMultiplier = extension.getConventionMultiplier();

        // Console messages
        String[] messages = extension.getMessages();

        CheckStyleParser csp;

        csp = new CheckStyleParser(project);

        if (!XMLname.isEmpty()) {
            csp = new CheckStyleParser(project, XMLname);
        }

        if ((!XMLpath.isEmpty()) && (!XMLname.isEmpty())) {
            csp = new CheckStyleParser(XMLpath, XMLname);
        }

        csp.readXML();
        CheckStyleModel model = csp.getXmlUnparsed();

        CodeCounter counter = new CodeCounter(
            model,
            errorMultiplier,
            warningMultiplier,
            refactorMultiplier,
            conventionMultiplier
        );

        if (!errorMessages.isEmpty()) {
            counter.setErrorMessages(errorMessages);
        }

        if (!warningMessages.isEmpty()) {
            counter.setWarningMessages(warningMessages);
        }

        if (!refactorMessages.isEmpty()) {
            counter.setRefactorMessages(refactorMessages);
        }

        if (!conventionMessages.isEmpty()) {
            counter.setConventionMessages(conventionMessages);
        }

        float rating = 0;
        rating = counter.calculate();

        MessageGenerator mGenerator = new MessageGenerator(
            rating,
            counter.getLinesPrepared(),
            errorMultiplier,
            warningMultiplier,
            refactorMultiplier,
            conventionMultiplier,
            counter.getErrorsCounter(),
            counter.getWarningsCounter(),
            counter.getRefactorsCounter(),
            counter.getConventionsCounter(),
            messages
        );
        mGenerator.printMessages();
    }
}
