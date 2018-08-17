package it.esempio;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import model.Entry;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class PhaseAndLifecyclePortlet extends MVCPortlet {

 //define log for this class
 private static final Log _log = LogFactoryUtil.getLog(PhaseAndLifecyclePortlet.class.getName());
 
 //This method is defined in MVCPortlet
 @Override
 public void init() throws PortletException {
  _log.info(" This is init method without parameter");
  _log.debug("pippoooo");
  super.init();
 }

 //This method is defined in GenericPortlet
 @Override
 public void init(PortletConfig config) throws PortletException {
  String viewTemplate = config.getInitParameter("view-template");
  _log.info("Init Parameter of viewTemplatei is ==>"+viewTemplate);
  _log.info(" This is init method with PortletConfig parameter");
  super.init(config);
 }
 
 
 @Override
 public void render(RenderRequest renderRequest, RenderResponse response)
   throws PortletException, IOException {
  _log.info(" This is render method of PhaseAndLifecyclePortlet");
  _log.debug("paperino");
  _log.warn("papapap");
  
  javax.portlet.PortletPreferences prefs = renderRequest.getPreferences();
  String[] guestbookEntries = prefs.getValues("guestbook-entries",
          new String[1]);
  
  if (guestbookEntries != null) {

      List<Entry> entries = parseEntries(guestbookEntries);

      renderRequest.setAttribute("entries", entries);
  }
   
  
  super.render(renderRequest, response);
 }
 
 
 
 
 
 private List<Entry> parseEntries(String[] guestbookEntries) {
	 ArrayList<Entry> entries = new ArrayList();

	    for (String entry : guestbookEntries) {
	        String[] parts = entry.split("\\^", 2);
	        Entry gbEntry = new Entry(parts[0], parts[1]);
	        entries.add(gbEntry);
	    }

	    return entries;
}

public void addEntry(ActionRequest request, ActionResponse response) {
	 try {

	       javax.portlet.PortletPreferences prefs = request.getPreferences();

	       String[] guestbookEntries = prefs.getValues("guestbook-entries",
	          new String[1]);

	       ArrayList<String> entries = new ArrayList<String>();

	       if (guestbookEntries != null) {

	         entries = new ArrayList<String>(Arrays.asList(prefs.getValues(
	              "guestbook-entries", new String[1])));

	       }

	       String userName = ParamUtil.getString(request, "nome");
	       String message = ParamUtil.getString(request, "messaggio");
	       String entry = userName + "^" + message;

	       entries.add(entry);

	       String[] array = entries.toArray(new String[entries.size()]);

	       prefs.setValues("guestbook-entries", array);

	       try {

	         prefs.store();

	       } catch (IOException ex) {

	         Logger.getLogger(PhaseAndLifecyclePortlet.class.getName()).log(
	              Level.SEVERE, null, ex);

	       } catch (ValidatorException ex) {

	         Logger.getLogger(PhaseAndLifecyclePortlet.class.getName()).log(
	              Level.SEVERE, null, ex);

	       }

	    } catch (ReadOnlyException ex) {

	       Logger.getLogger(PhaseAndLifecyclePortlet.class.getName()).log(
	          Level.SEVERE, null, ex);

	    }

	}
 
 
}