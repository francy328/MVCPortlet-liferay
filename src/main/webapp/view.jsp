<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>




<portlet:defineObjects />

<jsp:useBean id="entries" class="java.util.ArrayList" scope="request"/>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= entries %>"
	/>

	<liferay-ui:search-container-row
		className="model.Entry"
		modelVar="aEntry"
	>
	
		<liferay-ui:search-container-column-text property="message" />

		<liferay-ui:search-container-column-text property="name" />

		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
.

<!-- aggiungo un bottone e mappo l'url di questo bottono echo la vista /edit_entry.jsp -->
<aui:button-row cssClass="guestbook-buttons">

	<portlet:renderURL var="addEntryURL">
		<portlet:param name="mvcPath" value="/edit_entry.jsp"></portlet:param>
	</portlet:renderURL>
	<aui:button onClick="<%=addEntryURL.toString()%>" value="add entry"></aui:button>
</aui:button-row>




