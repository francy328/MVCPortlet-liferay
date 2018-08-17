<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>


<!-- ci sono due fasi in una portlet (in realta so 4) ma le due definite nella prima specifica sono:
  1. render fase: la portlet si disegna usando la vista fornita in questo calo la pagina view.jsp
  2.action phase: la portlet esegue unna azione che può essere salvare dati sul db ad esempio o qualunque cosa
 -->



<portlet:defineObjects />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addEntry" var="addEntryURL"></portlet:actionURL>

<aui:form action="<%=addEntryURL%>" name="<portlet:namespace />fm">
	<aui:fieldset>
		<aui:input name="nome "></aui:input>
		<aui:input name="messaggio"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button onClick="<%= viewURL.toString() %>" type="cancel"></aui:button>
	</aui:button-row>
</aui:form>

