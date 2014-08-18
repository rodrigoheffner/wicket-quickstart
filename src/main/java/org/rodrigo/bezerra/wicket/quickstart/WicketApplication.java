package org.rodrigo.bezerra.wicket.quickstart;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.rodrigo.bezerra.wicket.quickstart.page.PageManager;
import org.rodrigo.bezerra.wicket.quickstart.page.PageModel;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 *
 * @see org.rodrigo.bezerra.Start#main(String[])
 */
public class WicketApplication extends AuthenticatedWebApplication {

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();
        
        // Mounting pages
        for (PageModel pageModel : PageManager.getInstance().getPages()) {
            mountPage(pageModel.getUrl(), pageModel.getPageClass());
        }
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return Session.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
