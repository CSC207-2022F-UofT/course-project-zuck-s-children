package notification.Present;

import notification.Present.NotifResponseModel;

//use case layer
public interface ShowNotifOutputBoundary {
    void prepareDisplayView(NotifResponseModel response);
}
