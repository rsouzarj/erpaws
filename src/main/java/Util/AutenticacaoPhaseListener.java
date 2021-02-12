package Util;

import java.io.PrintStream;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AutenticacaoPhaseListener implements PhaseListener
{
  Object currentUser = null;
  
  public void afterPhase(PhaseEvent event)
  {
    FacesContext facesContext = event.getFacesContext();
    String currentPage = facesContext.getViewRoot().getViewId();
    System.out.println(currentPage);
    

    boolean isLoginPage = (currentPage.lastIndexOf("/login/login.xhtml") > -1) || (currentPage.lastIndexOf("/documento/boleto.xhtml") > -1) || (currentPage.lastIndexOf("/pesquisa.xhtml") > -1);
    

    HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
    this.currentUser = session.getAttribute("currentUser");
    
    if ((!isLoginPage) && (this.currentUser == null)) {
      NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
      nh.handleNavigation(facesContext, null, "/login/login.xhtml");
    }
  }
  
  public void beforePhase(PhaseEvent event) {}
  
  public PhaseId getPhaseId()
  {
    return PhaseId.RESTORE_VIEW;
  }
}
