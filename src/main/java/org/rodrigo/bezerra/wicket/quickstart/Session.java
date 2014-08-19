/*
 * Copyright 2014 Rodrigo Bezerra.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.rodrigo.bezerra.wicket.quickstart;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.rodrigo.bezerra.wicket.quickstart.page.PageManager;
import org.rodrigo.bezerra.wicket.quickstart.page.PageModel;

/**
 *
 * @author rodrigo
 */
public class Session extends AuthenticatedWebSession{

    private PageModel selectedPageModel = PageManager.getInstance().getPages().get(0);
    
    public Session(Request request) {
        super(request);
    }

    @Override
    public boolean authenticate(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Roles getRoles() {
        return new Roles();
    }

    public PageModel getSelectedPageModel() {
        return selectedPageModel;
    }

    public void setSelectedPageModel(PageModel selectedPageModel) {
        this.selectedPageModel = selectedPageModel;
    }
}
