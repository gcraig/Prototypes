import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

public class ListInvoicesController implements Controller {
	
	private String viewName;

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

    public ModelAndView handleRequest(
        HttpServletRequest request,
        HttpServletResponse response)
    throws Exception {
		// do some processing
		return new ModelAndView( viewName, "curdate", new Date() );
    }
}