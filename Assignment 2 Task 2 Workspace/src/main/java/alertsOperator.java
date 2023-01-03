public class alertsOperator
{
    boolean alertsDeleted = false;
    boolean alertsPosted = false;
    boolean intendedNumberOfAlertsPosted = false;
    boolean alertsCorrectlyPosted = false;
    boolean alertsIncorrectlyPosted = false;

    boolean alertsNotDeleted()
    {
        if(alertsDeleted == false)
        {
            alertsPosted = false;
            intendedNumberOfAlertsPosted = false;
            alertsCorrectlyPosted = false;
            alertsIncorrectlyPosted = false;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean alertsDeleted()
    {
//        if(alertsDeleted == true)
//        {
//            alertsPosted = false;
//            intendedNumberOfAlertsPosted = false;
//            alertsCorrectlyPosted = false;
//            return true;
//        }

        if(alertsPosted == false &&intendedNumberOfAlertsPosted == false && alertsCorrectlyPosted == false)
        {
            alertsDeleted = true;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean unsuccessfullyPostAlerts()
    {
        if(alertsDeleted == true && alertsPosted == false)
        {
            intendedNumberOfAlertsPosted = false;
            alertsCorrectlyPosted = false;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean successfullyPostAlerts()
    {
//        if(alertsDeleted == true && alertsPosted == true)
//        {
//            intendedNumberOfAlertsPosted = false;
//            alertsCorrectlyPosted = false;
//            return true;
//        }

        if(alertsDeleted == true && intendedNumberOfAlertsPosted == false && alertsCorrectlyPosted == false)
        {
            alertsPosted = true;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean unintendedNumberOfAlertsPosted()
    {
        if(alertsDeleted == true && alertsPosted == true && intendedNumberOfAlertsPosted == false)
        {
            alertsCorrectlyPosted = false;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean intendedNumberOfAlertsPosted()
    {
        if(alertsDeleted == true && alertsPosted == true && alertsCorrectlyPosted == false)
        {
            intendedNumberOfAlertsPosted = true;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean alertsIncorrectlyPosted()
    {
        if(alertsDeleted == true && alertsPosted == true && intendedNumberOfAlertsPosted == true && alertsCorrectlyPosted == false)
        {
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean alertsCorrectlyPosted()
    {
        if(alertsDeleted == true && alertsPosted == true && intendedNumberOfAlertsPosted == true)
        {
             alertsCorrectlyPosted = true;
             return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean isAlertsDeleted()
    {
        return alertsDeleted;
    }

    boolean isAlertsPosted()
    {
        return alertsPosted;
    }

    boolean isIntendedNumberOfAlertsPosted()
    {
        return intendedNumberOfAlertsPosted;
    }

    public boolean isAlertsCorrectlyPosted()
    {
        return alertsCorrectlyPosted;
    }
}
