/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import org.eclipse.xtext.ui.editor.model.DocumentUtil;
import org.eclipse.xtext.ui.editor.model.XtextDocument;



/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DocumentUtilTest extends AbstractXtextDocumentTest {
	
	DocumentUtil util = new DocumentUtil();
	
	public void testSearchInSamePartition() throws Exception {
		XtextDocument document = getDocument("{/*{*/}/*}*/ ");
		assertEquals(3,util.searchBackwardsInSamePartition("{", document, 10).getOffset());
		assertEquals(0,util.searchBackwardsInSamePartition("{", document, document.getLength()-1).getOffset());
		assertEquals(null,util.searchBackwardsInSamePartition("{", document, 0));
		assertEquals(0,util.searchInSamePartition("{", document, 0).getOffset());
		assertEquals(3,util.searchInSamePartition("{", document, 1).getOffset());
		assertEquals(6,util.searchInSamePartition("}", document, 0).getOffset());
		assertEquals(9,util.searchInSamePartition("}", document, 7).getOffset());
	}
	
	public void testSearchBackwards_1() throws Exception {
		assertEquals(3,util.searchBackwardsInSamePartition("foo", getDocument("   foo   /*  foo */  "), 20).getOffset());
	}
}
