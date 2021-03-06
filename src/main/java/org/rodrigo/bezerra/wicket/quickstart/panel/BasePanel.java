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

package org.rodrigo.bezerra.wicket.quickstart.panel;

import org.apache.wicket.markup.html.panel.Panel;
import org.rodrigo.bezerra.wicket.quickstart.Session;
import org.rodrigo.bezerra.wicket.quickstart.WicketApplication;

/**
 *
 * @author rodrigo
 */
public class BasePanel extends Panel{

    public BasePanel(String id) {
        super(id);
    }

    @Override
    public Session getSession() {
        return (Session)super.getSession(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public WicketApplication getWebApplication() {
        return (WicketApplication)getApplication();
    }
}
