package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static JFrame frame;

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            DroolsTest.createAndShowGUI();
            // go !
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static String askUser(String question, String option1, String option2) {
        Object[] options = {option1, option2};
        int response = JOptionPane.showOptionDialog(DroolsTest.frame,
                question,
                "Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        return options[response].toString();
        //System.out.println(question.getContent() + " -> "+ question.getResponse());
    }

    public static String askUser(String question, String option1, String option2, String option3) {
        Object[] options = {option1, option2, option3};
        int response = JOptionPane.showOptionDialog(DroolsTest.frame,
                question,
                "Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        return options[response].toString();
        //System.out.println(question.getContent() + " -> "+ question.getResponse());
    }

    public static void finalWindow(String content) {
        System.out.println("Perfect Video game! -> "+ content);
        JOptionPane.showMessageDialog(DroolsTest.frame, "Perfect video game for You: "+ content);
        DroolsTest.frame.dispose();
    }

    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame( "How To Pick the Perfect Video Game" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null); // Center in screen
        frame.setVisible( true );

        DroolsTest.frame = frame;
    }

}
