class InterviewBot {

    String botName;
    String technology;

    public InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    public void conductInterview() {
        System.out.println(botName +
                " is conducting " +
                technology +
                " interview.");
    }

    public static void main(String[] args) {

        InterviewBot b1 =
                new InterviewBot("JavaBot", "Java");

        InterviewBot b2 =
                new InterviewBot("ReactBot", "React");

        InterviewBot b3 =
                new InterviewBot("PythonBot", "Python");

        b1.conductInterview();
        b2.conductInterview();
        b3.conductInterview();
    }
}