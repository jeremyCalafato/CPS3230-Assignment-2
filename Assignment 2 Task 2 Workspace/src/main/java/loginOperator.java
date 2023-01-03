public class loginOperator
{
    boolean loggedOut = false;
    boolean loggedIn = false;
    boolean viewingAlerts = false;

    boolean incorrectLogin()
    {
        if(loggedIn == false && viewingAlerts == false)
        {
            loggedOut = true;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean correctLogin()
    {
        if(loggedOut == false)
        {
            loggedIn = true;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean viewAlerts()
    {
        if(loggedOut == false && loggedIn == true)
        {
            viewingAlerts = true;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean logout()
    {
        if(viewingAlerts == true)
        {
            loggedOut = true;
            return true;
        }

        else
        {
            throw new IllegalStateException();
        }
    }

    boolean isLoggedOut()
    {
        return loggedOut;
    }

    boolean isLoggedIn()
    {
        return loggedIn;
    }

    boolean isViewingAlerts()
    {
        return viewingAlerts;
    }

    boolean onlyLoggedInOrLoggedOutIsTrue()
    {
        if(loggedOut == false)
        {
            return loggedIn = true;
        }

        else
        {
            return loggedIn = false;
        }
    }

    boolean onlyViewingAlertsOrLoggedOutIsTrue()
    {
        if(loggedOut == false)
        {
            return viewingAlerts = true;
        }

        else
        {
            return viewingAlerts = false;
        }
    }
}
