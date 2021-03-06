/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug291022TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug291022TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug291022Test extends AbstractContentAssistTest {

	@Test public void testBug291022_01() throws Exception {
		newBuilder().append(
				"rootModelElement {\n" +
				"  rootModelElement modelElement {" +
				"  }\n" + 
				"}").assertTextAtCursorPosition("modelElement {", "rootModelElement", ":", "=", ";", "{");
	}
	
	@Test public void testBug291022_02() throws Exception {
		newBuilder().append(
				"rootModelElement {\n" +
				"  rootModelElement : modelElement {" +
				"    modelElement findMe {" +
				"    }\n" +
				"  }\n" + 
				"}").assertTextAtCursorPosition("findMe", "modelElement", ":", "=", ";", "{");
	}

}