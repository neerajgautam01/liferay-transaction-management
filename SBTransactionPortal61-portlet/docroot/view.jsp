<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %><%@
taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="javax.portlet.PortletURL" %>

<portlet:defineObjects />

This is the <b>SBTransaction</b> portlet.

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	String currentURL = portletURL.toString();
%>

<portlet:actionURL var="refreshURL" windowState="normal">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

	<aui:form action="<%= refreshURL %>" method="post" name="fm">
		<aui:button type="submit" value="refresh" />
	</aui:form>