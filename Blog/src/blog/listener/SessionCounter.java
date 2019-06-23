package blog.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCounter
 *
 */
@WebListener
public class SessionCounter implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	public static int counter = 0;
    public SessionCounter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	counter++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	if(counter > 0) {
    		counter--;
    	}
    }
    
    public static int onlineCounter() {
		// TODO Auto-generated method stub
    	return counter;
	}
	
}
