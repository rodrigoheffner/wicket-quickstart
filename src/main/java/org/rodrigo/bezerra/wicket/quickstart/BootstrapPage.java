/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rodrigo.bezerra.wicket.quickstart;

import org.apache.wicket.bootstrap.Bootstrap;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;


/**
 *
 * @author rodrigo
 */
public class BootstrapPage extends WebPage {
    public BootstrapPage() {
        
    }
    
    public BootstrapPage(PageParameters parameters) {
        super(parameters);
    }
    
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        
        Bootstrap.renderHeadResponsive(response);
    }
}