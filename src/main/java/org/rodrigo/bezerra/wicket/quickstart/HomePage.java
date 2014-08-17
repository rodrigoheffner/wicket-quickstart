package org.rodrigo.bezerra.wicket.quickstart;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.rodrigo.bezerra.wicket.quickstart.page.Order;
import org.rodrigo.bezerra.wicket.quickstart.page.PageLabel;
import org.rodrigo.bezerra.wicket.quickstart.page.PageModel.MenuOrder;
import org.rodrigo.bezerra.wicket.quickstart.page.Url;

@Url("/home.html")
@PageLabel("/Home")
@Order(MenuOrder.PRIMARY)
@AuthorizeInstantiation("test")
public class HomePage extends BootstrapPage {
    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);
    }
}