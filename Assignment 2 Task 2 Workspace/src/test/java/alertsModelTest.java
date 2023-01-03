import junit.framework.Assert;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.util.Random;

public class alertsModelTest implements FsmModel
{
    alertsOperator sut = new alertsOperator();

    alertsStatesEnum stateEnum = alertsStatesEnum.viewingAlerts;
    boolean alertsDeleted = false;
    boolean alertsPosted = false;
    boolean intendedNumberOfAlertsPosted = false;
    boolean alertsCorrectlyPosted = false;
    boolean alertsIncorrectlyPosted = false;

    @Override
    public alertsStatesEnum getState()
    {
        return stateEnum;
    }

    @Override
    public void reset(boolean b)
    {
        if(b)
        {
            sut = new alertsOperator();
        }

        boolean alertsDeleted = false;
        boolean alertsPosted = false;
        boolean intendedNumberOfAlertsPosted = false;
        boolean alertsCorrectlyPosted = false;
        stateEnum = alertsStatesEnum.viewingAlerts;
    }

    public boolean alertsNotDeletedGuard()
    {
        return getState().equals(alertsStatesEnum.viewingAlerts);
    }

    public @Action
    void alertsNotDeleted()
    {
        sut.alertsNotDeleted();
        stateEnum = alertsStatesEnum.unwantedListOfAlerts;
        alertsDeleted = false;

        Assert.assertEquals(alertsDeleted, sut.isAlertsDeleted());
    }

    public boolean alertsDeletedGuard()
    {
        return getState().equals(alertsStatesEnum.viewingAlerts);
    }

    public @Action
    void alertsDeleted()
    {
        sut.alertsDeleted();
        stateEnum = alertsStatesEnum.emptyListOfAlerts;
        alertsDeleted = true;

        Assert.assertEquals(alertsDeleted, sut.isAlertsDeleted());
    }

    public boolean unsuccessfullyPostAlertsGuard()
{
    return getState().equals(alertsStatesEnum.emptyListOfAlerts);
}

    public @Action
    void unsuccessfullyPostAlerts()
    {
        sut.unsuccessfullyPostAlerts();
        stateEnum = alertsStatesEnum.emptyListOfAlerts;
        alertsPosted = false;

        Assert.assertEquals(alertsPosted, sut.isAlertsPosted());
    }

    public boolean successfullyPostAlertsGuard()
    {
        return getState().equals(alertsStatesEnum.emptyListOfAlerts);
    }

    public @Action
    void successfullyPostAlerts()
    {
        sut.successfullyPostAlerts();
        stateEnum = alertsStatesEnum.populatedListOfAlerts;
        alertsPosted = true;

        Assert.assertEquals(alertsPosted, sut.isAlertsPosted());
    }

    public boolean unintendedNumberOfAlertsPostedGuard()
    {
        return getState().equals(alertsStatesEnum.populatedListOfAlerts);
    }

    public @Action
    void unintendedNumberOfAlertsPosted()
    {
        sut.unintendedNumberOfAlertsPosted();
        stateEnum = alertsStatesEnum.populatedListOfAlertsContainingUnintendedNumberOfAlerts;
        intendedNumberOfAlertsPosted = false;

        Assert.assertEquals(intendedNumberOfAlertsPosted, sut.isIntendedNumberOfAlertsPosted());
    }

    public boolean intendedNumberOfAlertsPostedGuard()
{
    return getState().equals(alertsStatesEnum.populatedListOfAlerts);
}

    public @Action
    void intendedNumberOfAlertsPosted()
    {
        sut.intendedNumberOfAlertsPosted();
        stateEnum = alertsStatesEnum.populatedListOfAlertsContainingIntendedNumberOfAlerts;
        intendedNumberOfAlertsPosted = true;

        Assert.assertEquals(intendedNumberOfAlertsPosted, sut.isIntendedNumberOfAlertsPosted());
    }

    public boolean alertsIncorrectlyPostedGuard()
    {
        return getState().equals(alertsStatesEnum.populatedListOfAlertsContainingIntendedNumberOfAlerts);
    }

    public @Action
    void alertsIncorrectlyPosted()
    {
        sut.alertsIncorrectlyPosted();
        stateEnum = alertsStatesEnum.incorrectlyPopulatedListOfAlerts;
        alertsCorrectlyPosted = false;

        Assert.assertEquals(alertsCorrectlyPosted, sut.isAlertsCorrectlyPosted());
    }


    public boolean alertsCorrectlyPostedGuard()
    {
        return getState().equals(alertsStatesEnum.populatedListOfAlertsContainingIntendedNumberOfAlerts);
    }

    public @Action
    void alertsCorrectlyPosted()
    {
        sut.alertsCorrectlyPosted();
        stateEnum = alertsStatesEnum.correctlyPopulatedListOfAlerts;
        alertsCorrectlyPosted = true;

        Assert.assertEquals(alertsCorrectlyPosted, sut.isAlertsCorrectlyPosted());
    }

    @Test
    public void alertsModelRunner() {
        final GreedyTester tester = new GreedyTester(new alertsModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }
}
