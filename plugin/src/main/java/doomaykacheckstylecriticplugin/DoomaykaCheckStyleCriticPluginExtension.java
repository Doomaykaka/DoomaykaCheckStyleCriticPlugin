package doomaykacheckstylecriticplugin;

public class DoomaykaCheckStyleCriticPluginExtension {
    private int errorMultiplier = 1;
    private int warningMultiplier = 1;
    private int refactorMultiplier = 1;
    private int conventionMultiplier = 1;
    private String[] errorMessages = {};
    private String[] warningMessages = {};
    private String[] refactorMessages = {};
    private String[] conventionMessages = {};
    private String XMLpath = "";
    private String XMLname = "";
    private String[] messages = {};

    public int getErrorMultiplier() {
        return errorMultiplier;
    }

    public void setErrorMultiplier(int errorMultiplier) {
        this.errorMultiplier = errorMultiplier;
    }

    public int getWarningMultiplier() {
        return warningMultiplier;
    }

    public void setWarningMultiplier(int warningMultiplier) {
        this.warningMultiplier = warningMultiplier;
    }

    public int getRefactorMultiplier() {
        return refactorMultiplier;
    }

    public void setRefactorMultiplier(int refactorMultiplier) {
        this.refactorMultiplier = refactorMultiplier;
    }

    public int getConventionMultiplier() {
        return conventionMultiplier;
    }

    public void setConventionMultiplier(int conventionMultiplier) {
        this.conventionMultiplier = conventionMultiplier;
    }

    public String[] getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(String[] errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String[] getWarningMessages() {
        return warningMessages;
    }

    public void setWarningMessages(String[] warningMessages) {
        this.warningMessages = warningMessages;
    }

    public String[] getRefactorMessages() {
        return refactorMessages;
    }

    public void setRefactorMessages(String[] refactorMessages) {
        this.refactorMessages = refactorMessages;
    }

    public String[] getConventionMessages() {
        return conventionMessages;
    }

    public void setConventionMessages(String[] conventionMessages) {
        this.conventionMessages = conventionMessages;
    }

    public String getXMLpath() {
        return XMLpath;
    }

    public void setXMLpath(String xMLpath) {
        XMLpath = xMLpath;
    }

    public String getXMLname() {
        return XMLname;
    }

    public void setXMLname(String xMLname) {
        XMLname = xMLname;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }
}
