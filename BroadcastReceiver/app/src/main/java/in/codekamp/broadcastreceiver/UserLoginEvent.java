package in.codekamp.broadcastreceiver;

/**
 * Created by cerebro on 27/03/17.
 */

public class UserLoginEvent {
    public User loggedinUser;

    public UserLoginEvent(User loggedinUser) {
        this.loggedinUser = loggedinUser;
    }
}
